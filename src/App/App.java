package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import Model.AddChildModel;
import Model.ApplicationModel;
import Model.LoginModel;
import Model.UpdateChildModel;
import Profile.Profile;
import Model.User;
import Model.Agency;
import View.AddChildView;
import View.ApplicationView;
import View.LoginView;
import View.UpdateChildView;
import View.UserTypeView;

public class App extends JFrame {

    // Variables for tracking logged-in user and agency
    private User loggedInUser;
    private Agency loggedInAgency;
    // Boolean to track login type
    private Boolean loginType = false;
    // UserType object for role selection
    // Buttons for different actions
    private JButton addchildButton = new JButton("Add Child");
    private JButton updateChildButton = new JButton("Update Child");
    private JButton profileButton = new JButton("Profile");
    private JButton applyNowButton = new JButton("Apply Now");
    private JButton loginBtn = new JButton("Login");
    private JButton registerBtn = new JButton("Register");
    // Panels for organizing UI components
    private JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel applyNowPanel = new JPanel();
    private JPanel giveUpChildPanel = new JPanel();

    // String to store user type
    private String userType;

    public App() {
        setTitle("Kulaabhooshanam");
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        buttonsPanel.setOpaque(false);

        // Create the content panel with BorderLayout
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setPreferredSize(new Dimension(900, 800));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Background image panel
        JPanel backgroundPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load and draw the background image
                Image image = Toolkit.getDefaultToolkit().getImage("images/children2.jpg");
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setPreferredSize(new Dimension(780, 600));

        // Welcome text
        JLabel welcomeLabel = new JLabel("Welcome to Kulaabhooshanam!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 36));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel welcomePanel = new JPanel();
        welcomePanel.setOpaque(false);
        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);
        backgroundPanel.add(welcomePanel, BorderLayout.CENTER);

        // Add the background panel to the content panel
        contentPanel.add(backgroundPanel, BorderLayout.NORTH);

        // Cards panel
        JPanel cardPanel = new JPanel(new GridLayout(0, 2, 20, 0));
        JPanel card1 = createCardPanel("Who we help?", "Many babies are left at public spaces, and our volunteers bring us babies found abandoned. Many of the infants who survive are very fragile and/or premature and require hospitalization and intensive care. Our adoption process finds loving families for those unwanted and we’re with them every step of the way ensuring a safe and smooth transition to their new home.");
        JPanel card2 = createCardPanel("How can you help?", "Help us to ensure no baby is left abandoned and unloved. Volunteer your time and skills to support our programs and events. Your involvement can help create positive experiences for children and families. Help us raise awareness about the importance of adoption. Share our stories, events, and resources with your friends and community.");
        cardPanel.add(card1);
        cardPanel.add(card2);
        cardPanel.setOpaque(false);
        contentPanel.add(cardPanel, BorderLayout.CENTER);
        cardPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        cardPanel.setPreferredSize(new Dimension(780, 100));

        // Green Stats Panel
        JPanel statsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        statsPanel.setBackground(new Color(0, 128, 0, 191));
        statsPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        JLabel statsLabel = new JLabel("21,000 children are now part of permanent families!");
        statsLabel.setFont(new Font("Arial", Font.BOLD, 18));
        statsLabel.setForeground(Color.WHITE);
        statsPanel.add(statsLabel);
        statsPanel.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createEmptyBorder(10, 20, 10, 20),
        BorderFactory.createBevelBorder(10)));
        backgroundPanel.add(statsPanel, BorderLayout.SOUTH);

        // Create a JScrollPane and add the content panel to it
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        // Add the scroll pane to the frame
        add(scrollPane);

        // Apply Now button
        applyNowButton.setFont(new Font("Arial", Font.BOLD, 18));
        applyNowButton.setBackground(new Color(4, 170, 109));
        applyNowButton.setForeground(Color.WHITE);
        applyNowButton.setBorderPainted(false);
        applyNowButton.setFocusPainted(false);

        applyNowPanel.setOpaque(false);
        applyNowPanel.add(applyNowButton);

        // Action listener for login button
        loginBtn.setForeground(Color.BLUE);
        loginBtn.setBorderPainted(false);
        loginBtn.setFocusPainted(false);
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loggedInUser != null || loggedInAgency != null) {
                    // Logout user
                    loggedInUser = null;
                    loggedInAgency = null;
                    updateButtonState();
                } else {
                    // Open login form
                    loginType = true;
                    UserTypeView uT = new UserTypeView(null, loginType, App.this);
                    uT.setVisible(true);
                }
            }
        });

        // Action listener for register button
        registerBtn.setForeground(Color.BLUE);
        registerBtn.setBorderPainted(false);
        registerBtn.setFocusPainted(false);
        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginType = false;
                UserTypeView uT = new UserTypeView(null, loginType, App.this);
                uT.setVisible(true);
            }
        });

        // Action listener for apply now button
        applyNowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loggedInUser != null || loggedInAgency != null) {
                    ApplicationView view = new ApplicationView(null, new ApplicationModel());
                    view.setVisible(true);
                } else {
                    LoginModel model = new LoginModel();
                    LoginView view = new LoginView(null, model, App.this);
                    view.setVisible(true);
                }
            }
        });

        // Action listener for profile button
        profileButton.setFont(new Font("Arial", Font.PLAIN, 16));
        profileButton.setForeground(Color.BLUE);
        profileButton.setBorderPainted(false);
        profileButton.setFocusPainted(false);
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Profile profile = new Profile(null);
                profile.setVisible(true);
            }
        });

        // Action listener for addchild button
        addchildButton.setFont(new Font("Arial", Font.BOLD, 18));
        addchildButton.setBackground(new Color(4, 170, 109));
        addchildButton.setForeground(Color.WHITE);
        addchildButton.setBorderPainted(false);
        addchildButton.setFocusPainted(false);
        applyNowPanel.setOpaque(false);
        addchildButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AddChildModel model = new AddChildModel("jdbc:mysql://localhost:3306/kulaabhooshanam", "root", "w1o2rk");
                    AddChildView ac = new AddChildView(model);
                    ac.setVisible(true);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });

        // Action listener for update child button
        updateChildButton.setFont(new Font("Arial", Font.BOLD, 18));
        updateChildButton.setBackground(new Color(4, 170, 109));
        updateChildButton.setForeground(Color.WHITE);
        updateChildButton.setBorderPainted(false);
        updateChildButton.setFocusPainted(false);
        applyNowPanel.setOpaque(false);
        updateChildButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UpdateChildModel model = new UpdateChildModel("jdbc:mysql://localhost:3306/kulaabhooshanam", "root", "w1o2rk");
                    UpdateChildView ac = new UpdateChildView(model);
                    ac.setVisible(true);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        // Add give up child button
        JButton giveUpChildButton = new JButton("Want to give up a child for adoption?");
        giveUpChildButton.setFont(new Font("Arial", Font.PLAIN, 16));
        giveUpChildButton.setForeground(Color.BLUE);
        giveUpChildButton.setBorderPainted(false);
        giveUpChildButton.setFocusPainted(false);
        giveUpChildButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    AddChildModel model = new AddChildModel("jdbc:mysql://localhost:3306/kulaabhooshanam", "root", "w1o2rk");
                    AddChildView ac = new AddChildView(model);
                    ac.setVisible(true);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        giveUpChildPanel.setOpaque(false);
        giveUpChildPanel.add(giveUpChildButton);

        // Add buttons panel to content panel
        contentPanel.add(buttonsPanel, BorderLayout.SOUTH);

        // Initially update button state
        updateButtonState();
    }

    // Helper method to create a card panel with a title and content
    private JPanel createCardPanel(String title, String content) {
        JPanel cardPanel = new JPanel(new BorderLayout());
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel contentLabel = new JLabel("<html>" + content + "</html>");
        contentLabel.setVerticalAlignment(SwingConstants.TOP);
        contentLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        cardPanel.add(titleLabel, BorderLayout.NORTH);
        cardPanel.add(contentLabel, BorderLayout.CENTER);
        cardPanel.setOpaque(false);
        cardPanel.setPreferredSize(new Dimension(300, 300));
        return cardPanel;
    }

    // Method to set logged-in user
    public void setUser(User user) {
        loggedInUser = user;
        updateButtonState();
    }

    // Method to set logged-in agency
    public void setUser(Agency agency) {
        loggedInAgency = agency;
        updateButtonState();
    }

    // Method to set user type
    public void setType(String user) {
        userType = user;
        updateButtonState();
    }

    // Method to update button state based on user type and login state
    private void updateButtonState() {
        // Update Login Button state

        if (loggedInAgency != null || loggedInUser != null) {
            loginBtn.setText("Logout");
        } else {
            loginBtn.setText("Login");
        }

        // Clear all buttons from buttonsPanel
        buttonsPanel.removeAll();
        // Add login and give up child buttons
        buttonsPanel.add(loginBtn);
        // Add register button if user is not logged in
        if (loggedInUser == null && loggedInAgency == null) {
            buttonsPanel.add(registerBtn);
        }
        buttonsPanel.add(giveUpChildPanel);

        // Add other buttons based on user type
        if (loggedInUser != null) {
            if ("Prospective Adoptive Parent".equals(userType)) {
                buttonsPanel.add(profileButton);
                buttonsPanel.add(applyNowPanel);
            }
        } else if (loggedInAgency != null) {
            if ("Adoption Agency".equals(userType)) {
                buttonsPanel.add(addchildButton);
                buttonsPanel.add(updateChildButton);
            }
        }
        // Revalidate and repaint buttonsPanel
        buttonsPanel.revalidate();
        buttonsPanel.repaint();
    }

    // Method to close the home page
    public void closeHomePage() {
        dispose();
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Create and display the home page
                App app = new App();
                app.setVisible(true);
            }
        });
    }
}
