import javax.swing.JFrame;

public class Assignment{
    public static void main(String[] args){
        JFrame frame = new JFrame("TMF2964 Assignment 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //adding the custom panel
        assignmentPanel panel = new assignmentPanel();

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}