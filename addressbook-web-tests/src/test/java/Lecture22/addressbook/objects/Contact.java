package Lecture22.addressbook.objects;

import java.util.Objects;

public class Contact {

  public void setID(int ID) {
    this.ID = ID;
  }

  private int ID;
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private final String numberHome;
  private final String numberMobile;
  private final String numberWork;
  private final String numberFax;
  private final String email_1;
  private final String email_2;
  private final String email_3;
  private final String contactHomePage;
  private final String birthDate;
  private final String birthMonth;
  private final String birthYear;
  private final String anniversaryDay;
  private final String anniversaryMonth;
  private final String anniversaryYear;
  private final String contactGroup;
  private final String secondaryAddress;
  private final String secondaryHome;
  private final String secondaryNotes;

  public Contact(String firstName, String middleName, String lastName, String nickname, String title, String company, String address, String numberHome, String numberMobile, String numberWork, String numberFax, String email_1, String email_2, String email_3, String contactHomePage, String birthDate, String birthMonth, String birthYear, String anniversaryDay, String anniversaryMonth, String anniversaryYear, String contactGroup, String secondaryAddress, String secondaryHome, String secondaryNotes) {
    this.ID = Integer.MAX_VALUE;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.numberHome = numberHome;
    this.numberMobile = numberMobile;
    this.numberWork = numberWork;
    this.numberFax = numberFax;
    this.email_1 = email_1;
    this.email_2 = email_2;
    this.email_3 = email_3;
    this.contactHomePage = contactHomePage;
    this.birthDate = birthDate;
    this.birthMonth = birthMonth;
    this.birthYear = birthYear;
    this.anniversaryDay = anniversaryDay;
    this.anniversaryMonth = anniversaryMonth;
    this.anniversaryYear = anniversaryYear;
    this.contactGroup = contactGroup;
    this.secondaryAddress = secondaryAddress;
    this.secondaryHome = secondaryHome;
    this.secondaryNotes = secondaryNotes;
  }

  public Contact(int ID, String firstName, String lastName) {
    this.ID = ID;
    this.firstName = firstName;
    this.middleName = null;
    this.lastName = lastName;
    this.nickname = null;
    this.title = null;
    this.company = null;
    this.address = null;
    this.numberHome = null;
    this.numberMobile = null;
    this.numberWork = null;
    this.numberFax = null;
    this.email_1 = null;
    this.email_2 = null;
    this.email_3 = null;
    this.contactHomePage = null;
    this.birthDate = null;
    this.birthMonth = null;
    this.birthYear = null;
    this.anniversaryDay = null;
    this.anniversaryMonth = null;
    this.anniversaryYear = null;
    this.contactGroup = null;
    this.secondaryAddress = null;
    this.secondaryHome = null;
    this.secondaryNotes = null;
  }

  public int getID() {
    return ID;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getNumberHome() {
    return numberHome;
  }

  public String getNumberMobile() {
    return numberMobile;
  }

  public String getNumberWork() {
    return numberWork;
  }

  public String getNumberFax() {
    return numberFax;
  }

  public String getEmail_1() {
    return email_1;
  }

  public String getEmail_2() {
    return email_2;
  }

  public String getEmail_3() {
    return email_3;
  }

  public String getContactHomePage() {
    return contactHomePage;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public String getBirthMonth() {
    return birthMonth;
  }

  public String getBirthYear() {
    return birthYear;
  }

  public String getAnniversaryDay() {
    return anniversaryDay;
  }

  public String getAnniversaryMonth() {
    return anniversaryMonth;
  }

  public String getAnniversaryYear() {
    return anniversaryYear;
  }

  public String getContactGroup() {
    return contactGroup;
  }

  public String getSecondaryAddress() {
    return secondaryAddress;
  }

  public String getSecondaryHome() {
    return secondaryHome;
  }

  public String getSecondaryNotes() {
    return secondaryNotes;
  }

  @Override
  public String toString() {
    return "Contact{" +
            "ID=" + ID +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Contact contact = (Contact) o;
    return Objects.equals(firstName, contact.firstName) &&
            Objects.equals(lastName, contact.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }
}
