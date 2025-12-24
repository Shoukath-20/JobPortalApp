import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== JOB PORTAL ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    UserRegister.registerUser();
                    break;

                case 2:
                    UserLogin.loginUser();
                    break;

                case 3:
                    System.out.println("Thank you. Bye!");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
