/* This class define the Graphical User Interface (GUI) for encoder system
 * It manages the input field, the trigger button, and the display of encoded result
 * Contributed by Rionnalyn 
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class assignmentPanel extends JPanel {
    // GUI Components
    private JLabel promptLabel, charCountLabel, finalShiftLabel, resultLabel; 
    private JTextField inputField;
    private JButton encodeButton;

    public assignmentPanel(){
        // Define custom colors for theme
        Color pColor = new Color(245, 245, 240); // Off-white background
        Color bColor = new Color(25, 35, 65); // Dark blue for button
        Color oColor = new Color(210, 160, 60); // Gold for output text

        // Set up the Panel Layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(pColor);
        setPreferredSize(new Dimension(500, 300));
               
        //--- 1. Input section ---
        promptLabel = new JLabel("Enter your input (lowercase & (0-9)): ");
        promptLabel.setFont(new Font("Arial", Font.BOLD, 18));
        promptLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        inputField = new JTextField(20);
        inputField.setMaximumSize(new Dimension(300, 45));
        inputField.setAlignmentX(Component.CENTER_ALIGNMENT);

        //--- 2. Encode Button ---
        encodeButton = new JButton("Encode");
        encodeButton.setBackground(bColor);
        encodeButton.setForeground(Color.WHITE);
        encodeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        encodeButton.setMargin(new Insets(10, 20, 10, 20));

        //--- 3. Output labels ---
        charCountLabel = new JLabel("Non space character: 0");
        finalShiftLabel = new JLabel("Final shift: 0");
        resultLabel = new JLabel("Output: ");

        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultLabel.setForeground(oColor);
        charCountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        finalShiftLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //--- 4. Assemble the Panel ---
        // Using Struts and Glue to manage spacing and alignment
        add(Box.createVerticalStrut(20)); //top margin
        add(promptLabel);
        add(Box.createVerticalStrut(20)); //space between prompt and field
        add(inputField);
        add(Box.createVerticalStrut(15)); //space between field and button
        add(encodeButton);
        add(Box.createVerticalStrut(25)); //space before results
        add(charCountLabel);
        add(Box.createVerticalStrut(10));
        add(finalShiftLabel);
        add(Box.createVerticalStrut(15));
        add(resultLabel);
        add(Box.createVerticalGlue()); //push everything to top/center

        // --- 5. Event Handling ---
        //THE TRIGGER, clicking the button
        //Listener for the "Encode" button click
        encodeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                // Capture the text entered by the user
                String text = inputField.getText();

                //member 2, Rosfanida: Instantiate the Logic/Encoding class
                Encoded encoder = new Encoded(text);

                //member 3, Sabrina: Check Validation
                // Check if the string contains only lowercase and (0-9) digits
                if(!encoder.checkStringValidity(text)){
                    JOptionPane.showMessageDialog(null, "Error: Use lowercase/0-9 digits only");
                    return; // Stop execution if the input is invalid
                }

                // Logic phase: Process the data through Encoded class methods
                int count = encoder.countCharacters(text); // Count non-space chars
                int groupShift = encoder.generateShift(); // Get base shift/group shift value
                int finalShift = groupShift + count; // Calculate total shift
                
                //member 4, Chan Ka Hou: Apply the Cipher logic
                String result = encoder.applyCipher(text, finalShift);

                //Final GUI: Display the processed data back to the GUI labels
                charCountLabel.setText("Non-space character: " + count);
                finalShiftLabel.setText("Final shift: " + finalShift);
                resultLabel.setText("Output: " + result);

                // Display success confirmation message to user
                JOptionPane.showMessageDialog(null, "Encoding completed successfully");
            }
        });
    }
    
}
