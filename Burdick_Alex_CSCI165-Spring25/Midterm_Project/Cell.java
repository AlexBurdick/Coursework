import java.util.Enumeration;
import java.awt.Color;

public class Cell {
/* 
    // Enumeration to hold status for each cell
    private enum statusEnum { TREE( "green"),
                             BURNING("red"),
                             EMPTY("yellow"); // members of the enum
        // Fields
        private String color;

        // Constructor for enum Status
        private statusEnum(String color) {
            this.color = color;  }

        // Getter for color
        public String getColor() {  
            return color;  }
    } // end enum
    
*/    

    //========================
    // VARIABLES
    //========================
    private static final double probCatch = 0.15; // Probability that a cell will catch fire
    
    // Variables to hold state of the cell and color in array parallel to enum
    public static enum STATES       {TREE, BURNING, EMPTY};
    private static Color[] colors = {Color.GREEN, Color.RED, Color.YELLOW};
    private boolean burnedOut     = false; // flag to keep cells from turning yellow on the first pass through
    
    // Declare instances of variables for methods
    private STATES State; // Instance of enum needed for constructor
    private Color color;


    //========================
    // CONSTRUCTORS
    //========================
    
    // Default Contructor for Cell, defaults to tree (green)
    Cell()
    {   
        this.State = State.TREE;
        this.color = colors[State.ordinal()];
    }

    public void burningCell(STATES S)
    {
        this.State = S;
        this.color = colors[State.ordinal()];
    }

    public void emptyCell(STATES S)
    {
        this.State = S;
        this.color = colors[State.ordinal()];
    }


    //========================
    // GETTERS and SETTERS
    //========================

    // State getter
    public STATES getState() {
        return this.State;
    }
    // State setter
    public void setState(STATES s) {
        this.State = s;
        this.color = colors[s.ordinal()];
    }

    // probCatch getter
    public double getProbCatch() {
        return probCatch;
    }
    
    // Color for getter
    public Color getColor() {  
        return this.color;
    }

    // burnedOut getter
    public boolean isBurnedOut() { // created by source action in VS
        return this.burnedOut;
    }
    
    // burnedOut setter
    public void setBurnedOut(boolean isBurned) { // created by source action in VS
        this.burnedOut = isBurned;
    }    

} // end class