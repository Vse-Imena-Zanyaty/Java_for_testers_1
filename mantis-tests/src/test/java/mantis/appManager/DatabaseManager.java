package mantis.appManager;

import mantis.model.User;
import mantis.model.Users;
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

  public Users usersWithEmails() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<User> result = session.createQuery("from User where username != 'administrator' AND email not like ''").list();
    session.getTransaction().commit();
    session.close();
    return new Users(result);
  }
}
