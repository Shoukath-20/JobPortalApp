import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JobPost {

    public static void postJob() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Job Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Company Name: ");
        String company = sc.nextLine();

        System.out.print("Enter Location: ");
        String location = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO jobs(title, company, location, salary) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, company);
            ps.setString(3, location);
            ps.setDouble(4, salary);

            ps.executeUpdate();
            System.out.println("✅ Job posted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
