import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UserRegister {

    public static void registerUser() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        System.out.print("Enter Role (EMPLOYER / JOBSEEKER): ");
        String role = sc.nextLine().toUpperCase();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO users(name, email, password, role) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, role);

            ps.executeUpdate();
            System.out.println("✅ Registration successful!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
