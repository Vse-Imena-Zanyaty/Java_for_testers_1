package Lecture22.addressbook.tests;

import Lecture22.addressbook.objects.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class HBconnection {

  private SessionFactory sessionFactory;

  @BeforeClass
  protected void setUp() throws Exception {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    try {
      sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    } catch (Exception e) {
      e.printStackTrace();
      // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
      // so destroy it manually.
      StandardServiceRegistryBuilder.destroy(registry);
    }
  }

  @Test(enabled = false)
  public void testHibernateConnection() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
/*    List<Group> result = session.createQuery("from Group").list();
    for (Group group : result) {
      System.out.println(group);
    }*/
    List<Contact> result = session.createQuery("from Contact where deprecated = '0000-00-00'").list();
    for (Contact contact : result) {
      System.out.println(contact);
    }
    session.getTransaction().commit();
    session.close();
  }
}