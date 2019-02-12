package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Contact;
import org.testng.annotations.Test;

public class EditContact extends CommonMethods {

  @Test
  public void testEditContact() {
    app.getNavigationMethods().gotoEditContact();
    app.getContactMethods().fillContactForm(new Contact("edited_first_name", "edited_middle_name", "edited_last_name", "edited_nickname", "edited_title", "edited_company", "edited_address", "8 999 222 55 77", "4 240234934203", "8 324723943243", "0 35735435000", "edited_email1@email.com", "edited_email2@email.com", "edited_email3@email.com", "edited_vkontakte.com", "1", "January", "0000", "1", "January", "1111", "group1", "edited_secondary_address", "edited_secondary_home", "edited_secondary_notes"));
    app.getContactMethods().submitEditContact();
    app.getNavigationMethods().gotoHomePage();
  }

}

