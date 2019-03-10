package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Contact;
import Lecture22.addressbook.objects.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletion extends CommonMethods {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contactMethods().contactExists(app);
  }

  @Test
  public void testContactDeletion() {
    Contacts before = app.contactMethods().all();
    Contact deletedContact = before.iterator().next();
    app.contactMethods().delete(deletedContact, app);
    Contacts after = app.contactMethods().all();
    assertThat(after.size(), equalTo(before.size() - 1));
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
