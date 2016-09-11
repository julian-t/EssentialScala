class Prn implements Printable {
  public void print(String s) { System.out.println(s); }
  public void println() { System.out.println(); }
  public void println(String s) { Printable$class.println(this, s); }
}

public class TraitImpl {
    public static void main(String[] args) {
        new Prn().println("Hi!");
    }
}
