package View;

import javax.swing.*;

import App.App;
import Controller.LoginController;
import Model.LoginModel;

import java.awt.*;
import java.awt.event.*;

public class LoginView extends JFrame {
    private JTextField tfAadhar = new JTextField();
    private JButton btnLogin = new JButton("Login");
    private JButton btnCancel = new JButton("Cancel");
    private JPasswordField pfPassword = new JPasswordField();
    private JPanel loginPanel = new JPanel();
    private LoginController controller;


    public LoginView(JFrame parent, LoginModel model, App app) {
        setTitle("Login to your account here");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(450, 430));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        controller = new LoginController(this, model, app);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 5, 5));

        JLabel aadharLabel = new JLabel("Aadhar Number");
        panel.add(aadharLabel);
        panel.add(tfAadhar);

        JLabel pswdLabel = new JLabel("Password");
        panel.add(pswdLabel);
        panel.add(pfPassword);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Notify the controller about the button click
                if (controller != null) {
                    controller.loginButtonClicked();
                }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        panel.add(btnLogin);
        panel.add(btnCancel);
        add(panel);
        pack();
        setVisible(true);
    }

    public String getAadhar() {
        return tfAadhar.getText();
    }

    public String getPassword() {
        return String.valueOf(pfPassword.getPassword());
    }


    public void setController(LoginController controller) {
        this.controller = controller;
    }
}
