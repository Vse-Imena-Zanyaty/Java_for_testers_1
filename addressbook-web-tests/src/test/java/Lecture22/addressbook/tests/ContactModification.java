package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModification extends CommonMethods {

  @Test
  public void testEditContact() {
    if (!app.getContactMethods().existingContact()) {
      app.getContactMethods().createContact(new Contact("first_name", "middle_name", "last_name", "nickname", "title", "company", "address", "+7 999 222 55 77", "+3240234934203", "83247239432432", "08435735435000", "email1@email.com", "email2@email.com", "new", "vkontakte.com", "1", "January", "1111", "1", "January", "2222", "name", "secondary_address", "secondary_home", "secondary_notes"), app);
    }
    List<Contact> before = app.getContactMethods().getContactList();
    app.getNavigationMethods().gotoEditContact(0);
    Contact contact = new Contact("edited_first_name", "edited_middle_name", "edited_last_name", "edited_nickname", "edited_title", "edited_company", "edited_address", "8 999 222 55 77", "4 240234934203", "8 324723943243", "0 35735435000", "edited_email1@email.com", "edited_email2@email.com", "edited_email3@email.com", "edited_vkontakte.com", "1", "January", "0000", "1", "January", "1111", null, "edited_secondary_address", "edited_secondary_home", "edited_secondary_notes");
    app.getContactMethods().fillContactForm(contact, false);
    app.getContactMethods().submitEditContact();
    app.getNavigationMethods().gotoHomePage();
    List<Contact> after = app.getContactMethods().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(0);
    before.add(contact);
    Comparator<? super Contact> byID = Comparator.comparingInt(Contact::getID);
    before.sort(byID);
    after.sort(byID);
    Assert.assertEquals(before, after);
  }
}
