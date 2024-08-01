package View;

import javax.swing.*;

import Controller.UpdateChildController;
import Model.UpdateChildModel;

import java.awt.*;
import java.awt.event.*;

public class UpdateChildView extends JDialog {
    private JTextField ageField, dobField, nameField, geneticDisorderField, idField, agencyIDField;
    private JComboBox<String> sexComboBox, AdoptionComboBox;
    private JButton submitButton;
    private UpdateChildController controller;
    private JPanel updatechildPanel = new JPanel();

    public UpdateChildView(UpdateChildModel model) {
        initializeUI();
        controller = new UpdateChildController(this, model);
    }
    /**
     * Initializes the UI components of the UpdateChild dialog.
     */
    private void initializeUI() {
        setTitle("Child Information Form");
        setContentPane(updatechildPanel);
        setMinimumSize(new Dimension(450, 430));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 1, 5, 5));

        JLabel idLabel = new JLabel("Child ID:");
        idField = new JTextField();
        panel.add(idLabel);
        panel.add(idField);

        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField();
        panel.add(ageLabel);
        panel.add(ageField);

        JLabel dobLabel = new JLabel("Date of Birth (YYYY-MM-DD):");
        dobField = new JTextField();
        panel.add(dobLabel);
        panel.add(dobField);

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        panel.add(nameLabel);
        panel.add(nameField);

        JLabel sexLabel = new JLabel("Sex:");
        String[] sexOptions = {"Male", "Female", "Other"};
        sexComboBox = new JComboBox<>(sexOptions);
        panel.add(sexLabel);
        panel.add(sexComboBox);

        JLabel geneticDisorderLabel = new JLabel("Genetic Disorder:");
        geneticDisorderField = new JTextField();
        panel.add(geneticDisorderLabel);
        panel.add(geneticDisorderField);

        JLabel agencyIDLabel = new JLabel("Agency ID");
        agencyIDField = new JTextField();
        panel.add(agencyIDLabel);
        panel.add(agencyIDField);

        JLabel adoptionLabel = new JLabel("Adoption Status:");
        String[] AdoptionStatus = {"Inhouse", "Adopted"};
        AdoptionComboBox = new JComboBox<>(AdoptionStatus);
        panel.add(adoptionLabel);
        panel.add(AdoptionComboBox);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.submitChildInfo();
            }
        });
        panel.add(submitButton);

        add(panel);
    }

    public String getName() {
        return nameField.getText();
    }

    public String getDOB() {
        return dobField.getText();
    }

    public String getSex() {
        return (String) sexComboBox.getSelectedItem();
    }

    public String getGeneticDisorder() {
        return geneticDisorderField.getText();
    }

    public String getAdoptionStatus() {
        return (String) AdoptionComboBox.getSelectedItem();
    }

    public int getAgencyID() {
        return Integer.parseInt(agencyIDField.getText());
    }

    public int getAge() {
        return Integer.parseInt(ageField.getText());
    }

    public int getId() {
        return Integer.parseInt(idField .getText());
    }
    // Implement methods to get other field values

    public void addSubmitListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void clearFields() {
    }
}

