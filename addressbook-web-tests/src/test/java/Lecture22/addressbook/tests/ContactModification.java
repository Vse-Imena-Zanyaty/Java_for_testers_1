package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Contact;
import Lecture22.addressbook.objects.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModification extends CommonMethods {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.contactMethods().fastCreate(app);
    }
  }

  @Test
  public void testEditContact() {
    Contacts before = app.db().contacts();
    Contact modifiedContact = before.iterator().next();
    File photo = new File("src/test/resources/image.jpg");
    Contact contact = new Contact().withID(modifiedContact.getID())
            .withFirstName("edited_first_name").withMiddleName("edited_middle_name").withLastName("edited_last_name")
            .withNickname("edited_nickname").withPhoto(photo).withCompany("edited_company").withTitle("edited_title")
            .withAddress("edited_address").withNumberHome("№ home2").withNumberMobile("№ mobile2").withNumberWork("№ work2")
            .withNumberFax("№ fax2").withEmail_1("2email1@email.com").withEmail_2("2email2@email.com").withEmail_3("2new")
            .withInternet_page("2vkontakte.com").withBirthDate((byte) 2).withBirthMonth("January").withBirthYear("2222")
            .withAnniversaryDay((byte) 2).withAnniversaryMonth("January").withAnniversaryYear("3333").withSecondaryAddress("edited_secondary_address")
            .withSecondaryHome("edited_secondary_home").withSecondaryNotes("edited_secondary_notes");
    app.contactMethods().modify(contact, app);
    assertThat(app.contactMethods().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}
