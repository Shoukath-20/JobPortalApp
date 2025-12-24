import java.util.Scanner;

public class JobSeekerMenu {

    public static void show(String email) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== JOB SEEKER MENU ===");
            System.out.println("1. View Jobs");
            System.out.println("2. Apply for Job");
            System.out.println("3. Logout");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                ViewJobs.showJobs();
            } else if (choice == 2) {
                ApplyJob.apply(email);
            } else if (choice == 3) {
                System.out.println("Logged out");
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}
