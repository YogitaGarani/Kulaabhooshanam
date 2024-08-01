package Model;

import java.sql.*;

public class AddChildModel {
    private Connection connection;

    public AddChildModel(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    public boolean childExists(String name, String dob) throws SQLException {
        String sql = "SELECT * FROM children WHERE c_name = ? AND dob = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, dob);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }

    public void insertChild(String name, String dob, String sex, String geneticDisorder, int age) throws SQLException {
        String adoptionStatus = "inhouse";
        Timestamp dateAdmitted = new Timestamp(System.currentTimeMillis());
        int agencyId = 101;

        String sql = "INSERT INTO children (c_name, dob, sex, date_admitted, adoption_status, genetic_disorder, agency_id, age) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, name);
        statement.setString(2, dob);
        statement.setString(3, sex);
        statement.setTimestamp(4, dateAdmitted);
        statement.setString(5, adoptionStatus);
        statement.setString(6, geneticDisorder);
        statement.setInt(7, agencyId);
        statement.setInt(8, age);

        statement.executeUpdate();
    }
}
