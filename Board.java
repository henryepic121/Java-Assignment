import javax.swing.*;



public class Board {


    final JFrame frame = new JFrame("FROG");
    final static JPanel panel = new JPanel();

	public void board() {

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        panel.setLayout(null);

        // row 1
        final Square square1 = new Square("LilyPad.png", 0, 0, 0, 0);
        square1.CreateSquare(panel);

        final Square square2 = new Square("Water.png", 0, 0, 140, 0);
        square2.CreateSquare(panel);

        final Square square3 = new Square("LilyPad.png", 0, 0, 280, 0);
        square3.CreateSquare(panel);

        final Square square4 = new Square("Water.png", 0, 0, 420, 0);
        square4.CreateSquare(panel);

        final Square square5 = new Square("LilyPad.png", 0, 0, 560, 0);
        square5.CreateSquare(panel);

        // row 2

        final Square square6 = new Square("Water.png", 0, 0, 0, 140);
        square6.CreateSquare(panel);

        final Square square7 = new Square("GreenFrog.png", 0, 0, 140, 140);
        square7.CreateSquare(panel);

        final Square square8 = new Square("Water.png", 0, 0, 280, 140);
        square8.CreateSquare(panel);

        final Square square9 = new Square("GreenFrog.png", 0, 0, 420, 140);
        square9.CreateSquare(panel);

        final Square square10 = new Square("Water.png", 0, 0, 560, 140);
        square10.CreateSquare(panel);

        // row 3

        final Square square11 = new Square("LilyPad.png", 0, 0, 0, 280);
        square11.CreateSquare(panel);

        final Square square12 = new Square("Water.png", 0, 0, 140, 280);
        square12.CreateSquare(panel);

        final Square square13 = new Square("GreenFrog.png", 0, 0, 280, 280);
        square13.CreateSquare(panel);

        final Square square14 = new Square("Water.png", 0, 0, 420, 280);
        square14.CreateSquare(panel);

        final Square square15 = new Square("LilyPad.png", 0, 0, 560, 280);
        square15.CreateSquare(panel);

        // row 4

        final Square square16 = new Square("Water.png", 0, 0, 0, 420);
        square16.CreateSquare(panel);

        final Square square17 = new Square("LilyPad.png", 0, 0, 140, 420);
        square17.CreateSquare(panel);

        final Square square18 = new Square("Water.png", 0, 0, 280, 420);
        square18.CreateSquare(panel);

        final Square square19 = new Square("LilyPad.png", 0, 0, 420, 420);
        square19.CreateSquare(panel);

        final Square square20 = new Square("Water.png", 0, 0, 560, 420);
        square20.CreateSquare(panel);

        // row 5

        final Square square21 = new Square("GreenFrog.png", 0, 0, 0, 560);
        square21.CreateSquare(panel);

        final Square square22 = new Square("Water.png", 0, 0, 140, 560);
        square22.CreateSquare(panel);

        final Square square23 = new Square("RedFrog.png", 0, 0, 280, 560);
        square23.CreateSquare(panel);

        final Square square24 = new Square("Water.png", 0, 0, 420, 560);
        square24.CreateSquare(panel);

        final Square square25 = new Square("GreenFrog.png", 0, 0, 560, 560);
        square25.CreateSquare(panel);
    }

    // public <ActionEvent> void actionPerformed(final ActionEvent event) {
    
        
    

    public static void main(final String arg[]) {
        final Board board1 = new Board();
        board1.board();

    }



    
}