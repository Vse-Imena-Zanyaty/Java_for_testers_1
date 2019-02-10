package Lecture22.addressbook;

import org.testng.annotations.*;

public class GroupCreation extends CommonMethods {

  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new Group("group1", "header1", "comment1"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
