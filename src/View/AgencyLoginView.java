package View;

import javax.swing.*;

import App.App;
import Controller.AgencyLoginController;
import Model.AgencyLoginModel;

import java.awt.*;
import java.awt.event.*;

public class AgencyLoginView extends JFrame {
    private JTextField tfAgencyNo = new JTextField();
    private JButton btnLogin = new JButton("Login");
    private JButton btnCancel = new JButton("Cancel");
    private JPasswordField pfPassword = new JPasswordField();
    private JPanel loginPanel = new JPanel();
    private AgencyLoginController controller;


    public AgencyLoginView(JFrame parent, AgencyLoginModel model, App homePage) {
        setTitle("Login to your account here");
        JPanel panel = new JPanel();
        setContentPane(loginPanel);
        panel.setLayout(new GridLayout(6, 2, 5, 5));
        controller = new AgencyLoginController(this, model, homePage);
        setMinimumSize(new Dimension(450, 430));
        setLocationRelativeTo(parent);
        // Add form components
        panel.add(new JLabel("Registered Agency Number"));
        panel.add(tfAgencyNo);
        panel.add(new JLabel("Password"));
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

    public String getAgencyNo() {
        return tfAgencyNo.getText();
    }

    public String getPassword() {
        return String.valueOf(pfPassword.getPassword());
    }

    public void addLoginListener(ActionListener listener) {
        btnLogin.addActionListener(listener);
    }

    public void addCancelListener(ActionListener listener) {
        btnCancel.addActionListener(listener);
    }
    public void setController(AgencyLoginController controller) {
        this.controller = controller;
    }
}
