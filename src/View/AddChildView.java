package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Controller.AddChildController;
import Model.AddChildModel;

public class AddChildView extends JDialog {
    private JTextField ageField, dobField, nameField, geneticDisorderField;
    private JComboBox<String> sexComboBox;
    private JButton submitButton;
    private AddChildController controller;
    private JPanel addchildPanel = new JPanel();

    public AddChildView(AddChildModel model) {
        initializeUI();
        controller = new AddChildController(this, model);
    }


    /**
     * Initializes the UI components of the AddChild dialog.
     */
    private void initializeUI() {
        setTitle("Child Information Form");
        setMinimumSize(new Dimension(450, 430));
        setContentPane(addchildPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 5, 5));

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

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 18));
        submitButton.setBackground(new Color(4, 170, 109));
        submitButton.setForeground(Color.WHITE);
        submitButton.setBorderPainted(false);
        submitButton.setFocusPainted(false);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.submitChildInfo();
                dispose();
            }
        });
        panel.add(submitButton);

        add(panel);
    }

    public String getName() {
        return nameField.getText();
    }

    public String getDOB() {
        System.out.println(dobField.getText());
        return dobField.getText();
    }

    public String getSex() {
        return (String) sexComboBox.getSelectedItem();
    }

    public String getGeneticDisorder() {
        String geneticDisorder = geneticDisorderField.getText();
        return (geneticDisorder == null || geneticDisorder.trim().isEmpty()) ? "None" : geneticDisorder;
    }

    public int getAge() {
        return Integer.parseInt(ageField.getText());
    }

    public void clearFields() {
        nameField.setText("");
        dobField.setText("");
        geneticDisorderField.setText("");
    }

    // public void addSubmitListener(ActionListener listener) {
        // submitButton.addActionListener(listener);
    // }

}

