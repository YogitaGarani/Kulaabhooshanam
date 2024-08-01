package Controller;

import Model.ApplicationModel;
import View.ApplicationView;

import javax.swing.*;

public class ApplicationController {
    private ApplicationView view;
    private ApplicationModel model;

    public ApplicationController(ApplicationView view, ApplicationModel model) {
        this.view = view;
        this.model = model;
    }


    public void applyForAdoption() {
        String aadhar = view.getAadhar();
        String sex = view.getSexOfChild();
        int age = view.getAgeOfChild();
        String genDisorder = view.isGeneticDisorderSelected() ? "Yes" : "No";

        if (aadhar.isEmpty() || sex.isEmpty()) {
            JOptionPane.showMessageDialog(view,
                    "Please enter all fields",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (age <= 0) {
            JOptionPane.showMessageDialog(view,
                    "Please enter a valid age",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (model.isAlreadyApplied(aadhar)) {
            JOptionPane.showMessageDialog(view,
                    "You have already applied for adoption.",
                    "Already Applied",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (model.addToAdoptionDB(aadhar, sex, age, genDisorder)) {
            JOptionPane.showMessageDialog(view,
            "Adoption Application Successful!",
            "Success!",
            JOptionPane.INFORMATION_MESSAGE);
    return;
        }
    }
}
