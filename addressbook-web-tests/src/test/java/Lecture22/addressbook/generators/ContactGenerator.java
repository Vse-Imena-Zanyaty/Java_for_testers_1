package Lecture22.addressbook.generators;

import Lecture22.addressbook.objects.Contact;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactGenerator generator = new ContactGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<Contact> contacts = generateContacts(count);
    if ((format.equals("xml"))) {
      saveAsXML(contacts, new File(file));
    } else if ((format.equals("json"))) {
      saveAsJSON(contacts, new File((file)));
    } else {
      System.out.println("Unrecognized format" + format);
    }
  }

  private void saveAsJSON(List<Contact> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }

  private void saveAsXML(List<Contact> contacts, File file) throws IOException {
    XStream xStream = new XStream();
    xStream.processAnnotations(Contact.class);
    String xml = xStream.toXML(contacts);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private List<Contact> generateContacts(int count) {
    List<Contact> contacts = new ArrayList<Contact>();
    File photo = new File("src/test/resources/image.jpg");
    for (int i = 0; i < count; i++) {
      contacts.add(new Contact()
              .withFirstName(String.format("first_name %s", i))
              .withMiddleName(String.format("middle_name %s", i))
              .withLastName(String.format("last_name %s", i))
              .withNickname(String.format("nickname %s", i))
              .withPhoto(photo)
              .withTitle(String.format("title %s", i))
              .withCompany(String.format("company %s", i))
              .withAddress(String.format("address %s", i))
              .withNumberHome(String.format("№ home %s", i))
              .withNumberMobile(String.format("№ mobile %s", i))
              .withNumberWork(String.format("№ work %s", i))
              .withNumberFax(String.format("№ fax %s", i))
              .withEmail_1(String.format("%semail_1@email.com", i))
              .withEmail_2(String.format("%semail_2@email.com", i))
              .withEmail_3(String.format("%semail_3@email.com", i))
              .withInternet_page(String.format("%s website.com", i))
              .withBirthDate("1")
              .withBirthMonth("January")
              .withBirthYear("1111")
              .withAnniversaryDay("1")
              .withAnniversaryMonth("January")
              .withAnniversaryYear("2222")
              .withContactGroup("[none]")
              .withSecondaryAddress(String.format("secondary_address %s", i))
              .withSecondaryHome(String.format("secondary_home %s", i))
              .withSecondaryNotes(String.format("secondary_notes %s", i)));
    }
    return contacts;
  }
}
