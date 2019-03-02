package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Group;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreation extends CommonMethods {

  @Test
  public void testGroupCreation() {
    app.getNavigationMethods().gotoGroupPage();
    int before = app.getGroupMethods().getGroupCount();
    app.getGroupMethods().createGroup(new Group("name", "header", "footer"), app);
    int after = app.getGroupMethods().getGroupCount();
    Assert.assertEquals(after, before + 1);
  }

}
