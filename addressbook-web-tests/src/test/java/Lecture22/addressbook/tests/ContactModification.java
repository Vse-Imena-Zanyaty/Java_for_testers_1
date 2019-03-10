package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactModification extends CommonMethods {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contactMethods().contactExists(app);
  }

  @Test
  public void testEditContact() {
    Set<Contact> before = app.contactMethods().all();
    Contact modifiedContact = before.iterator().next();
    Contact contact = new Contact().withID(modifiedContact.getID())
            .withFirstName("edited_first_name").withMiddleName("edited_middle_name").withLastName("edited_last_name")
            .withNickname("edited_nickname").withTitle("edited_title").withCompany("edited_company").withAddress("edited_address")
            .withNumberHome("№ home2").withNumberMobile("№ mobile2").withNumberWork("№ work2").withNumberFax("№ fax2")
            .withEmail_1("2email1@email.com").withEmail_2("2email2@email.com").withEmail_3("2new")
            .withInternet_page("2vkontakte.com").withBirthDate("2").withBirthMonth("January").withBirthYear("2222")
            .withAnniversaryDay("2").withAnniversaryMonth("January").withAnniversaryYear("3333").withSecondaryAddress("edited_secondary_address")
            .withSecondaryHome("edited_secondary_home").withSecondaryNotes("edited_secondary_notes");
    app.contactMethods().modify(contact, app);
    Set<Contact> after = app.contactMethods().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
