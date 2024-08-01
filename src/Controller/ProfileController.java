package Controller;

import java.sql.SQLException;
import Model.ProfileModel;
import View.ProfileView;

public class ProfileController {
    private ProfileView view;
    private ProfileModel model;

    public ProfileController(ProfileView view, ProfileModel model) {
        this.view = view;
        this.model = model;
    }

    public void viewDetailsButtonClicked(String aadharNumber) {
        try {
            String userDetails = model.getUserDetails(aadharNumber);
            String childDetails = model.getChildDetails(aadharNumber);

            view.setUserDetails(userDetails);
            view.setChildDetails(childDetails);
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle database error
        }
    }
}
