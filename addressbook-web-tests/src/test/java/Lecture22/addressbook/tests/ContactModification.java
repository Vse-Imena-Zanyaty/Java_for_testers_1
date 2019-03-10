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
    Contact contact = new Contact().withID(before.get(index).getID())
            .withFirstName("edited_first_name").withMiddleName("edited_middle_name").withLastName("edited_last_name")
            .withNickname("edited_nickname").withTitle("edited_title").withCompany("edited_company").withAddress("edited_address")
            .withNumberHome("№ home2").withNumberMobile("№ mobile2").withNumberWork("№ work2").withNumberFax("№ fax2")
            .withEmail_1("2email1@email.com"). withEmail_2("2email2@email.com").withEmail_3("2new")
            .withInternet_page("2vkontakte.com").withBirthDate("2").withBirthMonth("January").withBirthYear("2222")
            .withAnniversaryDay("2").withAnniversaryMonth("January").withAnniversaryYear("3333").withSecondaryAddress("edited_secondary_address")
            .withSecondaryHome("edited_secondary_home").withSecondaryNotes("edited_secondary_notes");
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
