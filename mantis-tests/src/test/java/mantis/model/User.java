package mantis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "mantis_user_table")
public class User {
  @Id
  @Column(name = "id")
  private int ID = Integer.MAX_VALUE;

  @Column(name = "username")
  private String username;

  @Column(name = "email")
  private String email;


  public User withID(int ID) {
    this.ID = ID;
    return this;
  }

  public User withUsername(String username) {
    this.username = username;
    return this;
  }

  public User withEmail(String email) {
    this.email = email;
    return this;
  }

  public int getID() {
    return ID;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }


  @Override
  public String toString() {
    return "User{" +
            "ID=" + ID +
            ", username='" + username + '\'' +
            ", email='" + email + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return ID == user.ID &&
            Objects.equals(username, user.username) &&
            Objects.equals(email, user.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID, username, email);
  }
}
