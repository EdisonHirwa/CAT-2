import java.awt.*;
import java.awt.event.*;

public class MyShapesSmiley extends Frame {

    // Constructor for the Frame
    public MyShapesSmiley() {
        super("My shapes"); // Set the window title

        // 1. Add the drawing component (Canvas)
        MySmileyCanvas canvas = new MySmileyCanvas();
        add(canvas, BorderLayout.CENTER);

        // 2. Set Frame properties
        setSize(400, 400); // Set an appropriate size for the window
        setVisible(true); // Make the window visible

        // 3. Handle window closing (the 'X' button functionality)
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    /**
     * Inner class that extends Canvas to perform the actual drawing.
     */
    class MySmileyCanvas extends Canvas {
        public MySmileyCanvas() {
            // Set a background color for the canvas
            setBackground(Color.WHITE); 
        }

        // The paint method is where all drawing logic goes.
        // It is called automatically by the AWT system.
        @Override
        public void paint(Graphics g) {
            // Define colors
            Color brownOutline = new Color(175, 96, 26); // A shade of brown/orange
            Color brownFeatures = new Color(139, 69, 19); // A darker brown

            // --- Draw the main square/window frame (as seen in the image) ---
            g.setColor(brownOutline);
            // Draw a rectangle for the border (with some padding)
            g.drawRect(20, 40, getWidth() - 40, getHeight() - 80); 

            // --- Draw the Smiley Face ---

            // 1. Head (Large Circle)
            // Coordinates and size are relative to the canvas size.
            int x = getWidth() / 2 - 100;
            int y = getHeight() / 2 - 100;
            int diameter = 200;
            
            g.setColor(brownOutline);
            g.drawOval(x, y, diameter, diameter);

            // 2. Eyes (Two small filled circles)
            int eyeDiameter = 20;
            g.setColor(brownFeatures);
            
            // Left Eye
            int leftEyeX = x + (int)(diameter * 0.3);
            int eyeY = y + (int)(diameter * 0.35);
            g.fillOval(leftEyeX, eyeY, eyeDiameter, eyeDiameter);

            // Right Eye
            int rightEyeX = x + (int)(diameter * 0.65) - eyeDiameter; 
            g.fillOval(rightEyeX, eyeY, eyeDiameter, eyeDiameter);

            // 3. Mouth (Arc)
            // g.drawArc(x, y, width, height, startAngle, arcAngle)
            g.setColor(brownOutline);
            int mouthWidth = (int)(diameter * 0.5);
            int mouthHeight = (int)(diameter * 0.3);
            int mouthX = x + (int)(diameter * 0.25);
            int mouthY = y + (int)(diameter * 0.65);
            
            // Draw a slightly curved, upward-facing arc for the smile
            // The negative extent makes it convex (smiling)
            g.drawArc(mouthX, mouthY, mouthWidth, mouthHeight, 0, -180); 
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        new MyShapesSmiley();
    }
}