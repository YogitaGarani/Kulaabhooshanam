package Controller;

import AgencyRegister.AgencyRegister;
import App.App;
import Model.AgencyLoginModel;
import Model.LoginModel;
import RegistrationForm.RegistrationForm;
import View.AgencyLoginView;
import View.LoginView;
import View.UserTypeView;

// UserTypeController.java
public class UserTypeController {
    private UserTypeView view;
    private String userType;
    private boolean isLoggedIn;
    private App homePage;

    public UserTypeController(UserTypeView view, App homePage) {
        this.view = view;
        this.homePage = homePage;
    }

    public void proceedButtonClicked() {
        if (view.isAgencySelected()) {
            System.out.println("Selected User Type: Adoption Agency");
            userType = "Adoption Agency";
        } else if (view.isParentSelected()) {
            System.out.println("Selected User Type: Prospective Adoptive Parent");
            userType = "Prospective Adoptive Parent";
        } else {
            System.out.println("No user type selected");
        }
        isLoggedIn = view.isLoggedIn();
        homePage.setType(userType);
        System.out.println(isLoggedIn);
        if (userType.equals("Prospective Adoptive Parent") && isLoggedIn) {
            LoginModel model = new LoginModel();
            LoginView loginForm = new LoginView(view, model, homePage);
            loginForm.setVisible(true);
        } else if (userType.equals("Adoption Agency") && isLoggedIn) {
            // AgencyLogin loginform = new AgencyLogin(null, null);
            AgencyLoginModel model = new AgencyLoginModel();
            AgencyLoginView loginForm = new AgencyLoginView(view, model, homePage);
            loginForm.setVisible(true);
        } else if (userType.equals("Prospective Adoptive Parent") && !isLoggedIn) {
            RegistrationForm regform = new RegistrationForm(null);
            regform.setVisible(true);
        } else if (userType.equals("Adoption Agency") && !isLoggedIn) {
            AgencyRegister regform = new AgencyRegister(null, homePage);
            regform.setVisible(true);
        }
        // Handle the rest of the logic here, such as opening the appropriate form
    }
}

