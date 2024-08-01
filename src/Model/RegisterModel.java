package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterModel {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/kulaabhooshanam";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "w1o2rk";

    public boolean registerUser(User user) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO parents(p_id, p_name, email_id, pswd, n_bio_kids, n_adopted_kids, appln_status, phno, sex, annual_income, bank_details, marital_status, age, spouse_age, spouse_name, address, financial_status, caste, spouse_aadhar) " +
                         "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getAadhar());
                preparedStatement.setString(2, user.getName());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setInt(5, user.getNumBioKids());
                preparedStatement.setInt(6, user.getNumAdoptedKids());
                preparedStatement.setString(7, "null");
                preparedStatement.setString(8, user.getPhno());
                preparedStatement.setString(9, user.getSex());
                preparedStatement.setInt(10, user.getIncome());
                preparedStatement.setString(11, user.getBankInfo());
                preparedStatement.setString(12, user.getMaritalStatus());
                preparedStatement.setInt(13, user.getAge());
                preparedStatement.setInt(14, user.getSpouseAge());
                preparedStatement.setString(15, user.getSpouseName());
                preparedStatement.setString(16, user.getAddress());
                preparedStatement.setString(17, user.getFinancialStatus());
                preparedStatement.setString(18, user.getCaste());
                preparedStatement.setString(19, user.getSpouseAadhar());

                int addedRows = preparedStatement.executeUpdate();
                return addedRows > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

