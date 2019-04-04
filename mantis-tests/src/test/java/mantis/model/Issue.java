package mantis.model;

public class Issue {
  private int ID;
  private String summary;
  private String description;
  private Project project;


  public Issue withID(int ID) {
    this.ID = ID;
    return this;
  }

  public Issue withSummary(String summary) {
    this.summary = summary;
    return this;
  }

  public Issue withDescription(String description) {
    this.description = description;
    return this;
  }

  public Issue withProject(Project project) {
    this.project = project;
    return this;
  }

  public int getID() {
    return ID;
  }

  public String getSummary() {
    return summary;
  }

  public String getDescription() {
    return description;
  }

  public Project getProject() {
    return project;
  }
}
