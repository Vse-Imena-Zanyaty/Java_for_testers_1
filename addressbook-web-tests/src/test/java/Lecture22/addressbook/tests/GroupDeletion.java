package Lecture22.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletion extends CommonMethods {

  @Test
  public void testGroupDeletion() {
    app.getNavigationMethods().gotoGroupPage();
    app.getGroupMethods().selectGroup();
    app.getGroupMethods().initGroupDeletion();
    app.getGroupMethods().returnToGroupPage();
  }

}