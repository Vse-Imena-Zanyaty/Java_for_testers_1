package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Contact;
import Lecture22.addressbook.objects.Contacts;
import Lecture22.addressbook.objects.Group;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemoveContactFromGroup extends CommonMethods {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contactsWithGroups().size() == 0) {
      if (app.db().contactsWithoutGroups().size() == 0) {
        app.contactMethods().create(new Contact().withFirstName("first_name").withLastName("last_name"), app);
      }
      if (app.db().groups().size() == 0) {
        app.groupMethods().create(new Group().withName("testRemovingContactFromGroup"), app);
        app.goTo().returnHome();
      }
      app.goTo().returnHome();
      Contact modifiedContact = app.db().contactsWithoutGroups().iterator().next();
      Group modifiedGroup = app.db().groupsWithoutContacts().iterator().next();
      app.contactMethods().addToGroup(modifiedContact, modifiedGroup);
      app.contactMethods().assertAdding(modifiedContact);
    }
  }

  @Test
  public void testRemovingContactFromGroup() {
    Contacts contactsBefore = app.db().contacts();
    Contact modifiedContact = app.db().contactsWithGroups().iterator().next();
    Group modifiedGroup = modifiedContact.getGroups().iterator().next();
    app.goTo().returnHome();
    app.contactMethods().removeFromGroup(modifiedContact, modifiedGroup);
    app.contactMethods().assertRemoving(modifiedContact);
    Contacts contactsAfter = app.db().contacts();
    assertThat(contactsAfter.iterator().next().getGroups(), equalTo
            (contactsBefore.iterator().next().getGroups().without(modifiedGroup)));

  }
}
