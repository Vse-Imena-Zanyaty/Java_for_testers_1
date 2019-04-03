package mantis.appManager;

import mantis.model.User;
import org.openqa.selenium.By;

public class UiMethods extends BasicMethods {

  public UiMethods(AppManager app) {
    super(app);
  }

  public void signUp(String username, String email) {
    wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
    type(By.name("username"), username);
    type(By.name("email"), email);
    click(By.cssSelector("input[value='Signup']"));
  }

  public void confirm(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("#account-update-form > fieldset > span > button"));
  }

  public void goToUserManagement() {
    wd.findElement(By.cssSelector("a[href='/mantisbt-2.20.0/manage_overview_page.php']")).click();
    wd.findElement(By.cssSelector("a[href='/mantisbt-2.20.0/manage_user_page.php']")).click();
  }

  public void selectUser(User user) {
    wd.findElement(By.cssSelector("a[href='manage_user_edit_page.php?user_id=" + user.getID() + "']")).click();
  }

  public void loginViaUi(String username, String password) {
    type(By.name("username"), username);
    click(By.xpath("//input[@value='Login']"));
    type(By.name("password"), password);
    click(By.xpath("//input[@value='Login']"));
  }

  public void initPassReset () {
    click(By.xpath("//input[@value='Reset Password']"));
  }

  public void createUserViaUi(String username, String email) {
    goToUserManagement();
    wd.findElement(By.cssSelector("a[href='manage_user_create_page.php']")).click();
    type(By.name("username"), username);
    type(By.name("email"), email);
    click(By.xpath("//input[@value='Create User']"));
  }
}
