package Controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;

import View.AddChildView;
import Model.AddChildModel;

public class AddChildController {
    private AddChildView view;
    private AddChildModel model;
    public AddChildController(AddChildView view, AddChildModel model) {
        this.view = view;
        try {
            this.model = model != null ? model : new AddChildModel("jdbc:mysql://localhost:3306/kulaabhooshanam", "root", "w1o2rk");
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    // Method to handle submitting child information
    public void submitChildInfo() {
        try {
            String name = view.getName();
            String dob = view.getDOB();
            String sex = view.getSex();
            String geneticDisorder = view.getGeneticDisorder();
            int age = view.getAge();

            if (model.childExists(name, dob)) {
                JOptionPane.showMessageDialog(view, "Child already exists.");
                return;
            }

            model.insertChild(name, dob, sex, geneticDisorder, age);
            JOptionPane.showMessageDialog(view, "Child information added successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(view, "Error occurred while adding child information.");
        }
    }

}
