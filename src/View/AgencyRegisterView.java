package View;

import javax.swing.*;

import App.App;
import Controller.AgencyRegisterController;
import Model.AgencyRegisterModel;

import java.awt.*;
import java.awt.event.*;

public class AgencyRegisterView extends JFrame {
    private JTextField tfAgencyNo = new JTextField();
    private JTextField tfName = new JTextField();
    private JTextField tfEmail = new JTextField();
    private JTextField tfAdoptedKids = new JTextField();
    private JTextField tfInhouseKids = new JTextField();
    private JTextField tfPhno = new JTextField();
    private JTextField TfLocation = new JTextField();
    private JTextField TfAddress = new JTextField();
    private JButton btnRegister = new JButton("Register");
    private JButton btnCancel = new JButton("Cancel");
    private JPanel registerPanel = new JPanel();
    private AgencyRegisterController controller;

    public AgencyRegisterView(JFrame parent, AgencyRegisterModel model, App homePage) {
        setTitle("Create a new account here");
        JPanel panel = new JPanel();
        setContentPane(registerPanel);
        setMinimumSize(new Dimension(450, 430));
        setLocationRelativeTo(parent);
        panel.setLayout(new GridLayout(20, 2, 5, 5));
        this.controller = new AgencyRegisterController(this, model);

        // Add form components
        panel.add(new JLabel("Agency Number"));
        panel.add(tfAgencyNo);
        panel.add(new JLabel("Agency Name"));
        panel.add(tfName);
        panel.add(new JLabel("Official Mailing Address"));
        panel.add(tfEmail);
        panel.add(new JLabel("Official Contact Number"));
        panel.add(tfPhno);
        panel.add(new JLabel("Number of children inhouse"));
        panel.add(tfInhouseKids);
        panel.add(new JLabel("Number of children already adopted"));
        panel.add(tfAdoptedKids);
        panel.add(new JLabel("Location"));
        panel.add(TfLocation);
        panel.add(new JLabel("Address"));
        panel.add(TfAddress);

        // Add buttons to panel
        panel.add(btnRegister);
        panel.add(btnCancel);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Notify the controller about the button click
                if (controller != null) {
                    controller.registerUser();
                }
                dispose();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(panel);
        pack();
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public String getAgencyNo() {
        return tfAgencyNo.getText();
    }

    public String getName() {
        return tfName.getText();
    }

    public String getEmail() {
        return tfEmail.getText();
    }

    public String getAdoptedKids() {
        return tfAdoptedKids.getText();
    }

    public String getInhouseKids() {
        return tfInhouseKids.getText();
    }

    public String getPhno() {
        return tfPhno.getText();
    }

    public String getLoc() {
        return TfLocation.getText();
    }

    public String getAddress() {
        return TfAddress.getText();
    }
}

