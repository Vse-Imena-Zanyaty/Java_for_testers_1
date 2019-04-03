package mantis.tests;

import mantis.model.MailMessage;
import mantis.model.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class PasswordResetTests extends CommonMethods {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().usersWithEmails().size() == 0) {
      app.uiMethods().loginViaUi("administrator", "root");
      long now = System.currentTimeMillis();
      String email = String.format("user%s@localhost", now);
      String user = String.format("user%s", now);
      app.uiMethods().createUserViaUi(user, email);
    } else {
      app.uiMethods().loginViaUi("administrator", "root");
    }
  }

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testPasswordReset() throws IOException, MessagingException {
    User modifiedUser = app.db().usersWithEmails().iterator().next();
    String user = modifiedUser.getUsername();
    String email = modifiedUser.getEmail();
    String password = "password";
    app.uiMethods().goToUserManagement();
    app.uiMethods().selectUser(modifiedUser);
    app.uiMethods().initPassReset();
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, email);
    app.uiMethods().confirm(confirmationLink, password);
    assertTrue(app.newSession().login(user, password));
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findAny().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}
