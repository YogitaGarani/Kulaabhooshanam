package Model;

import java.sql.*;

public class UpdateChildModel {
    private Connection connection;

    public UpdateChildModel(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    public boolean childExists(int id) throws SQLException {
        String sql = "SELECT * FROM children WHERE c_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }

    public void updateChild(int id, String name, String dob, String sex, Timestamp dateAdmitted, String adoptionStatus,
                            String geneticDisorder, int agencyId, int age) throws SQLException {
        String sql = "UPDATE children SET c_name = ?, dob = ?, sex = ?, date_admitted = ?, adoption_status = ?, " +
                "genetic_disorder = ?, agency_id = ?, age = ? WHERE child_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, dob);
        statement.setString(3, sex);
        statement.setTimestamp(4, dateAdmitted);
        statement.setString(5, adoptionStatus);
        statement.setString(6, geneticDisorder);
        statement.setInt(7, agencyId);
        statement.setInt(8, age);
        statement.setInt(9, id);
        statement.executeUpdate();
    }
}
