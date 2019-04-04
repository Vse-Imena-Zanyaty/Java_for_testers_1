package rest;

import java.util.Objects;

public class Issue {

  private int ID;
  private String subject;
  private String description;

  public Issue withID(int ID) {
    this.ID = ID;
    return this;
  }

  public Issue withSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public Issue withDescription(String description) {
    this.description = description;
    return this;
  }

  public int getID() {
    return ID;
  }

  public String getSubject() {
    return subject;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Issue issue = (Issue) o;
    return ID == issue.ID &&
            Objects.equals(subject, issue.subject) &&
            Objects.equals(description, issue.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID, subject, description);
  }
}
