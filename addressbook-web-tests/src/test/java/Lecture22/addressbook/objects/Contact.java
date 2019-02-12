package Lecture22.addressbook.objects;

public class Contact {
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
  //private final String contactGroup;
  private final String secondaryAddress;
  private final String secondaryHome;
  private final String secondaryNotes;

  public Contact(String firstName, String middleName, String lastName, String nickname, String title, String company, String address, String numberHome, String numberMobile, String numberWork, String numberFax, String email_1, String email_2, String email_3, String contactHomePage, String birthDate, String birthMonth, String birthYear, String anniversaryDay, String anniversaryMonth, String anniversaryYear, String contactGroup, String secondaryAddress, String secondaryHome, String secondaryNotes) {
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
    // this.contactGroup = contactGroup;
    this.secondaryAddress = secondaryAddress;
    this.secondaryHome = secondaryHome;
    this.secondaryNotes = secondaryNotes;
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

//  public String getContactGroup() { return contactGroup; }

  public String getSecondaryAddress() {
    return secondaryAddress;
  }

  public String getSecondaryHome() {
    return secondaryHome;
  }

  public String getSecondaryNotes() {
    return secondaryNotes;
  }
}
