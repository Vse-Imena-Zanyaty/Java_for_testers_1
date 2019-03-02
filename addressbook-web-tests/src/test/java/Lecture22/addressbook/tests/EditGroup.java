package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Group;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditGroup extends CommonMethods {

  @Test
  public void testEditGroup() {
    app.getNavigationMethods().gotoGroupPage();
    if (! app.getGroupMethods().existingGroup()) {
      app.getGroupMethods().createGroup(new Group("name", "header", "footer"), app);
    }
    int before = app.getGroupMethods().getGroupCount();
    app.getGroupMethods().selectGroup();
    app.getGroupMethods().initEditGroup();
    app.getGroupMethods().fillGroupForm(new Group("edited_name", "edited_header", "edited_footer"));
    app.getGroupMethods().submitEditGroup();
    app.getGroupMethods().returnToGroupPage();
    int after = app.getGroupMethods().getGroupCount();
    Assert.assertEquals(after, before);
  }
}
