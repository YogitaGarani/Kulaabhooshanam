package Controller;

import javax.swing.JOptionPane;

import App.App;
import Model.Agency;
import Model.AgencyLoginModel;
import View.AgencyLoginView;

public class AgencyLoginController {
    private AgencyLoginView view;
    private AgencyLoginModel model;
    private App homePage;

    public AgencyLoginController(AgencyLoginView view, AgencyLoginModel model, App homePage) {
        this.view = view;
        this.model = model;
        this.homePage = homePage;
        this.view.setController(this);

        // this.view.addLoginListener(new LoginListener());
        // this.view.addCancelListener(new CancelListener());
    }

        public void loginButtonClicked() {
            String agencyNo = view.getAgencyNo();
            String password = view.getPassword();

            // Perform login action using agencyNo and password
            // Invoke model to authenticate
            Agency user = model.authenticateUser(agencyNo, password);
            if (user != null) {
                homePage.setUser(user);
                // Pass the logged-in user back to the App
                // You may want to change this logic based on your application's structure
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(view,
                        "Aadhar Number or Password is invalid",
                        "Try again.",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
}

