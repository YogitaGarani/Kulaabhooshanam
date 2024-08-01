package Controller;
import Model.RegisterModel;
import Model.User;
import View.RegisterView;

import javax.swing.*;

public class RegisterController {
    private RegisterView view;
    private RegisterModel model;
    private User user;

    public RegisterController(RegisterView view, RegisterModel model) {
        this.view = view;
        this.model = model;

        // Add action listeners to view components
        // view.addRegisterListener(e -> registerUser());
        // view.addCancelListener(e -> cancelRegistration());
    }

    public void registerUser() {
        // Get user input from the view
        User user = getUserInput();

        // Validate user input
        if (user == null) {
            JOptionPane.showMessageDialog(view, "Please enter all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Call model to register user
        boolean success = model.registerUser(user);

        // Display appropriate message based on registration success
        if (success) {
            JOptionPane.showMessageDialog(view, "User registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(view, "Failed to register user", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private User getUserInput() {
        user.setName(view.getName());
        user.setEmail(view.getEmail());
        user.setAadhar(view.getAadhar());
        user.setAddress(view.getAddress());
        user.setPassword(view.getPassword());
        user.setNumAdoptedKids(view.getAdoptedKids());
        user.setNumBioKids(view.getBioKids());
        user.setPhno(view.getPhno());
        user.setSex(view.getSex());
        user.setIncome(view.getIncome());
        user.setBankInfo(view.getBank());
        user.setMaritalStatus(view.getMaritalStatus());
        user.setAge(view.getAge());
        user.setSpouseName(view.getSpouseName());
        user.setSpouseAge(view.getSpouseAge());
        user.setSpouseAadhar(view.getSpouseAadhar());
        user.setFinancialStatus(view.getFinStatus());
        user.setCaste(view.getCaste());
        return user;
    }
}

