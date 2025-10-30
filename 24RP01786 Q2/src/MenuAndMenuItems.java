import java.awt.*;
import java.awt.event.*;
class MenuAndMenuItems extends Frame implements ActionListener{
    MenuItem i5;
    public MenuAndMenuItems(){
        // Creating menu bar
        MenuBar mb = new MenuBar();
        // Creating menu component
        Menu container = new Menu("Menu");
        // Creating dropdown
        Menu subMenu = new Menu("Sub Menu");
        // Creating menu items
        MenuItem i1 = new MenuItem("Item 1");
        MenuItem i2 = new MenuItem("Item 2");
        MenuItem i3 = new MenuItem("Item 3");
        MenuItem i4 = new MenuItem("Item 4");
        i5 = new MenuItem("Exit");
        //Adding menu items to menu
        container.add(i1);
        container.add(i2);
        container.add(i3);
        // adding menu items to sub menu
        subMenu.add(i4);
        subMenu.add(i5);
        // adding sub menu to menu
        container.add(subMenu);
        // Adding menu to menu bar
        mb.add(container);
        // setting menu bar
        setMenuBar(mb);
        // setting layout
        setLayout(null);
        // Setting size
        setSize(500,500);
        // setting visibility
        setVisible(true);
        i5.addActionListener(this);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Close the frame
                dispose();
                // exit
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == i5){
            // close the frame
            dispose();
            // close the app
            System.exit(0);
        }
    }
}
