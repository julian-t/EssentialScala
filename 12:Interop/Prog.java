public class Prog {
  public static void main(String[] args) {
    new Test().func1();     // instance method
    Test.func2();           // static method in companion
    Test$.MODULE$.func1();  // hidden static method in companion
  }
}
