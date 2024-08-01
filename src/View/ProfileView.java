package View;

import javax.swing.*;

import Controller.ProfileController;
import Model.ProfileModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileView extends JDialog {
    private JTextField tfAadhar = new JTextField();
    private JTextArea userDetailsArea = new JTextArea(10, 40);
    private JTextArea childDetailsArea = new JTextArea(10, 40);
    private JButton viewDetailsButton = new JButton("View Details");
    private ProfileController controller;


    public ProfileView(JFrame parent, ProfileModel model) {
        setTitle("View your details here");
        setLayout(new BorderLayout());
        setSize(600, 400);
        setLocationRelativeTo(null);

        controller = new ProfileController(this, model);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        JLabel aadharLabel = new JLabel("Aadhar Number");

        inputPanel.add(aadharLabel);
        inputPanel.add(tfAadhar);
        inputPanel.add(viewDetailsButton);

        add(inputPanel, BorderLayout.NORTH);

        JPanel detailsPanel = new JPanel(new GridLayout(2, 1));
        JScrollPane userDetailsScrollPane = new JScrollPane(userDetailsArea);
        JScrollPane childDetailsScrollPane = new JScrollPane(childDetailsArea);

        userDetailsArea.setEditable(false);
        childDetailsArea.setEditable(false);

        detailsPanel.add(userDetailsScrollPane);
        detailsPanel.add(childDetailsScrollPane);

        add(detailsPanel, BorderLayout.CENTER);

        viewDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Notify controller that view details button is clicked
                if (controller != null) {
                    controller.viewDetailsButtonClicked(tfAadhar.getText().trim());
                }
            }
        });

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void setUserDetails(String details) {
        userDetailsArea.setText(details);
    }

    public void setChildDetails(String details) {
        childDetailsArea.setText(details);
    }
}

