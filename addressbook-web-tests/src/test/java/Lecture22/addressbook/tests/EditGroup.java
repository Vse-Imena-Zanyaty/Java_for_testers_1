package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Group;
import org.testng.annotations.Test;

public class EditGroup extends CommonMethods {

  @Test
  public void testEditGroup() {
    app.getNavigationMethods().gotoGroupPage();
    if (! app.getGroupMethods().existingGroup()) {
      app.getGroupMethods().createGroup(new Group("group1", "header1", "comment1"), app);
    }
    app.getGroupMethods().selectGroup();
    app.getGroupMethods().initEditGroup();
    app.getGroupMethods().fillGroupForm(new Group("edited_group1", "edited_header1", "edited_comment1"));
    app.getGroupMethods().submitEditGroup();
  }
}
