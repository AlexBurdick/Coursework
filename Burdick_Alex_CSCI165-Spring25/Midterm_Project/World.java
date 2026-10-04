public class World {

    //========================
    // VARIABLES
    //========================
    private Cell[][] cells; // Create a 2D array of Cell objects


    //========================
    // CONSTRUCTORS
    //========================
    
    // Default constructor for World
    public World() {
        this(100, 100); // call other constructor with default values
    }
    
    // Constructor for World accepting rows and columns for instantiation
    public World(int rows, int cols) {
        
        // Create a new instance of the 2d array
        this.cells = new Cell[rows][cols];
        
        // Loops to create the first pattern of the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Create a new instace of Cell
                cells[i][j] = new Cell();

                // Logic to create a grid with a border and burning cell in the center
                if ( i == 0 || i == rows-1 || j == 0 || j == cols-1 ) // set boundary cells to EMPTY
                    cells[i][j].setState(Cell.STATES.EMPTY);
                else if (i == rows/2 && j == cols/2)                  // set BURNING cell in the center
                    cells[i][j].setState(Cell.STATES.BURNING); 
                else                                                  // set all other cells to TREE
                    cells[i][j].setState(Cell.STATES.TREE);
            }
        }
    } // end constructor


    //========================
    // GETTERS & SETTERS
    //========================

    // Method to get the number of rows in the grid
    public int getRows() {
        return cells.length;
    }

    // Method to get the number of columns in the grid
    public int getCols() {
        return cells[0].length;
    }

    // Method to get the cell at a specific row and column
    public Cell getCell(int row, int col) {
        return cells[row][col];
    }


    //========================
    // METHODS
    //========================

    // Rewrite the world grid based on what's burning
    public void burnThrough() {
        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[i].length; j++) {
                
                double probcatch = this.cells[i][j].getProbCatch(); // Get probability that the cell will change to BURNING
                
                // Skip loop if cell is EMPTY 
                if (this.cells[i][j].getState() == Cell.STATES.EMPTY)
                    continue;

                // Set to EMPTY if cell is BURNING
                if (this.cells[i][j].getState().equals(Cell.STATES.BURNING)) {
                    if (this.cells[i][j].isBurnedOut() == true) {
                        this.cells[i][j].setState(Cell.STATES.EMPTY);
                        continue;
                    }
                    else {
                        this.cells[i][j].setBurnedOut(true);
                    }
                }

                // If statements to determine if a TREE cell should switch to BURNING
                // Check NW
                if (this.cells[i-1][j-1].getState().equals(Cell.STATES.BURNING)) {
                    if (Math.random() <= probcatch) {
                        this.cells[i][j].setState(Cell.STATES.BURNING);
                    }
                }
                // Check N
                if (this.cells[i-1][j].getState().equals(Cell.STATES.BURNING)) {
                    if (Math.random() <= probcatch) {
                        this.cells[i][j].setState(Cell.STATES.BURNING);
                    }
                }
                // Check NE
                if (this.cells[i-1][j+1].getState().equals(Cell.STATES.BURNING)) {
                    if (Math.random() <= probcatch) {
                        this.cells[i][j].setState(Cell.STATES.BURNING);
                    }
                }
                // Check W
                if (this.cells[i][j-1].getState().equals(Cell.STATES.BURNING)) {
                    if (Math.random() <= probcatch) {
                        this.cells[i][j].setState(Cell.STATES.BURNING);
                    }
                }
                // Check E
                if (this.cells[i][j+1].getState().equals(Cell.STATES.BURNING)) {
                    if (Math.random() <= probcatch) {
                        this.cells[i][j].setState(Cell.STATES.BURNING);
                    }
                }
                // Check SW
                if (this.cells[i+1][j-1].getState().equals(Cell.STATES.BURNING)) {
                    if (Math.random() <= probcatch) {
                        this.cells[i][j].setState(Cell.STATES.BURNING);
                    }
                }
                // Check S
                if (this.cells[i+1][j].getState().equals(Cell.STATES.BURNING)) {
                    if (Math.random() <= probcatch) {
                        this.cells[i][j].setState(Cell.STATES.BURNING);
                    }
                }
                // Check SE
                if (this.cells[i+1][j+1].getState().equals(Cell.STATES.BURNING)) {
                    if (Math.random() <= probcatch) {
                        this.cells[i][j].setState(Cell.STATES.BURNING);
                    }
                }
            } // end for loop j
        } // end for loop i
    } // end burnThrough

} // end class
