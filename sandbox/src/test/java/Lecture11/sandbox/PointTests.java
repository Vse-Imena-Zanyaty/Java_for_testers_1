package Lecture11.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance1() {
    Point p1 = new Point(1, -3);
    Point p2 = new Point(-1, 1);
    Assert.assertEquals(p1.distance(p2), Math.sqrt(20));
  }

  @Test
  public void testDistance2() {
    Point p1 = new Point(2, 2);
    Point p2 = new Point(2, 2);
    Assert.assertEquals(p1.distance(p2), 0);
  }

  @Test
  public void testDistance3() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 0);
    Assert.assertEquals(p1.distance(p2), 0);
  }
}
