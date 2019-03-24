package Lecture22.addressbook.objects;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Groups extends ForwardingSet<Group> {

  private Set<Group> delegate;

  public Groups(Groups groups) {
    this.delegate = new HashSet<Group>(groups.delegate);
  }

  public Groups() {
    this.delegate = new HashSet<Group>();
  }

  public Groups(Collection<Group> groups) {
    this.delegate = new HashSet<Group>(groups);
  }

  @Override
  protected Set<Group> delegate() {
    return delegate;
  }

  public Groups withAdded(Group group) {
    Groups groups = new Groups(this);
    groups.add(group);
    return groups;
  }

  public Groups without(Group group) {
    Groups groups = new Groups(this);
    groups.remove(group);
    return groups;
  }
}
