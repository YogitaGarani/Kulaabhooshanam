package Model;

import java.sql.*;

public class ProfileModel {
    public String getUserDetails(String aadharNumber) throws SQLException {
        StringBuilder userDetails = new StringBuilder();

        // Establish database connection
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kulaabhooshanam", "root", "w1o2rk")) {
            // Retrieve user details based on Aadhar number
            String userDetailsQuery = "SELECT * FROM parents p JOIN application a ON p.p_id = a.p_id WHERE p.p_id = ?";
            try (PreparedStatement userDetailsStatement = conn.prepareStatement(userDetailsQuery)) {
                userDetailsStatement.setString(1, aadharNumber);
                try (ResultSet userDetailsResult = userDetailsStatement.executeQuery()) {
                    if (userDetailsResult.next()) {
                        userDetails.append("Name: ").append(userDetailsResult.getString("p_name")).append("\n")
                                .append("Email: ").append(userDetailsResult.getString("email_id")).append("\n")
                                .append("Phone: ").append(userDetailsResult.getString("phno")).append("\n")
                                .append("Address: ").append(userDetailsResult.getString("address")).append("\n")
                                .append("Child's age: ").append(userDetailsResult.getInt("child_age")).append("\n")
                                .append("Child genetic disorder: ").append(userDetailsResult.getString("g_disorder"));
                    }
                }
            }
        }

        return userDetails.toString();
    }

    public String getChildDetails(String aadharNumber) throws SQLException {
        StringBuilder childDetails = new StringBuilder();

        // Establish database connection
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kulaabhooshanam", "root", "w1o2rk")) {
            // Retrieve child details mapped to the user
            String childDetailsQuery = "SELECT c.* FROM children c JOIN parents p ON c.child_id = p.c_id WHERE p.p_id = ?";
            try (PreparedStatement childDetailsStatement = conn.prepareStatement(childDetailsQuery)) {
                childDetailsStatement.setString(1, aadharNumber);
                try (ResultSet childDetailsResult = childDetailsStatement.executeQuery()) {
                    if (childDetailsResult.next()) {
                        childDetails.append("Child Name: ").append(childDetailsResult.getString("c_name")).append("\n")
                                .append("Child DOB: ").append(childDetailsResult.getDate("dob")).append("\n")
                                .append("Child Gender: ").append(childDetailsResult.getString("sex"));
                    } else {
                        childDetails.append("No child mapped to the user.");
                    }
                }
            }
        }

        return childDetails.toString();
    }
}
