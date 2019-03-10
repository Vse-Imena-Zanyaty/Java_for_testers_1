package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactDeletion extends CommonMethods {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contactMethods().contactExists(app);
  }

  @Test
  public void testContactDeletion() {
    Set<Contact> before = app.contactMethods().all();
    Contact deletedContact = before.iterator().next();
    app.contactMethods().delete(deletedContact, app);
    Set<Contact> after = app.contactMethods().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }
}
