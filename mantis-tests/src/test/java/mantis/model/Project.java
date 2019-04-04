package mantis.model;

public class Project {
  private int ID;
  private String name;

  public Project withID(int ID) {
    this.ID = ID;
    return this;
  }

  public Project withName(String name) {
    this.name = name;
    return this;
  }

  public int getID() {
    return ID;
  }

  public String getName() {
    return name;
  }
}
