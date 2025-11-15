import java.util.*;
public class EmoticonProgramTests {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    String name = "";
    name = in.nextLine();
    float radius = 0.0f;
    radius = in.nextFloat();
    float pi = 3.14f;
    float circumference = 2 * pi * radius;
    float area = pi * radius * radius;
    System.out.println(name);
    System.out.println(circumference);
    System.out.println(area);
  }
}
