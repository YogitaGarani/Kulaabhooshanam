package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgencyRegisterModel {

    public boolean registerAgency(Agency agency) {
        final String DB_URL = "jdbc:mysql://localhost:3306/kulaabhooshanam";
        final String USERNAME = "root";
        final String PASSWORD = "w1o2rk";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sqlSelect = "SELECT * FROM adoptionagency WHERE agency_id=?";
            
            try (PreparedStatement preparedStatement = conn.prepareStatement(sqlSelect)) {
                preparedStatement.setInt(1, agency.getAgencyNo());
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Agency already exists, return null
                        return false;
                    } else {
                        // Add new agency
                        String sql = "INSERT INTO ADOPTIONAGENCY (`agency_name`, `location`, `address`, `phno`, `email_id`, `numkids`, `num_succ_ad`) VALUES (?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement preparedStatement2 = conn.prepareStatement(sql);
                        preparedStatement2.setString(1, agency.getAgencyName());
                        preparedStatement2.setString(2, agency.getLocation());
                        preparedStatement2.setString(3, agency.getAddress());
                        preparedStatement2.setString(4, agency.getPh());
                        preparedStatement2.setString(5, agency.getEmailId());
                        preparedStatement2.setInt(6, agency.getNumInhouseKids());
                        preparedStatement2.setInt(7, agency.getNumAdoptedKids());
                        int addedRows = preparedStatement2.executeUpdate();
                        conn.close();
                        return addedRows > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

