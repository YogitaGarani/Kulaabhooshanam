package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicationModel {

    public boolean isAlreadyApplied(String aadhar) {
        final String url = "jdbc:mysql://localhost:3306/kulaabhooshanam";
        final String user = "root";
        final String password = "w1o2rk";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM application WHERE p_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, aadhar);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
            // Consider error as already applied to prevent unintended application
            return true;
        }
    }

    public boolean addToAdoptionDB(String aadhar, String sex, int age, String genDisorder) {
        final String DB_URL = "jdbc:mysql://localhost:3306/kulaabhooshanam";
        final String USERNAME = "root";
        final String PASSWORD = "w1o2rk";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String sql = "INSERT INTO application(p_id, sex, child_age, g_disorder)"
                    + "VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, aadhar);
            preparedStatement.setString(2, sex);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, genDisorder);

            int addedRows = preparedStatement.executeUpdate();
            if (addedRows > 0) {
                return true;
            }

            conn.close();
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
