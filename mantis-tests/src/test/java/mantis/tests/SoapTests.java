package mantis.tests;

import mantis.model.Issue;
import mantis.model.Project;
import org.testng.annotations.Test;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class SoapTests extends CommonMethods {

  @Test
  public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {
    skipIfNotFixed(0000002);
    Set<Project> projects = app.soapMethods().getProjects();
    System.out.println("amount: " + projects.size());
    for (Project project : projects) {
      System.out.println("name: " + project.getName());
    }
  }

  @Test
  public void testCreateIssue() throws RemoteException, ServiceException, MalformedURLException {
    skipIfNotFixed(0000002);
    Set<Project> projects = app.soapMethods().getProjects();
    Issue issue = new Issue()
            .withSummary("Test Issue").withDescription("Test Issue Description").withProject(projects.iterator().next());
    Issue createdIssue = app.soapMethods().addIssue(issue);
    assertEquals(issue.getSummary(), createdIssue.getSummary());
  }
}
