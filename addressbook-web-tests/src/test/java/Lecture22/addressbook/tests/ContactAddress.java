package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Contact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddress extends CommonMethods {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() ==0) {
      app.contactMethods().fastCreate(app);
    }
  }

  @Test
  public void testAddress() {
    Contact contact = app.contactMethods().all().iterator().next();
    Contact infoFromEditForm = app.contactMethods().infoFromEditForm(contact);

    assertThat(contact.getAddress(), equalTo(infoFromEditForm.getAddress()));
  }
}
