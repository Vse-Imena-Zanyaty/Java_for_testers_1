package Lecture22.addressbook;

import org.testng.annotations.Test;

public class GroupDeletion extends CommonMethods {

  @Test
  public void testGroupDeletion() throws Exception {
    gotoGroupPage();
    selectGroup();
    initDeletion();
    returnToGroupPage();
  }

}
