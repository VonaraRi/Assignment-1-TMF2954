import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class assignmentPanel extends JPanel {
    private JLabel promptLabel, charCountLabel, finalShiftLabel, resultLabel; 
    private JTextField inputField;
    private JButton encodeButton;

    public assignmentPanel(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.white);
        setPreferredSize(new Dimension(500, 300));
        
        promptLabel = new JLabel("Enter your input (lowercase & (1-10): ");
        inputField = new JTextField(20);

        //encode Button
        encodeButton = new JButton("Encode");

        charCountLabel = new JLabel("Non space character: 0");
        finalShiftLabel = new JLabel("Final shift: 0");
        resultLabel = new JLabel("Output: ");

        add(promptLabel);
        add(inputField);
        add(encodeButton);
        add(charCountLabel);
        add(finalShiftLabel);
        add(resultLabel);

        //THE TRIGGER, clicking the button
        encodeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String text = inputField.getText();

                //member 2
                Encoded encoder = new Encoded(text);

                //member 3
                if(!encoder.checkStringValidity(text)){
                    JOptionPane.showMessageDialog(null, "Error: Use lowercase/(1- 10 digits) only");
                    return;
                }

                //get data form other methods
                int count = encoder.countCharacters(text);
                int groupShift = encoder.generateShift();
                int finalShift = groupShift + count;
                
                //member 4
                String result = encoder.applyCipher(text, finalShift);

                //final GUI
                charCountLabel.setText("Non-space character: " + count);
                finalShiftLabel.setText("Final shift: " + finalShift);
                resultLabel.setText("Output: " + result);

                JOptionPane.showMessageDialog(null, "Encoding completed successfully");
            }
        });
    }
    
}
