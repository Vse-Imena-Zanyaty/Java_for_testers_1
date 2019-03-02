package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactDeletion extends CommonMethods {

  @Test
  public void testContactDeletion() {
    if (!app.getContactMethods().existingContact()) {
      app.getContactMethods().createContact(new Contact("first_name", "middle_name", "last_name", "nickname", "title", "company", "address", "+7 999 222 55 77", "+3240234934203", "83247239432432", "08435735435000", "email1@email.com", "email2@email.com", "new", "vkontakte.com", "1", "January", "1111", "1", "January", "2222", "name", "secondary_address", "secondary_home", "secondary_notes"), app);
    }
    List<Contact> before = app.getContactMethods().getContactList();
    app.getContactMethods().selectContact(before.size() - 1);
    app.getContactMethods().deleteContact();
    app.getContactMethods().acceptAlert();
    app.getNavigationMethods().goHome();
    List<Contact> after = app.getContactMethods().getContactList();

    before.remove(before.size() - 1);
    Comparator<? super Contact> byID = Comparator.comparingInt(Contact::getID);
    before.sort(byID);
    after.sort(byID);
    Assert.assertEquals(before, after);
  }
}
