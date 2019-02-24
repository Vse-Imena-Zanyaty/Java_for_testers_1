package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Group;
import org.testng.annotations.Test;

public class GroupDeletion extends CommonMethods {

  @Test
  public void testGroupDeletion() {
    app.getNavigationMethods().gotoGroupPage();
    if (! app.getGroupMethods().existingGroup()) {
      app.getGroupMethods().createGroup(new Group("group1", "header1", "comment1"), app);
    }
    app.getGroupMethods().selectGroup();
    app.getGroupMethods().initGroupDeletion();
    app.getGroupMethods().returnToGroupPage();
  }

}
