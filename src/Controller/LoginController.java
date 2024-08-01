package Controller;

import javax.swing.JOptionPane;

import App.App;
import Model.LoginModel;
// LoginFormController.java
import Model.User;
import View.LoginView;

public class LoginController {
    private LoginView view;
    private LoginModel model;
    private App homePage;

    public LoginController(LoginView view, LoginModel model, App homePage) {
        this.view = view;
        this.model = model;
        this.homePage = homePage;
        this.view.setController(this);
    }

    public void loginButtonClicked() {
        String aadhar = view.getAadhar();
        String password = view.getPassword();

        User user = model.authenticateUser(aadhar, password);
        System.out.println(user);
        if (user != null) {
            // Pass the logged-in user back to the App
            // You may want to change this logic based on your application's structure
            homePage.setUser(user);
            System.out.println("homepage set user");
            view.dispose();
        } else {
            JOptionPane.showMessageDialog(view,
                    "Aadhar Number or Password is invalid",
                    "Try again.",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
