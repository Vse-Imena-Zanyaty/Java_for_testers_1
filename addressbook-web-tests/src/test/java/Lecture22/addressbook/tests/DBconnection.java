package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Group;
import Lecture22.addressbook.objects.Groups;
import org.testng.annotations.Test;

import java.sql.*;

public class DBconnection {

  @Test(enabled = false)
  public void testDatabaseConnection() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection
              ("jdbc:mysql://localhost:3306/addressbook?&useLegacyDatetimeCode=false&serverTimezone=UTC&user=root&password=");
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("SELECT group_id, group_name, group_header, group_footer FROM group_list");
      Groups groups = new Groups();
      while (rs.next()) {
        groups.add(new Group().withID(rs.getInt("group_id")).withName(rs.getString("group_name"))
                .withHeader(rs.getString("group_header")).withFooter(rs.getString("group_footer")));
      }
      rs.close();
      st.close();
      conn.close();

      System.out.println(groups);

    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
  }
}
