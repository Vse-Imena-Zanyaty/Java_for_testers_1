package Lecture22.addressbook.objects;

import java.util.Objects;

public class Group {

  public void setID(int ID) {
    this.ID = ID;
  }

  private int ID;
  private final String name;
  private final String header;
  private final String footer;

  public Group(String name, String header, String footer) {
    this.ID = Integer.MAX_VALUE;
    this.name = name;
    this.header = header;
    this.footer = footer;
  }

  public Group(int ID, String name, String header, String footer) {
    this.ID = ID;
    this.name = name;
    this.header = header;
    this.footer = footer;
  }

  public int getID() {
    return ID;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

  @Override
  public String toString() {
    return "Group{" +
            "ID=" + ID +
            ", name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Group group = (Group) o;
    return Objects.equals(name, group.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
