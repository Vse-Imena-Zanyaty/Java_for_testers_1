package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Contact;
import Lecture22.addressbook.objects.Contacts;
import Lecture22.addressbook.objects.Group;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroup extends CommonMethods {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contactsWithoutGroups().size() == 0) {
      app.contactMethods().create(new Contact().withFirstName("first_name").withLastName("last_name"), app);
    }
    if (app.db().groups().size() == 0) {
      app.goTo().GroupPage();
      app.groupMethods().create(new Group().withName("testAddingContactToGroup"), app);
      app.goTo().returnHome();
    }
  }

  @Test
  public void testAddingContactToGroup() {
    Contacts contactsBefore = app.db().contacts();
    Contact modifiedContact = app.db().contactsWithoutGroups().iterator().next();
    Group modifiedGroup = app.db().groups().iterator().next();
    app.contactMethods().addToGroup(modifiedContact, modifiedGroup);
    app.contactMethods().assertAdding(modifiedContact);
    Contacts contactsAfter = app.db().contacts();
    assertThat(contactsAfter.iterator().next().getGroups(), equalTo
            (contactsBefore.iterator().next().getGroups().withAdded(modifiedGroup)));
  }
}