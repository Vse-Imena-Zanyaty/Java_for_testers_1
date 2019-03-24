package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Contact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmail extends CommonMethods {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() ==0) {
      app.contactMethods().fastCreate(app);
    }
  }

  @Test
  public void testEmails() {
    Contact contact = app.contactMethods().all().iterator().next();
    Contact infoFromEditForm = app.contactMethods().infoFromEditForm(contact);

    assertThat(contact.getAllEmails(), equalTo(mergeEmails(infoFromEditForm)));
  }

  private String mergeEmails(Contact contact) {
    return Arrays.asList(contact.getEmail_1(), contact.getEmail_2(), contact.getEmail_3())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }

}
