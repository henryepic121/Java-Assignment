import javax.swing.*;
import java.awt.event.*;

public class Square implements ActionListener {

    private final int xPosition;
    private final int yPosition;
    private static final int Length = 140;
    private static final int Width = 140;
    private String SquareIcon;

    Boolean isclicked = false; // not used

    private static int clickcount;
    private static String click1peice;

    JButton square = new JButton();
    JButton square2 = new JButton();

    private static JButton click1square;

    private static int click1xPosition;
    private static int click1yPosition;

    public Square(String image, int Width, int Length, int x, int y) {

        xPosition = x;
        yPosition = y;
        SquareIcon = image;

        // potentually useful functions:
        // int xPosition = SQUARE.getLocation().x;
        // int yPosition = SQUARE.getLocation().y;
        // SQUARE.setLocation(x,y);
    }

    void CreateSquare(final JPanel panel) {

        final ImageIcon Image = new ImageIcon(SquareIcon);
        square.setIcon(Image);

        square.setLocation(xPosition, yPosition);
        square.setSize(Width, Length);
        panel.add(square);

        square.addActionListener(this);

    }

    public void actionPerformed(final ActionEvent event) {
        
        System.out.print("You clicked a square at" + xPosition + yPosition);
        // System.out.print("The image on that square is" + SquareIcon);

        System.out.print("\n\n\n\n\n\n");

        int middleX = 0;
        int middleY = 0;


        clickcount = clickcount + 1;

        if (clickcount == 1) {

            click1square = square;
            click1xPosition = xPosition;
            click1yPosition = yPosition;

        }

        if (SquareIcon == ("LilyPad.png") & (clickcount == 1)) {

            click1peice = "LilyPad.png";
            clickcount = 0;

        }

        if (SquareIcon == ("GreenFrog.png") & (clickcount == 1)) {
            final ImageIcon Image = new ImageIcon("GreenFrog2.png");
            square.setIcon(Image);

            click1peice = "GreenFrog.png";

        }

        if (SquareIcon == ("RedFrog.png") & (clickcount == 1)) {
            final ImageIcon Image = new ImageIcon("RedFrog2.png");
            square.setIcon(Image);

            click1peice = "RedFrog.png";

        }

        //// deselect

        //// new

        if ((SquareIcon == ("GreenFrog.png") & (click1peice == ("GreenFrog.png")) & (clickcount == 2))) {

            final ImageIcon Image = new ImageIcon("GreenFrog.png");
            click1square.setIcon(Image);

            clickcount = 0;

        }

        if ((SquareIcon == ("RedFrog.png") & (click1peice == ("RedFrog.png")) & (clickcount == 2))) {

            final ImageIcon Image = new ImageIcon("RedFrog.png");
            click1square.setIcon(Image);

            clickcount = 0;
        }

        ////

        if ((SquareIcon == ("RedFrog.png") | (SquareIcon == ("Water.png")))& ((click1peice == ("GreenFrog.png")) & (clickcount == 2))) {

            final ImageIcon Image = new ImageIcon("GreenFrog.png");
            click1square.setIcon(Image);

            clickcount = 0;

        }

        if ((SquareIcon == ("GreenFrog.png") | (SquareIcon == ("Water.png")))& ((click1peice == ("RedFrog.png")) & (clickcount == 2))) {

            final ImageIcon Image = new ImageIcon("RedFrog.png");
            click1square.setIcon(Image);

            clickcount = 0;

        }

        if (SquareIcon == ("Water.png")) {
            clickcount = 0;

        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.print("\n" + click1peice);
        System.out.print("\n" + clickcount);
        System.out.print("\n" + SquareIcon);

        if ((clickcount == 2) & (SquareIcon == ("LilyPad.png"))& ((click1peice == ("GreenFrog.png")) | (click1peice == ("RedFrog.png")))) {

            clickcount = 0;

            // ENSUREING LEGAL MOVES!!!!!

            middleX = ((xPosition + click1xPosition) / 2);
            middleY = ((yPosition + click1yPosition) / 2);

            System.out.print("\n" + middleX);
            System.out.print("\n" + middleY);

            if ((middleX % 140 == 0) & (middleY % 140 == 0)) {

                if ((Board.arrayofsqaures[middleX][middleY].GetSquareIcon() == "GreenFrog.png") | (Board.arrayofsqaures[middleX][middleY].GetSquareIcon() == "RedFrog.png")) {

                    //remove frog that was jumped over!
                    Board.arrayofsqaures[middleX][middleY].SquareIcon="LilyPad.png";
                    
                    final ImageIcon LilyPad = new ImageIcon("LilyPad.png");
                    Board.arrayofsqaures[middleX][middleY].square.setIcon(LilyPad);
                    
                    //call move to
                    moveTo(click1peice, 0, 0, xPosition, yPosition, Board.panel, square, click1square);
                
                }
                //deselect
                else{
                    if (click1peice == ("GreenFrog.png")){
                        final ImageIcon Image = new ImageIcon("GreenFrog.png");
                        click1square.setIcon(Image);
                    }
                    if (click1peice == ("RedFrog.png")){
                        final ImageIcon Image = new ImageIcon("RedFrog.png");
                        click1square.setIcon(Image);
                    }
                }
            }
            else{
                    if (click1peice == ("GreenFrog.png")){
                        final ImageIcon Image = new ImageIcon("GreenFrog.png");
                        click1square.setIcon(Image);
                    }
                    if (click1peice == ("RedFrog.png")){
                        final ImageIcon Image = new ImageIcon("RedFrog.png");
                        click1square.setIcon(Image);
                    }
                }
                
            }
            

            

        
    }

    // invoked on second click
    void moveTo(String click1peice, final int Width, final int Length, final int xPosition, final int yPosition,final JPanel panel, final JButton square, final JButton click1square) {

        // System.out.print(xPosition);
        // System.out.print(yPosition);
        System.out.print("HI");

        // set first clicked square(frog) to lilypad icon

        final ImageIcon LilyPad = new ImageIcon("LilyPad.png");
        click1square.setIcon(LilyPad);

        Board.arrayofsqaures[click1xPosition][click1yPosition].SquareIcon = "LilyPad.png"; 
        

        // set second clicked square(lilypad) to frog icon

        final ImageIcon Image = new ImageIcon(click1peice);
        square.setIcon(Image);

        SquareIcon = click1peice;

        click1peice = "LilyPad.png";



        //checking if the user has won!
        int GreenFrogcount=0;
        int RedFrogcount=0;

        for (int x = 560; x >= 0; x= x-140) {

            for (int y = 0; y < 700; y= y+140) {

                if (Board.arrayofsqaures[x][y].SquareIcon == "GreenFrog.png"){
                    GreenFrogcount =GreenFrogcount+1;
                }
                if (Board.arrayofsqaures[x][y].SquareIcon == "RedFrog.png"){
                    RedFrogcount =RedFrogcount+1;
                }
            }
        }

        if ((GreenFrogcount ==0)&(RedFrogcount ==1)){
            
            final JFrame frame2 = new JFrame("WIN");
            JPanel panel2 = new JPanel();
            JTextField WIN = new JTextField("YOU WIN!");
            WIN.setEditable(false);
            frame2.add(panel2);
            frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            //frame2.pack();
            frame2.setSize(350,350);
            frame2.add(WIN);
            //frame2.pack();
            frame2.setResizable(false);
            frame2.setVisible(true);
            
        }
    }

    // accessor methods for square position on board
    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public String GetSquareIcon() {
        return SquareIcon;
    }

    public void setIsClicked(final Boolean bool) {
        isclicked = bool;
    }



}
