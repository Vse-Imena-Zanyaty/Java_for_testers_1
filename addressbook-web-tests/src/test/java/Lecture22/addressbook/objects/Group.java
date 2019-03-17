package Lecture22.addressbook.objects;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.Objects;

@XStreamAlias("group")
public class Group {
  @XStreamOmitField
  private int ID = Integer.MAX_VALUE;
  @Expose
  private String name;
  @Expose
  private String header;
  @Expose
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
    return ID == group.ID &&
            Objects.equals(name, group.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID, name);
  }
}
