package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Contact;
import org.testng.annotations.Test;

public class ContactCreation extends CommonMethods {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationMethods().gotoContactCreation();
    app.getContactMethods().fillContactForm(new Contact("first_name", "middle_name", "last_name", "nickname", "title", "company", "address", "+7 999 222 55 77", "+3240234934203", "83247239432432", "08435735435000", "email1@email.com", "email2@email.com", "wfwefewlfefwefew", "vkontakte.com", "1", "January", "1111", "1", "January", "2222", "group1", "secondary_address", "secondary_home", "secondary_notes"));
    app.getContactMethods().submitContactCreation();
    app.getNavigationMethods().gotoHomePage();
  }

}
