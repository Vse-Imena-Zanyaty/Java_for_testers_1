package Lecture22.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletion extends CommonMethods {

  @Test
  public void testGroupDeletion() throws Exception {
    app.gotoGroupPage();
    app.getGroupMethods().selectGroup();
    app.getGroupMethods().initGroupDeletion();
    app.getGroupMethods().returnToGroupPage();
  }

}
