package mantis.tests;

import org.testng.annotations.Test;

public class RegistrationTests extends CommonMethods{

  @Test
  public void testRegistration() {
    app.registration().start("user", "user@localhost.localdomain");

  }
}
