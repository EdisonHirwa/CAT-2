import java.awt.*;
import java.awt.event.*;

public class AWTPractice extends Frame implements ActionListener {

    // Components
    TextField txtUsername, txtPassword;
    Button bLogin;

    // Constructor
    public AWTPractice() {
        // Frame setup
        setTitle("Login Page");
        setSize(600, 450);
        setLayout(new BorderLayout());
        setVisible(true);

        // Panels
        Panel header = new Panel();
        Panel mainPanel = new Panel();
        Panel leftPanel = new Panel();
        Panel rightPanel = new Panel();
        Panel footerPanel = new Panel();

        // Labels
        Label lbHeader = new Label("SIMPLE JAVA AWT LAYOUT", Label.CENTER);
        Label lbUsername = new Label("Username:");
        Label lbPassword = new Label("Password:");

        // Text fields
        txtUsername = new TextField();
        txtPassword = new TextField();
        txtPassword.setEchoChar('*'); // hide password input

        // Button
        bLogin = new Button("Login");
        bLogin.addActionListener(this); // register event listener

        // Set colors
        header.setBackground(Color.BLUE);
        mainPanel.setBackground(Color.WHITE);
        leftPanel.setBackground(Color.LIGHT_GRAY);
        rightPanel.setBackground(Color.LIGHT_GRAY);
        footerPanel.setBackground(Color.DARK_GRAY);

        // Layouts
        header.setLayout(null);
        mainPanel.setLayout(null);
        leftPanel.setLayout(null);
        rightPanel.setLayout(null);
        footerPanel.setLayout(null);

        // ====== COMPONENT SIZES AND POSITIONS ======
        header.setPreferredSize(new Dimension(100, 60));
        footerPanel.setPreferredSize(new Dimension(100, 40));
        leftPanel.setPreferredSize(new Dimension(100, 100));
        rightPanel.setPreferredSize(new Dimension(100, 100));

        lbHeader.setBounds(180, 20, 250, 25);
        lbHeader.setFont(new Font("Arial", Font.BOLD, 18));
        lbUsername.setBounds(100, 90, 80, 25);
        lbPassword.setBounds(100, 140, 80, 25);
        txtUsername.setBounds(220, 90, 150, 30);
        txtPassword.setBounds(220, 140, 150, 30);
        bLogin.setBounds(220, 210, 150, 35);

        // Add components to panels
        header.add(lbHeader);
        mainPanel.add(lbUsername);
        mainPanel.add(txtUsername);
        mainPanel.add(lbPassword);
        mainPanel.add(txtPassword);
        mainPanel.add(bLogin);

        // Add panels to frame
        add(header, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
        add(footerPanel, BorderLayout.SOUTH);

        // Close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // Button click handler
    public void actionPerformed(ActionEvent e) {
        String username = txtUsername.getText().trim();
        String password = txtPassword.getText().trim();

        // Predefined credentials
        String correctUsername = "Edison";
        String correctPassword = "1234";

        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            // Show success dialog
            showMessageDialog("Welcome " + username + "!", "Login Successful", true);
        } else {
            // Show warning dialog
            showMessageDialog("Incorrect username or password. Please try again.", "Login Failed", false);
        }
    }

    // Custom message dialog method
    private void showMessageDialog(String message, String title, boolean success) {
        Dialog dialog = new Dialog(this, title, true);
        dialog.setLayout(new FlowLayout());
        Label label = new Label(message);
        Button ok = new Button("OK");

        if (success) {
            dialog.setBackground(Color.GREEN);
        } else {
            dialog.setBackground(Color.PINK);
        }

        ok.addActionListener(ae -> dialog.setVisible(false));
        dialog.add(label);
        dialog.add(ok);
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    // Main method
    public static void main(String[] args) {
        new AWTPractice();
    }
}
