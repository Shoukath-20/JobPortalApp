import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Scanner;

public class ApplyJob {

    public static void apply(String userEmail) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Job ID to apply: ");
        int jobId = sc.nextInt();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO applications(job_id, user_email, apply_date) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, jobId);
            ps.setString(2, userEmail);
            ps.setDate(3, java.sql.Date.valueOf(LocalDate.now()));

            ps.executeUpdate();
            System.out.println("✅ Applied for job successfully!");

        } catch (Exception e) {
            System.out.println("❌ You have already applied for this job OR Job ID is invalid.");
        }
    }
}
