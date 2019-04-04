package Lecture22.addressbook.appManager;

import Lecture22.addressbook.objects.Contact;
import Lecture22.addressbook.objects.Contacts;
import Lecture22.addressbook.objects.Group;
import Lecture22.addressbook.objects.Groups;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class DatabaseManager {

  private final SessionFactory sessionFactory;

  public DatabaseManager() {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
  }

  public Groups groups() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<Group> result = session.createQuery("from Group").list();
    session.getTransaction().commit();
    session.close();
    return new Groups(result);
  }

  public Contacts contacts() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<Contact> result = session.createQuery("from Contact where deprecated = '0000-00-00'").list();
    session.getTransaction().commit();
    session.close();
    return new Contacts(result);
  }

  public Groups groupsWithoutContacts() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<Group> result = session.createNativeQuery
            ("SELECT group_list.* FROM group_list LEFT JOIN address_in_groups on address_in_groups.group_id = group_list.group_id WHERE address_in_groups.group_id is NULL", Group.class).list();
    session.getTransaction().commit();
    session.close();
    return new Groups(result);
  }

  public Contacts contactsWithoutGroups() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<Contact> result = session.createNativeQuery
            ("SELECT addressbook.* FROM addressbook LEFT JOIN address_in_groups on address_in_groups.id = addressbook.id WHERE address_in_groups.id is NULL AND addressbook.deprecated = '0000-00-00'", Contact.class).list();
    session.getTransaction().commit();
    session.close();
    return new Contacts(result);
  }

  public Contacts contactsWithGroups() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<Contact> result = session.createNativeQuery
            ("SELECT DISTINCT addressbook.* FROM addressbook INNER JOIN address_in_groups on address_in_groups.id = addressbook.id WHERE addressbook.deprecated = '0000-00-00'", Contact.class).list();
    session.getTransaction().commit();
    session.close();
    return new Contacts(result);
  }
}
