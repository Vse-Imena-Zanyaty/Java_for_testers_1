package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactCreation extends CommonMethods {

  @BeforeMethod
  public void ensurePreconditions() {
    app.groupMethods().groupExists(app);
    app.goTo().homePage();
  }

  @Test
  public void testContactCreation() {
    Set<Contact> before = app.contactMethods().all();
    Contact contact = new Contact()
            .withFirstName("first_name").withMiddleName("middle_name").withLastName("last_name")
            .withNickname("nickname").withTitle("title").withCompany("company").withAddress("address")
            .withNumberHome("№ home").withNumberMobile("№ mobile").withNumberWork("№ work").withNumberFax("№ fax")
            .withEmail_1("email1@email.com").withEmail_2("email2@email.com").withEmail_3("new")
            .withInternet_page("vkontakte.com").withBirthDate("1").withBirthMonth("January").withBirthYear("1111")
            .withAnniversaryDay("1").withAnniversaryMonth("January").withAnniversaryYear("2222").withContactGroup("[none]")
            .withSecondaryAddress("secondary_address").withSecondaryHome("secondary_home").withSecondaryNotes("secondary_notes");
    app.contactMethods().create(contact, app);
    Set<Contact> after = app.contactMethods().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withID(after.stream().mapToInt((c) -> c.getID()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
