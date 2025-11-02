package Martin;

import java.util.Scanner;

public class AcceptanceChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("States: q0 (start), q1, q2 (accept)");
        
        while (true) {
            System.out.print("Enter a binary string: ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            if (!input.matches("[01]+")) {
                System.out.println("Invalid input! Please enter only 0s and 1s.\n");
                continue;
            }

            String state = "q0";

            for (int i = 0; i < input.length(); i++) {
                char symbol = input.charAt(i);

                switch (state) {
                    case "q0":
                        if (symbol == '0') state = "q1";
                        else if (symbol == '1') state = "q0";
                        break;

                    case "q1":
                        if (symbol == '0') state = "q1";
                        else if (symbol == '1') state = "q2";
                        break;

                    case "q2":
                        if (symbol == '0') state = "q1";
                        else if (symbol == '1') state = "q0";
                        break;
                }
            }

            if (state.equals("q2")) {
                System.out.println("Accepted\n");
            } else {
                System.out.println("Rejected\n");
            }
        }
    }
}
