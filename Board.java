import javax.swing.*;

//import java.awt.event.*;



public class Board /*implements ActionListener*/{


    final JFrame frame = new JFrame("FROG");
    static JPanel panel = new JPanel();
    static Square arrayofsqaures[][]= new Square[700][700];
    static String Icon="Water.png";

    public void board() {

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(712,735);
        frame.setResizable(false);
        panel.setLayout(null);
        

        for (int xPosition = 560; xPosition >= 0; xPosition= xPosition-140) {

            for (int yPosition = 0; yPosition < 700; yPosition= yPosition+140) {

                if ((xPosition==0 & yPosition==0)| (xPosition==280 & yPosition==0) | (xPosition==560 & yPosition==0)| (xPosition==0 & yPosition==280)| (xPosition==560 & yPosition==280)| (xPosition==140 & yPosition==420)| (xPosition==420 & yPosition==420)){
                    Icon= "LilyPad.png";
                }

                if ((xPosition==140 & yPosition==140)| (xPosition==420 & yPosition==140) | (xPosition==280 & yPosition==280)| (xPosition==0 & yPosition==560)| (xPosition==560 & yPosition==560)){
                    Icon= "GreenFrog.png";
                }

                if (xPosition==280 & yPosition==560){
                    Icon="RedFrog.png";
                }

                arrayofsqaures[xPosition][yPosition] = new Square(Icon, 0, 0, xPosition, yPosition);
                arrayofsqaures[xPosition][yPosition].CreateSquare(panel);

                Icon= "Water.png";

            }
        }
        frame.setVisible(true);
        
        //close button!
        /*
        JButton close = new JButton();
        close.setLocation(700, 540);
        close.setSize(140, 140);
        panel.add(close);

        close.addActionListener(this);

    
    public void actionPerformed(ActionEvent e) {
        System.exit(1);
    }
    */
    }
    public static void main(final String arg[]) {
        final Board board1 = new Board();
        board1.board();

    }





    
}