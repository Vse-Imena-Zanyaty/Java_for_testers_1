package Lecture22.addressbook.appManager;

import Lecture22.addressbook.objects.Contact;
import Lecture22.addressbook.objects.Group;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ContactMethods extends BasicMethods {

  public ContactMethods(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void selectContact() {click(By.name("selected[]")); }

  public void submitEditContact() {click(By.name("update")); }

  public void deleteContact() {click(By.xpath("//input[@value='Delete']")); }

  public void acceptAlert() {wd.switchTo().alert().accept(); }

  public void fillContactForm(Contact contact, boolean creation) {
    type(By.name("firstname"), contact.getFirstName());
    type(By.name("middlename"), contact.getMiddleName());
    type(By.name("lastname"), contact.getLastName());
    type(By.name("nickname"), contact.getNickname());
    type(By.name("title"), contact.getTitle());
    type(By.name("company"), contact.getCompany());
    type(By.name("address"), contact.getAddress());
    type(By.name("home"), contact.getNumberHome());
    type(By.name("mobile"), contact.getNumberMobile());
    type(By.name("work"), contact.getNumberWork());
    type(By.name("fax"), contact.getNumberFax());
    type(By.name("email"), contact.getEmail_1());
    type(By.name("email2"), contact.getEmail_2());
    type(By.name("email3"), contact.getEmail_3());
    type(By.name("homepage"), contact.getContactHomePage());
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contact.getBirthDate());
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contact.getBirthMonth());
    type(By.name("byear"), contact.getBirthYear());
    new Select(wd.findElement(By.name("aday"))).selectByVisibleText(contact.getAnniversaryDay());
    new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(contact.getAnniversaryMonth());
    type(By.name("ayear"), contact.getAnniversaryYear());
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contact.getContactGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
    type(By.name("address2"), contact.getSecondaryAddress());
    type(By.name("phone2"), contact.getSecondaryHome());
    type(By.name("notes"), contact.getSecondaryNotes());
  }

  public void createContact(AppManager app) {
    app.getNavigationMethods().gotoGroupPage();
    if (! app.getGroupMethods().existingGroup()) {
      app.getGroupMethods().createGroup(new Group("group1", "header1", "comment1"), app);
    }
    app.getNavigationMethods().gotoContactCreation();
    fillContactForm(new Contact("first_name", "middle_name", "last_name", "nickname", "title", "company", "address", "+7 999 222 55 77", "+3240234934203", "83247239432432", "08435735435000", "email1@email.com", "email2@email.com", "new", "vkontakte.com", "1", "January", "1111", "1", "January", "2222", "group1", "secondary_address", "secondary_home", "secondary_notes"), true);
    submitContactCreation();
    app.getNavigationMethods().gotoHomePage();
  }

  public boolean existingContact() {
    return isElementPresent(By.name("selected[]"));
  }
}
