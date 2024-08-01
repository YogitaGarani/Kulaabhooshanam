package Model;

// LoginFormModel.java
import java.sql.*;

public class LoginModel {
    public User authenticateUser(String aadhar, String password) {
        User user = null;

        final String DB_URL = "jdbc:mysql://localhost:3306/kulaabhooshanam";
        final String USERNAME = "root";
        final String PASSWORD = "w1o2rk";

        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String sqlSelect = "SELECT * FROM parents WHERE p_id=?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sqlSelect)) {
                preparedStatement.setString(1, aadhar);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        user = new User();
                        user.setName(resultSet.getString("p_name"));
                        user.setEmail(resultSet.getString("email_id"));
                        user.setPhno(resultSet.getString("phno"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
