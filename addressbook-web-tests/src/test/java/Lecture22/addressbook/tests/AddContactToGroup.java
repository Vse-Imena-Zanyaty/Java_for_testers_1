package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Contact;
import Lecture22.addressbook.objects.Contacts;
import Lecture22.addressbook.objects.Group;
import Lecture22.addressbook.objects.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroup extends CommonMethods {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groupsWithoutContacts().size() == 0) {
      app.goTo().GroupPage();
      app.groupMethods().create(new Group().withName("testAddingContactToGroup"), app);
      app.goTo().returnHome();
    }
    if (app.db().contactsWithoutGroups().size() == 0) {
      app.contactMethods().fastCreate(app);
    }
  }

  @Test
  public void testAddingContactToGroup() {
    Contacts contactsBefore = app.db().contactsWithoutGroups();
    Groups groupsBefore = app.db().groupsWithoutContacts();
    Contact modifiedContact = contactsBefore.iterator().next();
    Group modifiedGroup = groupsBefore.iterator().next();
    app.contactMethods().addToGroup(modifiedContact, modifiedGroup);
    app.contactMethods().assertAdding(modifiedContact);
    Contacts contactsAfter = app.db().contactsWithoutGroups();
    Groups groupsAfter = app.db().groupsWithoutContacts();
    assertThat(contactsAfter, equalTo(contactsBefore.without(modifiedContact)));
    assertThat(groupsAfter, equalTo(groupsBefore.without(modifiedGroup)));
  }
}