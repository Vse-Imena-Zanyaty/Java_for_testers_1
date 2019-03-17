package Lecture22.addressbook.generators;

import Lecture22.addressbook.objects.Group;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupGenerator {

  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<Group> groups = generateGroups(count);
    save(groups, file);
  }

  private static void save(List<Group> groups, File file) throws IOException {
//    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (Group group : groups) {
      writer.write(String.format("%s; %s; %s\n", group.getName(), group.getHeader(), group.getFooter()));
    }
    writer.close();
  }

  private static List<Group> generateGroups(int count) {
    List<Group> groups = new ArrayList<Group>();
    for (int i = 0; i < count; i++) {
      groups.add(new Group().withName(String.format("name %s", i))
              .withHeader(String.format("header %s", i)).withFooter(String.format("footer %s", i)));
    }
    return groups;
  }
}
