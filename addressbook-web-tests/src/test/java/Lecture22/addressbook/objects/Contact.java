package Lecture22.addressbook.objects;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class Contact {
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int ID = Integer.MAX_VALUE;
  @Expose
  @Column(name = "firstname")
  private String firstName;
  @Expose
  @Column(name = "middlename")
  private String middleName;
  @Expose
  @Column(name = "lastname")
  private String lastName;
  @Expose
  @Column(name = "nickname")
  private String nickname;
  @Expose
  @Column(name = "company")
  private String company;
  @Expose
  @Column(name = "title")
  private String title;
  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private String address;
  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private String numberHome;
  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String numberMobile;
  @Expose
  @Column(name = "work")
  @Type(type = "text")
  private String numberWork;
  @Expose
  @Column(name = "fax")
  @Type(type = "text")
  private String numberFax;
  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String email_1;
  @Expose
  @Column(name = "email2")
  @Type(type = "text")
  private String email_2;
  @Expose
  @Column(name = "email3")
  @Type(type = "text")
  private String email_3;
  @Expose
  @Column(name = "homepage")
  @Type(type = "text")
  private String internet_page;
  @Expose
  @Column(name = "bday")
  @Type(type = "byte")
  private Byte birthDate;
  @Expose
  @Column(name = "bmonth")
  private String birthMonth;
  @Expose
  @Column(name = "byear")
  private String birthYear;
  @Expose
  @Column(name = "aday")
  @Type(type = "byte")
  private Byte anniversaryDay;
  @Expose
  @Column(name = "amonth")
  private String anniversaryMonth;
  @Expose
  @Column(name = "ayear")
  private String anniversaryYear;
  /*  @Expose
    @Transient
    private String contactGroup;*/
  @Expose
  @Column(name = "address2")
  @Type(type = "text")
  private String secondaryAddress;
  @Expose
  @Column(name = "phone2")
  @Type(type = "text")
  private String secondaryHome;
  @Expose
  @Column(name = "notes")
  @Type(type = "text")
  private String secondaryNotes;
  @Transient
  private String allPhones;
  @Transient
  private String allEmails;
  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "address_in_groups",
          joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<Group> groups = new HashSet<Group>();


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

  public Contact withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public Contact withCompany(String company) {
    this.company = company;
    return this;
  }

  public Contact withTitle(String title) {
    this.title = title;
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

  public Contact withBirthDate(Byte birthDate) {
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

  public Contact withAnniversaryDay(Byte anniversaryDay) {
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

/*  public Contact withContactGroup(String contactGroup) {
    this.contactGroup = contactGroup;
    return this;
  }*/

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

  public Contact withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public Contact withAllEmails(String allEmails) {
    this.allEmails = allEmails;
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

  public File getPhoto() {
    if (photo == null) {
      return null;
    } else {
      return new File(photo);
    }
  }

  public String getCompany() {
    return company;
  }

  public String getTitle() {
    return title;
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

  public Byte getBirthDate() {
    return birthDate;
  }

  public String getBirthMonth() {
    return birthMonth;
  }

  public String getBirthYear() {
    return birthYear;
  }

  public Byte getAnniversaryDay() {
    return anniversaryDay;
  }

  public String getAnniversaryMonth() {
    return anniversaryMonth;
  }

  public String getAnniversaryYear() {
    return anniversaryYear;
  }

/*  public String getContactGroup() {
    return contactGroup;
  }*/

  public String getSecondaryAddress() {
    return secondaryAddress;
  }

  public String getSecondaryHome() {
    return secondaryHome;
  }

  public String getSecondaryNotes() {
    return secondaryNotes;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public Groups getGroups() {
    return new Groups(groups);
  }

  public Contact inGroup(Group group) {
    groups.add(group);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Contact contact = (Contact) o;
    return ID == contact.ID &&
            Objects.equals(firstName, contact.firstName) &&
            Objects.equals(middleName, contact.middleName) &&
            Objects.equals(lastName, contact.lastName) &&
            Objects.equals(nickname, contact.nickname) &&
            Objects.equals(company, contact.company) &&
            Objects.equals(title, contact.title) &&
            Objects.equals(address, contact.address) &&
            Objects.equals(numberHome, contact.numberHome) &&
            Objects.equals(numberMobile, contact.numberMobile) &&
            Objects.equals(numberWork, contact.numberWork) &&
            Objects.equals(numberFax, contact.numberFax) &&
            Objects.equals(email_1, contact.email_1) &&
            Objects.equals(email_2, contact.email_2) &&
            Objects.equals(email_3, contact.email_3) &&
            Objects.equals(internet_page, contact.internet_page) &&
            Objects.equals(birthDate, contact.birthDate) &&
            Objects.equals(birthMonth, contact.birthMonth) &&
            Objects.equals(birthYear, contact.birthYear) &&
            Objects.equals(anniversaryDay, contact.anniversaryDay) &&
            Objects.equals(anniversaryYear, contact.anniversaryYear) &&
            Objects.equals(secondaryAddress, contact.secondaryAddress) &&
            Objects.equals(secondaryHome, contact.secondaryHome) &&
            Objects.equals(secondaryNotes, contact.secondaryNotes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID, firstName, middleName, lastName, nickname, company, title, address, numberHome, numberMobile, numberWork, numberFax, email_1, email_2, email_3, internet_page, birthDate, birthMonth, birthYear, anniversaryDay, anniversaryYear, secondaryAddress, secondaryHome, secondaryNotes);
  }

  @Override
  public String toString() {
    return "Contact{" +
            "ID=" + ID +
            ", firstName='" + firstName + '\'' +
            ", middleName='" + middleName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", nickname='" + nickname + '\'' +
            ", company='" + company + '\'' +
            ", title='" + title + '\'' +
            ", address='" + address + '\'' +
            ", numberHome='" + numberHome + '\'' +
            ", numberMobile='" + numberMobile + '\'' +
            ", numberWork='" + numberWork + '\'' +
            ", numberFax='" + numberFax + '\'' +
            ", email_1='" + email_1 + '\'' +
            ", email_2='" + email_2 + '\'' +
            ", email_3='" + email_3 + '\'' +
            ", internet_page='" + internet_page + '\'' +
            ", birthDate=" + birthDate +
            ", birthMonth='" + birthMonth + '\'' +
            ", birthYear='" + birthYear + '\'' +
            ", anniversaryDay=" + anniversaryDay +
            ", anniversaryYear='" + anniversaryYear + '\'' +
            ", secondaryAddress='" + secondaryAddress + '\'' +
            ", secondaryHome='" + secondaryHome + '\'' +
            ", secondaryNotes='" + secondaryNotes + '\'' +
            '}';
  }
}