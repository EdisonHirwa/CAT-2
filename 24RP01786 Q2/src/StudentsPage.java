import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StudentsPage extends Frame implements ActionListener {
    MenuItem login;
    public StudentsPage(String username){
        // check emptiness
        username = username.isEmpty() ? "Dear Student": username;
        // setting menu bar
        MenuBar mb = new MenuBar();
        // setting menus
        Menu pagesMenu = new Menu("Pages");
        Menu editMenu = new Menu("Edit");
        Menu helpMenu = new Menu("Help");
        // setting front size
        mb.setFont(new Font("Ariel",Font.BOLD,14));
        // adding items
        login = new MenuItem("Login");
        MenuItem student = new MenuItem("Student");
        // add menu items to menu
        pagesMenu.add(login);
        pagesMenu.add(student);
        // adding pages menus to menu bar
        mb.add(pagesMenu);
        mb.add(editMenu);
        mb.add(helpMenu);
        // adding menu bar to Frame
        setMenuBar(mb);
        // set layout
        setLayout(new BorderLayout(20,0));
        // Creating panels
        Panel header = new Panel();
        Panel mainPanel = new Panel();
        Panel leftPanel = new Panel();
        Panel rightPanel = new Panel();
        Panel footerPanel = new Panel();
        // creating hear text
        Label lblHeader = new Label("EXAMPLE JAVA AWT LAYOUT");
        Label mainHeader = new Label("EDISON HIRWA ,24RP01786 " );
        // Buttons
        // set font
        lblHeader.setFont(new Font("Arial", Font.BOLD,25));
        mainHeader.setFont(new Font("Arial", Font.BOLD,20));
        // setting colors
        header.setBackground(new Color(333));
        lblHeader.setForeground(new Color(0xFFFFFF));
        mainPanel.setBackground(new Color(0xFFFFFF));
        leftPanel.setBackground(Color.cyan);
        rightPanel.setBackground(Color.cyan);
        footerPanel.setBackground(Color.darkGray);
        // adding label to header panel
        header.add(lblHeader);
        // setting bounds
        header.setBounds(0,0,100,40);
        mainPanel.setBounds(10,10,100,40);
        leftPanel.setBounds(10,10,100,40);
        rightPanel.setBounds(10,10,100,40);
        footerPanel.setBounds(10,10,100,10);
        lblHeader.setBounds(120,0,600,40);
        mainHeader.setBounds(60,40,300,30);
        //setting layout for main
        mainPanel.setLayout(null);
        header.setLayout(null);
        leftPanel.setLayout(null);
        rightPanel.setLayout(null);
        footerPanel.setLayout(null);
        // add components to mainPanel section
        mainPanel.add(mainHeader);
        // add header to frame
        add(header, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.LINE_END);
        add(rightPanel, BorderLayout.LINE_START);
        add(footerPanel, BorderLayout.SOUTH);
        // setting frame title
        setTitle("AWT MENU Practice");
        // setting Frame size
        setSize(600,500);

        // set visibility
        setVisible(true);

        // Enabling minimize
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // close the frame
                dispose();
                // exit the program
                System.exit(0);
            }
        });
        // setting action listerners
        login.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login){
            // close the current Frame
            dispose();
            // Get to login
            new MenuPractice();
        }
    }
}
