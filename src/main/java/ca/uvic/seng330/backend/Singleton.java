package ca.uvic.seng330.backend;

public class Singleton {

  private static final Singleton INSTANCE = new Singleton();
  private Singleton() {
    System.out.println("created");

  }
  public static Singleton getInstance() {
    return INSTANCE;
  }
}
