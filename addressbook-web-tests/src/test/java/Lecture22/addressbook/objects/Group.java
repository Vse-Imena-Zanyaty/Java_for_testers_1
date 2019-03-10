package Lecture22.addressbook.objects;

import java.util.Objects;

public class Group {
  private int ID = Integer.MAX_VALUE;
  private String name;
  private String header;
  private String footer;

  public Group withID(int ID) {
    this.ID = ID;
    return this;
  }

  public Group withName(String name) {
    this.name = name;
    return this;
  }

  public Group withHeader(String header) {
    this.header = header;
    return this;
  }

  public Group withFooter(String footer) {
    this.footer = footer;
    return this;
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
