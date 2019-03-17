package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Group;
import Lecture22.addressbook.objects.Groups;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreation extends CommonMethods {

  @DataProvider
  public Iterator<Object[]> validGroupsFromXML() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line != null) {
      xml += line;
      line = reader.readLine();
    }
    XStream xStream = new XStream();
    xStream.processAnnotations(Group.class);
    List<Group> groups = (List<Group>) xStream.fromXML(xml);
    return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
  }

  @DataProvider
  public Iterator<Object[]> validGroupsFromJSON() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<Group> groups = gson.fromJson(json, new TypeToken<List<Group>>() {
      }.getType());
      return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @Test(dataProvider = "validGroupsFromJSON")
  public void testGroupCreation(Group group) {
    app.goTo().GroupPage();
    Groups before = app.groupMethods().all();
    app.groupMethods().create(group, app);
    assertThat(app.groupMethods().count(), equalTo(before.size() + 1));
    Groups after = app.groupMethods().all();
    assertThat(after, equalTo(before
            .withAdded(group.withID(after.stream().mapToInt((g) -> g.getID()).max().getAsInt()))));
  }

  @Test
  public void testBadGroupCreation() {
    app.goTo().GroupPage();
    Groups before = app.groupMethods().all();
    Group group = new Group()
            .withName("name'").withHeader("header").withFooter("footer");
    app.groupMethods().create(group, app);
    assertThat(app.groupMethods().count(), equalTo(before.size()));
    Groups after = app.groupMethods().all();
    assertThat(after, equalTo(before));
  }
}
