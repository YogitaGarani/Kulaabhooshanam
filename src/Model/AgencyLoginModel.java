package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgencyLoginModel {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/kulaabhooshanam";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "w1o2rk";

    public Agency authenticateUser(String agencyNo, String password) {
        Agency agency = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sqlSelect = "SELECT * FROM adoptionagency WHERE agency_id=? AND phno=?";
            preparedStatement = conn.prepareStatement(sqlSelect);
            preparedStatement.setInt(1, Integer.parseInt(agencyNo));
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                agency = new Agency();
                agency.setAgencyName(resultSet.getString("agency_name"));
                agency.setEmailId(resultSet.getString("email_id"));
                agency.setPh(resultSet.getString("phno"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return agency;
    }
}
