import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

/**
 * CS 120: 
 * A simple popup window that display a set of insructions for this application
 * 
 *  *** Do NOT Edit this file ***
 * 
 * Last Modified: April 5, 2015
 * @author Josh Hursey
 *
 */
@SuppressWarnings( "serial" )
public class InstructionsWindow extends JDialog {
    private int WINDOW_HEIGHT = 300;
    private int WINDOW_WIDTH = 450;

    /**
     * Create a new popup window
     * 
     * @param contextWindow The Window that contains the popup
     */
    public InstructionsWindow( Window contextWindow ) {
        super( contextWindow.getJFrame() );
        
        /*
         * Setup the window
         */
        this.setTitle( "Instructions" );

        this.setResizable( false );
        this.setLocationRelativeTo(contextWindow.getJFrame());
        this.setVisible(true);
        this.setLocation(contextWindow.getWidth()/2 - WINDOW_WIDTH/2,
                         contextWindow.getHeight()/2 - WINDOW_HEIGHT/2);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setBackground(Color.WHITE);

        /*
         * Panel for the instructions
         */
        JPanel myPanel = new JPanel();
        myPanel.setLayout(null);
        this.getContentPane().add(myPanel);
        myPanel.setBackground( Color.WHITE );

        /*
         * A series of JLabels with the instructions
         */
        String instructions[] = new String[9];
        instructions[0] = "Etch-a-Sketch 2.0 Keyboard Commands:";
        instructions[1] = "   Arrow Keys = Move the pen up/down/left/right";
        instructions[2] = "   Spacebar   = Toggle pen up/down (default: pen down)";
        instructions[3] = "   X = Pick a random color";
        instructions[5] = "   R = Increase the Red by 5";
        instructions[6] = "   G = Increase the Green by 5";
        instructions[7] = "   B = Increase the Blue by 5";
        instructions[4] = "   K = Return pen color to Black";
        instructions[8] = "   C = Reset all tiles to White";
        
        int xPos, yPos, tall;
        xPos = 5;
        yPos = 5;
        tall = 20;
        for(int i = 0; i < instructions.length; ++i ) {
            if( instructions[i] != null ) {
                JLabel label = new JLabel( instructions[i] );
                label.setSize( this.getWidth() - xPos*2, tall );
                label.setLocation(xPos, yPos);
                label.setFont( new Font("monospaced", Font.PLAIN, 12) );
                myPanel.add( label );
                yPos += tall + 2;
            }
        }

        this.repaint();
    }

}
