package Lecture22.addressbook.generators;

import Lecture22.addressbook.objects.Group;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupGenerator {

  @Parameter(names = "-c", description = "Group count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  public static void main(String[] args) throws IOException {
    GroupGenerator generator = new GroupGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
      generator.run();
    }

    private void run () throws IOException {
      List<Group> groups = generateGroups(count);
      save(groups, new File(file));
    }

    private void save (List < Group > groups, File file) throws IOException {
//    System.out.println(new File(".").getAbsolutePath());
      Writer writer = new FileWriter(file);
      for (Group group : groups) {
        writer.write(String.format("%s; %s; %s\n", group.getName(), group.getHeader(), group.getFooter()));
      }
      writer.close();
    }

    private List<Group> generateGroups ( int count){
      List<Group> groups = new ArrayList<Group>();
      for (int i = 0; i < count; i++) {
        groups.add(new Group().withName(String.format("name %s", i))
                .withHeader(String.format("header %s", i)).withFooter(String.format("footer %s", i)));
      }
      return groups;
    }
  }
