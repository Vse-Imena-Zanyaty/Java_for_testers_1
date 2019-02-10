package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Group;
import org.testng.annotations.*;

public class GroupCreation extends CommonMethods {

  @Test
  public void testGroupCreation() {
    app.getNavigationMethods().gotoGroupPage();
    app.getGroupMethods().initGroupCreation();
    app.getGroupMethods().fillGroupForm(new Group("group1", "header1", "comment1"));
    app.getGroupMethods().submitGroupCreation();
    app.getGroupMethods().returnToGroupPage();
  }

}
