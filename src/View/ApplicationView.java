package View;

import javax.swing.*;

import Controller.ApplicationController;
import Model.ApplicationModel;

import java.awt.*;
import java.awt.event.*;

public class ApplicationView extends JFrame {
    private JTextField tfAadhar = new JTextField();
    private JTextField tfAgeOfChild = new JTextField();
    private JTextField tfSexofChild = new JTextField();
    private JButton btnApply = new JButton("Apply Now");
    private JButton btnCancel = new JButton("Cancel");
    private JPanel applyPanel = new JPanel();
    private JRadioButton yesRadioButton;
    private JRadioButton noRadioButton;
    private ApplicationController controller;

    public ApplicationView(JFrame parent, ApplicationModel model) {
        setTitle("Apply for adoption here");
        setContentPane(applyPanel);
        setMinimumSize(new Dimension(500, 600));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        controller = new ApplicationController(this, model);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 5, 5));

        // Add form components
        // Adding JLabels, JTextFields, JRadioButtons, and JButtons
        panel.setLayout(new GridLayout(6, 2, 5, 5));

        JLabel aadharLabel = new JLabel("Aadhar number of parent");
        panel.add(aadharLabel);
        panel.add(tfAadhar);

        JLabel sexLabel = new JLabel("Desired sex of child");
        panel.add(sexLabel);
        panel.add(tfSexofChild);

        JLabel ageLabel = new JLabel("Desired age of child");
        panel.add(ageLabel);
        panel.add(tfAgeOfChild);


        JLabel lblGenDisorder = new JLabel("Genetic Disorder:");
        panel.add(lblGenDisorder);
    
        // gbc.gridx = 1;
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        yesRadioButton = new JRadioButton("Yes");
        noRadioButton = new JRadioButton("No");
        ButtonGroup group = new ButtonGroup();
        group.add(yesRadioButton);
        group.add(noRadioButton);
        radioPanel.add(yesRadioButton);
        radioPanel.add(noRadioButton);
        panel.add(radioPanel);


        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnApply = new JButton("Apply");
        btnCancel = new JButton("Cancel");
        buttonPanel.add(btnApply);
        buttonPanel.add(btnCancel);
        panel.add(buttonPanel);
        add(panel);


        btnApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.applyForAdoption();
                dispose();
            }
        });


        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.out.println("Application cancelled");
            }
        });

        setVisible(true);

        add(panel);
    }

    public String getAadhar() {
        return tfAadhar.getText();
    }

    public String getSexOfChild() {
        return tfSexofChild.getText();
    }

    public int getAgeOfChild() {
        return Integer.parseInt(tfAgeOfChild.getText());
    }

    public boolean isGeneticDisorderSelected() {
        return yesRadioButton.isSelected();
    }

    public void addApplyListener(ActionListener listener) {
        btnApply.addActionListener(listener);
    }

    public void addCancelListener(ActionListener listener) {
        btnCancel.addActionListener(listener);
    }

    public void clearFields() {
        tfAadhar.setText("");
        tfAgeOfChild.setText("");
        tfSexofChild.setText("");
        yesRadioButton.setSelected(false);
        noRadioButton.setSelected(false);
    }
}
