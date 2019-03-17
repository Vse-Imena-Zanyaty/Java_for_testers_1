package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Group;
import Lecture22.addressbook.objects.Groups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreation extends CommonMethods {

  @DataProvider
  public Iterator<Object[]> validGroups() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[]{new Group().withName("name1").withHeader("header1").withFooter("footer1")});
    list.add(new Object[]{new Group().withName("name2").withHeader("header2").withFooter("footer2")});
    list.add(new Object[]{new Group().withName("name3").withHeader("header3").withFooter("footer3")});
    return list.iterator();
  }

  @Test(dataProvider = "validGroups")
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
