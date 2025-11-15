import java.util.*;
public class EmoticonProgramTests {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    String name = "John Doe";
    int age = 25;
    char grade = 'A';
    String message = "Hello World";
    char initial = 'J';
    int count = 100;
    float hi = 45.34f;
    char h = in.next().charAt(0);
    System.out.println(name);
    System.out.println(age);
    System.out.println(grade);
    System.out.println(message);
    System.out.println(initial);
    System.out.println(count);
    for (int x = 0;x <= 10; x = x + 1) {
    System.out.println("Hi");
    }
    while (count > 90) {
    System.out.println("Hello!");
     count = count - 1;
    }
  }
}
