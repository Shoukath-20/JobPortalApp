import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewJobs {

    public static void showJobs() {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM jobs";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n=== AVAILABLE JOBS ===");
            System.out.println("ID | Title | Company | Location | Salary");
            System.out.println("-------------------------------------------");

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println(
                    rs.getInt("job_id") + " | " +
                    rs.getString("title") + " | " +
                    rs.getString("company") + " | " +
                    rs.getString("location") + " | " +
                    rs.getDouble("salary")
                );
            }

            if (!found) {
                System.out.println("No jobs available.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
