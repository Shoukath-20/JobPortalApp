import java.util.Scanner;

public class EmployerMenu {

    public static void show() {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== EMPLOYER MENU ===");
            System.out.println("1. Post Job");
            System.out.println("2. Logout");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                JobPost.postJob();
            } else if (choice == 2) {
                System.out.println("Logged out");
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}
