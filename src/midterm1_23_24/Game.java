package midterm1_23_24;

import java.util.Scanner;

public class Game {

    public static int lastValue(int a, int b, int r) {
        if (r == 0 || r == 1) {
            return 1;
        }
        if (r % 2 == 0) {
            return lastValue(a, b, r - 1) + lastValue(a, b, r - 2) + a;
        } else {
            return lastValue(a, b, r - 1) + lastValue(a, b, r - 2) + b;
        }
    }

    public static void winner() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter values for a, b, and r: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int r = scanner.nextInt();

        int result = lastValue(a, b, r);

        if (result % 2 == 0) {
            System.out.println("Ana");
        } else {
            System.out.println("Beso");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        winner();
    }
}
