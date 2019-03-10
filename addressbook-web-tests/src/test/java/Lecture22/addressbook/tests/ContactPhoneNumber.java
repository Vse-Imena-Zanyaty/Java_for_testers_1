package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Contact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneNumber extends CommonMethods {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contactMethods().contactExists(app);
  }

  @Test
  public void testPhoneNumbers() {
    Contact contact = app.contactMethods().all().iterator().next();
    Contact infoFromEditForm = app.contactMethods().infoFromEditForm(contact);

    assertThat(contact.getNumberHome(), equalTo(cleaned(infoFromEditForm.getNumberHome())));
    assertThat(contact.getNumberMobile(), equalTo(cleaned(infoFromEditForm.getNumberMobile())));
    assertThat(contact.getNumberWork(), equalTo(cleaned(infoFromEditForm.getNumberWork())));
    assertThat(contact.getSecondaryHome(), equalTo(cleaned(infoFromEditForm.getSecondaryHome())));
  }

  public String cleaned(String phone) {
    return phone.replaceAll("[-)( ]", "");
  }

}