package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Group;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletion extends CommonMethods {

  @Test
  public void testGroupDeletion() {
    app.getNavigationMethods().gotoGroupPage();
    if (! app.getGroupMethods().existingGroup()) {
      app.getGroupMethods().createGroup(new Group("name", "header", "footer"), app);
    }
    int before = app.getGroupMethods().getGroupCount();
    app.getGroupMethods().selectGroup();
    app.getGroupMethods().initGroupDeletion();
    app.getGroupMethods().returnToGroupPage();
    int after = app.getGroupMethods().getGroupCount();
    Assert.assertEquals(after, before - 1);
  }

}
