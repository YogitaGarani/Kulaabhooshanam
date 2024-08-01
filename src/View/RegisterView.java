package View;

import javax.swing.*;

import App.App;
import Controller.RegisterController;
import Model.RegisterModel;

import java.awt.*;
import java.awt.event.*;

public class RegisterView extends JFrame {
    private JTextField tfAadhar = new JTextField();
    private JTextField tfName = new JTextField();
    private JTextField tfEmail = new JTextField();
    private JTextField tfAdoptedKids = new JTextField();
    private JTextField tfBioKids = new JTextField();
    private JTextField tfPhno = new JTextField();
    private JTextField tfSex = new JTextField();
    private JTextField tfIncome = new JTextField();
    private JTextField tfBank = new JTextField();
    private JTextField tfMaritalstatus = new JTextField();
    private JTextField tfAge = new JTextField();
    private JTextField tfSpouseName = new JTextField();
    private JTextField tfSpouseAge = new JTextField();
    private JTextField tfAddress = new JTextField();
    private JTextField tfFinStatus = new JTextField();
    private JTextField tfSpouseAadhar = new JTextField();
    private JTextField tfCaste = new JTextField();
    private JButton btnRegister = new JButton("Register");
    private JButton btnCancel = new JButton("Cancel");
    private JPasswordField pfPassword = new JPasswordField();
    private RegisterController controller;

    public RegisterView(JFrame parent, RegisterModel model, App homePage) {
        setTitle("Create a new account here");
        setMinimumSize(new Dimension(450, 560));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        controller = new RegisterController(null, model);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(20, 2, 5, 5));

        // Add components to the panel
        panel.add(new JLabel("Aadhar Number"));
        panel.add(tfAadhar);

        panel.add(new JLabel("Password"));
        panel.add(pfPassword);

        panel.add(new JLabel("Enter your name"));
        panel.add(tfName);

        panel.add(new JLabel("Enter your email"));
        panel.add(tfEmail);

        panel.add(new JLabel("Number of adopted children"));
        panel.add(tfAdoptedKids);

        panel.add(new JLabel("Number of biological children"));
        panel.add(tfBioKids);

        panel.add(new JLabel("Phone number"));
        panel.add(tfPhno);

        panel.add(new JLabel("Enter your bank details"));
        panel.add(tfBank);

        panel.add(new JLabel("Parent sex"));
        panel.add(tfSex);

        panel.add(new JLabel("Enter your age"));
        panel.add(tfAge);

        panel.add(new JLabel("Income"));
        panel.add(tfIncome);

        panel.add(new JLabel("Marital status"));
        panel.add(tfMaritalstatus);

        panel.add(new JLabel("Spouse name"));
        panel.add(tfSpouseName);

        panel.add(new JLabel("Spouse age"));
        panel.add(tfSpouseAge);

        panel.add(new JLabel("Spouse Aadhar number"));
        panel.add(tfSpouseAadhar);

        panel.add(new JLabel("Address"));
        panel.add(tfAddress);

        panel.add(new JLabel("Financial status"));
        panel.add(tfFinStatus);

        panel.add(new JLabel("Caste"));
        panel.add(tfCaste);

        panel.add(btnRegister);
        panel.add(btnCancel);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Notify the controller about the button click
                if (controller != null) {
                    controller.registerUser();
                }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Add panel to frame
        add(panel);
    }

    // Getters for user input
    public String getAadhar() {
        return tfAadhar.getText();
    }

    public String getPassword() {
        return String.valueOf(pfPassword.getPassword());
    }

    public String getName() {
        return tfName.getText();
    }

    public String getEmail() {
        return tfEmail.getText();
    }

    public int getAdoptedKids() {
        return Integer.parseInt(tfAdoptedKids.getText());
    }

    public int getBioKids() {
        return Integer.parseInt(tfBioKids.getText());
    }

    public String getPhno() {
        return tfPhno.getText();
    }

    public String getSex() {
        return tfSex.getText();
    }

    public int getIncome() {
        return Integer.parseInt(tfIncome.getText());
    }

    public String getBank() {
        return tfBank.getText();
    }

    public String getMaritalStatus() {
        return tfMaritalstatus.getText();
    }

    public int getAge() {
        return Integer.parseInt(tfAge.getText());
    }

    public String getSpouseName() {
        return tfSpouseName.getText();
    }

    public int getSpouseAge() {
        return Integer.parseInt(tfSpouseAge.getText());
    }

    public String getSpouseAadhar() {
        return tfSpouseAadhar.getText();
    }

    public String getAddress() {
        return tfAddress.getText();
    }

    public String getFinStatus() {
        return tfFinStatus.getText();
    }

    public String getCaste() {
        return tfCaste.getText();
    }

}
