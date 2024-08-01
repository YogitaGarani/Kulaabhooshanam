package View;

// UserTypeView.java
import javax.swing.*;

import App.App;
import Controller.UserTypeController;

import java.awt.*;
import java.awt.event.*;

public class UserTypeView extends JFrame {
    private JRadioButton agencyRadioButton;
    private JRadioButton parentRadioButton;
    private boolean isLoggedIn = false;
    private JButton btnCancel = new JButton("Proceed");
    private UserTypeController controller;


    public UserTypeView(JFrame parent, boolean login, App homePage) {
        setTitle("What type of user are you?");
        setMinimumSize(new Dimension(450, 600));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.controller = new UserTypeController(this, homePage);

        this.isLoggedIn = login;
        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(new GridLayout(18, 1, 5, 5));
        JLabel typeLabel = new JLabel();
        panel.add(typeLabel);

        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        agencyRadioButton = new JRadioButton("Adoption Agency");
        parentRadioButton = new JRadioButton("Prospective Adoptive Parent");
        ButtonGroup group = new ButtonGroup();
        group.add(agencyRadioButton);
        group.add(parentRadioButton);
        radioPanel.add(agencyRadioButton);
        radioPanel.add(parentRadioButton);
        panel.add(radioPanel);

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Notify the controller about the button click
                if (controller != null) {
                    controller.proceedButtonClicked();
                    dispose();
                }
                dispose();
            }
        });
        panel.add(btnCancel);
    }

    public boolean isLoggedIn() {
        return this.isLoggedIn;
    }
    public boolean isAgencySelected() {
        return agencyRadioButton.isSelected();
    }

    public boolean isParentSelected() {
        return parentRadioButton.isSelected();
    }

}

