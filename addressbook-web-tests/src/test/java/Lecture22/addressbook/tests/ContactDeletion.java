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
    if (app.db().contacts().size() ==0) {
      app.contactMethods().fastCreate(app);
    }
  }

  @Test
  public void testContactDeletion() {
    Contacts before = app.db().contacts();
    Contact deletedContact = before.iterator().next();
    app.contactMethods().delete(deletedContact, app);
    assertThat(app.contactMethods().count(), equalTo(before.size() - 1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
