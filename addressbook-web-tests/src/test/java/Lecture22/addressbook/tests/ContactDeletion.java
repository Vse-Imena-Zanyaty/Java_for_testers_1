package Lecture22.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletion extends CommonMethods {

  @Test
  public void testContactDeletion() {
    if (! app.getContactMethods().existingContact()) {
      app.getContactMethods().createContact(app);
    }
    app.getContactMethods().selectContact();
    app.getContactMethods().deleteContact();
    app.getContactMethods().acceptAlert();
    app.getNavigationMethods().goHome();
  }
}
