package Lecture11.sandbox;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[] args) {
    String[] langs = {"Java1", "C#1", "Python1", "PHP1"};

    for (String l : langs) {
      System.out.println("I want to learn " + l);
    }

//    List<String> languages = new ArrayList<String>();
//    languages.add("Java");

    List<String> languages = Arrays.asList("Java2", "C#2", "Python2", "PHP2");

    for (int i = 0; i < languages.size(); i++) {
      System.out.println("I want to learn " + languages.get(i));
    }
  }
}
