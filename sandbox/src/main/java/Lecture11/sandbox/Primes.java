package Lecture11.sandbox;

public class Primes {

  public static boolean isPrime(int a) {
    int m = (int)Math.sqrt(a);
    for (int i = 2; i < m; i++) {
      if (a % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPrime(long a) {
    int m = (int)Math.sqrt(a);
    for (long i = 2; i < m; i++) {
      if (a % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPrimeWhile(int a) {
    int i = 2;
    while (i < a && a % i == 0) {
      i++;
    }
    return i == a;
  }
}
