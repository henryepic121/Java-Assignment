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

    private int click1xPosition;
    private int click1yPosition;

    public Square(final String image, final int Width, final int Length, final int x, final int y) {

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
        // System.out.print("You clicked a square at" + xPosition + yPosition);
        // System.out.print("The image on that square is" + SquareIcon);

        System.out.print("\n\n\n\n\n\n");


        clickcount = clickcount + 1;

        click1xPosition = xPosition;
        click1yPosition = yPosition;

        if (clickcount == 1) {
            click1square = square;
            

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
            
        
            //////////////////////////////////////////////////////////////////////////////////////////////make neater
        // //deselect
        if (SquareIcon == ("GreenFrog.png") & (clickcount == 2) & (click1peice != ("RedFrog.png"))) {

            final ImageIcon Image = new ImageIcon("GreenFrog.png");
            click1square.setIcon(Image);
            clickcount = 0;

        }
        if ((SquareIcon == "RedFrog.png") & (clickcount == 2) & (click1peice != ("GreenFrog.png"))) {

            final ImageIcon Image = new ImageIcon("RedFrog.png");
            click1square.setIcon(Image);
            clickcount = 0;

        }
        //
        // red frog green frog 
        if ((SquareIcon == ("RedFrog.png") | (SquareIcon == ("Water.png"))) & ((click1peice == ("GreenFrog.png")) & (clickcount == 2))) {
            
            final ImageIcon Image = new ImageIcon("GreenFrog.png");
            click1square.setIcon(Image);
            
            //SquareIcon= "GreenFrog.png"; 
            
            clickcount = 0;

        }

        if ((SquareIcon == ("GreenFrog.png") | (SquareIcon == ("Water.png"))) & ((click1peice == ("RedFrog.png")) & (clickcount == 2))) {
            
            final ImageIcon Image = new ImageIcon("RedFrog.png");
            click1square.setIcon(Image);
            
            //SquareIcon= "RedFrog.png"; //
            
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
             

            moveTo(click1peice, 0, 0, xPosition, yPosition, Board.panel, square, click1square);

        }

        //{PROBLEM: SETTING PREVIOUS SQUARE ICON TO LILY PAD} :(((((((((((

        //incase Frog is moved, set that square as water doesnt work because when you click a frog then water the frog because a lilypad. Water.png


        if ((clickcount == 1) & ((click1peice == ("GreenFrog.png")) | (click1peice == ("RedFrog.png")))){
            SquareIcon = "LilyPad.png";
            
        }
    }

    // invoked on second click
    void moveTo(String click1peice, final int Width, final int Length, final int xPosition, final int yPosition,
            final JPanel panel, final JButton square, final JButton click1square) {

        // System.out.print(xPosition);
        // System.out.print(yPosition);
        System.out.print("HI");

        // set first clicked square(frog) to lilypad icon

        final ImageIcon LilyPad = new ImageIcon("LilyPad.png");
        click1square.setIcon(LilyPad);
        
        

        // set second clicked square(lilypad) to frog icon

        final ImageIcon Image = new ImageIcon(click1peice);
        square.setIcon(Image);

        SquareIcon = click1peice;

        click1peice = "LilyPad.png";

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
