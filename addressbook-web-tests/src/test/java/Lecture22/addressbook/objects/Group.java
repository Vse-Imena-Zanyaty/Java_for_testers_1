package Lecture22.addressbook.objects;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("group")
@Entity
@Table(name = "group_list")
public class Group {
  @XStreamOmitField
  @Id
  @Column(name = "group_id")
  private int ID = Integer.MAX_VALUE;
  @Expose
  @Column(name = "group_name")
  private String name;
  @Expose
  @Column(name = "group_header")
  @Type(type = "text")
  private String header;
  @Expose
  @Column(name = "group_footer")
  @Type(type = "text")
  private String footer;

  @ManyToMany(mappedBy = "groups")
  private Set<Contact> contacts = new HashSet<Contact>();

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

  public Contacts getContacts() {
    return new Contacts(contacts);
  }

  @Override
  public String toString() {
    return "Group{" +
            "ID=" + ID +
            ", name='" + name + '\'' +
            ", header='" + header + '\'' +
            ", footer='" + footer + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Group group = (Group) o;
    return ID == group.ID &&
            Objects.equals(name, group.name) &&
            Objects.equals(header, group.header) &&
            Objects.equals(footer, group.footer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID, name, header, footer);
  }
}
