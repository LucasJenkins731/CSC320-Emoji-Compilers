import java.util.*;
public class EmoticonProgramTests {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int a = 5;
    double b = add(a);
    double c = multiply(b);
    int d = getConstant();
    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
    System.out.println(d);
    double result = add(10) + multiply(5);
    System.out.println(result);
  }
  public static double add(double x) {
    double result = x + 10;
    return result;
  }

  public static int getConstant() {
    return 42;
  }

  public static double multiply(double x) {
    return x * 2;
  }

}
