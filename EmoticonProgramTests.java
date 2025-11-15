import java.util.*;
public class EmoticonProgramTests {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int n = 0;
    n = in.nextInt();
    float first_val = 0.0f;
    first_val = in.nextFloat();
    float total = first_val;
    float mn = first_val;
    float mx = first_val;
    int pos = 0;
    int neg = 0;
    int zero = 0;
    if (first_val > 0) {
    pos = 1;
    }
    else if (first_val < 0) {
    neg = 1;
    }
    else {
    zero = 1;
    }
    int i = 1;
    while (i < n) {
    float x = 0.0f;
    x = in.nextFloat();
    total = total + x;
    if (x < mn) {
    mn = x;
    }
    if (x > mx) {
    mx = x;
    }
    if (x > 0) {
    pos = pos + 1;
    }
    else if (x < 0) {
    neg = neg + 1;
    }
    else {
    zero = zero + 1;
    }
    i = i + 1;
    }
    System.out.println("sum = ");
    System.out.println(total);
    System.out.println("min = ");
    System.out.println(mn);
    System.out.println("max = ");
    System.out.println(mx);
    System.out.println("pos = ");
    System.out.println(pos);
    System.out.println("neg = ");
    System.out.println(neg);
    System.out.println("zero = ");
    System.out.println(zero);
  }
}
