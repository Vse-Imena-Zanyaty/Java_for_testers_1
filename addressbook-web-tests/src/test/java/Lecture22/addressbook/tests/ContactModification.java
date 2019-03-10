package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModification extends CommonMethods {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contactMethods().contactExists(app);
  }

  @Test
  public void testEditContact() {
    List<Contact> before = app.contactMethods().list();
    int index = before.size() - 1;
    Contact contact = new Contact(before.get(index).getID(), "edited_first_name", "edited_middle_name", "edited_last_name", "edited_nickname", "edited_title", "edited_company", "edited_address", "8 999 222 55 77", "4 240234934203", "8 324723943243", "0 35735435000", "edited_email1@email.com", "edited_email2@email.com", "edited_email3@email.com", "edited_vkontakte.com", "1", "January", "0000", "1", "January", "1111", null, "edited_secondary_address", "edited_secondary_home", "edited_secondary_notes");
    app.contactMethods().modify(index, contact, app);
    List<Contact> after = app.contactMethods().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super Contact> byID = Comparator.comparingInt(Contact::getID);
    before.sort(byID);
    after.sort(byID);
    Assert.assertEquals(before, after);
  }
}
