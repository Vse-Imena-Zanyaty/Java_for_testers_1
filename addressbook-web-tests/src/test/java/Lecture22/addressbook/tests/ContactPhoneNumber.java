package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Contact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneNumber extends CommonMethods {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() ==0) {
      app.contactMethods().create(new Contact().withFirstName("first_name").withLastName("last_name"), app);
    }
  }

  @Test
  public void testPhoneNumbers() {
    Contact contact = app.contactMethods().all().iterator().next();
    Contact infoFromEditForm = app.contactMethods().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(infoFromEditForm)));
  }

  private String mergePhones(Contact contact) {
    return Arrays.asList(contact.getNumberHome(), contact.getNumberMobile(), contact.getNumberWork(), contact.getSecondaryHome())
            .stream().filter((s) -> !s.equals(""))
            .map(this::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public String cleaned(String phone) {
    return phone.replaceAll("[-)( ]", "");
  }

}