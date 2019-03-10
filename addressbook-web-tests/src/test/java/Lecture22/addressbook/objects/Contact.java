package Lecture22.addressbook.objects;

import java.util.Objects;

public class Contact {
  private int ID = Integer.MAX_VALUE;
  private String firstName;
  private String middleName;
  private String lastName;
  private String nickname;
  private String title;
  private String company;
  private String address;
  private String numberHome;
  private String numberMobile;
  private String numberWork;
  private String numberFax;
  private String email_1;
  private String email_2;
  private String email_3;
  private String internet_page;
  private String birthDate;
  private String birthMonth;
  private String birthYear;
  private String anniversaryDay;
  private String anniversaryMonth;
  private String anniversaryYear;
  private String contactGroup;
  private String secondaryAddress;
  private String secondaryHome;
  private String secondaryNotes;

  public Contact withID(int ID) {
    this.ID = ID;
    return this;
  }

  public Contact withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public Contact withMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public Contact withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public Contact withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public Contact withTitle(String title) {
    this.title = title;
    return this;
  }

  public Contact withCompany(String company) {
    this.company = company;
    return this;
  }

  public Contact withAddress(String address) {
    this.address = address;
    return this;
  }

  public Contact withNumberHome(String numberHome) {
    this.numberHome = numberHome;
    return this;
  }

  public Contact withNumberMobile(String numberMobile) {
    this.numberMobile = numberMobile;
    return this;
  }

  public Contact withNumberWork(String numberWork) {
    this.numberWork = numberWork;
    return this;
  }

  public Contact withNumberFax(String numberFax) {
    this.numberFax = numberFax;
    return this;
  }

  public Contact withEmail_1(String email_1) {
    this.email_1 = email_1;
    return this;
  }

  public Contact withEmail_2(String email_2) {
    this.email_2 = email_2;
    return this;
  }

  public Contact withEmail_3(String email_3) {
    this.email_3 = email_3;
    return this;
  }

  public Contact withInternet_page(String internet_page) {
    this.internet_page = internet_page;
    return this;
  }

  public Contact withBirthDate(String birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  public Contact withBirthMonth(String birthMonth) {
    this.birthMonth = birthMonth;
    return this;
  }

  public Contact withBirthYear(String birthYear) {
    this.birthYear = birthYear;
    return this;
  }

  public Contact withAnniversaryDay(String anniversaryDay) {
    this.anniversaryDay = anniversaryDay;
    return this;
  }

  public Contact withAnniversaryMonth(String anniversaryMonth) {
    this.anniversaryMonth = anniversaryMonth;
    return this;
  }

  public Contact withAnniversaryYear(String anniversaryYear) {
    this.anniversaryYear = anniversaryYear;
    return this;
  }

  public Contact withContactGroup(String contactGroup) {
    this.contactGroup = contactGroup;
    return this;
  }

  public Contact withSecondaryAddress(String secondaryAddress) {
    this.secondaryAddress = secondaryAddress;
    return this;
  }

  public Contact withSecondaryHome(String secondaryHome) {
    this.secondaryHome = secondaryHome;
    return this;
  }

  public Contact withSecondaryNotes(String secondaryNotes) {
    this.secondaryNotes = secondaryNotes;
    return this;
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

  public String getInternet_page() {
    return internet_page;
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
    return ID == contact.ID &&
            Objects.equals(firstName, contact.firstName) &&
            Objects.equals(lastName, contact.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID, firstName, lastName);
  }
}
