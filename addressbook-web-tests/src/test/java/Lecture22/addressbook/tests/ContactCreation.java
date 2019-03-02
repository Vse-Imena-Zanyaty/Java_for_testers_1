package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Contact;
import org.testng.annotations.Test;

public class ContactCreation extends CommonMethods {

  @Test
  public void testContactCreation() {
    app.getContactMethods().createContact(new Contact("first_name", "middle_name", "last_name", "nickname", "title", "company", "address", "+7 999 222 55 77", "+3240234934203", "83247239432432", "08435735435000", "email1@email.com", "email2@email.com", "new", "vkontakte.com", "1", "January", "1111", "1", "January", "2222", "name", "secondary_address", "secondary_home", "secondary_notes"), app);
  }
}
