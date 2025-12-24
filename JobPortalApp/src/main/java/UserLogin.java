import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserLogin {

    public static void loginUser() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");
                String name = rs.getString("name");
                email = rs.getString("email");


                System.out.println("✅ Login successful! Welcome " + name);
                System.out.println("Your role: " + role);

                if (role.equalsIgnoreCase("EMPLOYER")) {
                    EmployerMenu.show();
                } else {
                    JobSeekerMenu.show(email);
                }

            } else {
                System.out.println("❌ Invalid email or password");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
