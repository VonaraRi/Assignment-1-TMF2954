/* This is the driver class for the encoder system
 * It initializes the main application window and hosts the assignmentPanel
 * Contributed by Rionnalyn
 */

import javax.swing.JFrame;

public class Assignment{
    public static void main(String[] args){
        //Create new window frame with a title and ensure the application exits when window is closed
        JFrame frame = new JFrame("TMF2964 Assignment 1 : ENCODER SYSTEM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        // Adding the custom panel containing the GUI components and logic
        assignmentPanel panel = new assignmentPanel();

        frame.getContentPane().add(panel); // Add the panel to the frame's content pane
        frame.pack(); // Adjust the window size
        frame.setVisible(true); // Make the window visivle to the user
        frame.setLocationRelativeTo(null); // Set the window location to center window on screen
    }
}