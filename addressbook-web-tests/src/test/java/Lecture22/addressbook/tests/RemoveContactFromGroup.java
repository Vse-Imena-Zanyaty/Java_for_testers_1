package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Contact;
import Lecture22.addressbook.objects.Group;
import Lecture22.addressbook.objects.Groups;
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
      if (app.db().groupsWithoutContacts().size() == 0) {
        app.goTo().GroupPage();
        app.groupMethods().create(new Group().withName("testRemovingContactFromGroup"), app);
        app.goTo().returnHome();
      }
      Contact modifiedContact = app.db().contactsWithoutGroups().iterator().next();
      Group modifiedGroup = app.db().groupsWithoutContacts().iterator().next();
      app.contactMethods().addToGroup(modifiedContact, modifiedGroup);
      app.contactMethods().assertAdding(modifiedContact);
    }
  }

  @Test
  public void testRemovingContactFromGroup() {
    Contact modifiedContact = app.db().contactsWithGroups().iterator().next();
    Groups contactGroupsBefore = new Groups(modifiedContact.getGroups());
    Group modifiedGroup = contactGroupsBefore.iterator().next();
    app.contactMethods().removeFromGroup(modifiedContact, modifiedGroup);
    app.contactMethods().assertRemoving(modifiedContact);
    Groups contactGroupsAfter = new Groups(modifiedContact.getGroups());
    assertThat(contactGroupsAfter, equalTo(contactGroupsBefore.withAdded(modifiedGroup)));
  }
}
