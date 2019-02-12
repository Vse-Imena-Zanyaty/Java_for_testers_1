package Lecture22.addressbook.appManager;

import Lecture22.addressbook.objects.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactMethods extends BasicMethods {

  public ContactMethods(ChromeDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void selectContact() {click(By.name("selected[]")); }

  public void submitEditContact() {click(By.name("update")); }

  public void deleteContact() {click(By.xpath("//input[@value='Delete']")); }

  public void acceptAlert() {wd.switchTo().alert().accept(); }

  public void fillContactForm(Contact contact) {
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
    click(By.name("bday"));
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contact.getBirthDate());
    click(By.name("bday"));
    click(By.name("bmonth"));
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contact.getBirthMonth());
    click(By.name("bmonth"));
    type(By.name("byear"), contact.getBirthYear());
    click(By.name("aday"));
    new Select(wd.findElement(By.name("aday"))).selectByVisibleText(contact.getAnniversaryDay());
    click(By.name("aday"));
    click(By.name("amonth"));
    new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(contact.getAnniversaryMonth());
    click(By.name("amonth"));
    type(By.name("ayear"), contact.getAnniversaryYear());
    //click(By.name("new_group"));
    //new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contact.getContactGroup());
    //click(By.name("new_group"));
    type(By.name("address2"), contact.getSecondaryAddress());
    type(By.name("phone2"), contact.getSecondaryHome());
    type(By.name("notes"), contact.getSecondaryNotes());
  }
}
