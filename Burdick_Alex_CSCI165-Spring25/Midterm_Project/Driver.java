import javax.swing.JFrame;	// My "top level" GUI container
import java.util.Scanner;

public class Driver
{    
    private JFrame window;	// JFrame to hold the JPanel
    
    public Driver(World grid)
    {									
		int width  = grid.getCols();
        int height = grid.getRows();

        window = new JFrame();                                      // JFrame instance
        window.setTitle("Fire Spread");	                            // Title bar text
        window.setSize(width * 11, height * 16);				    // size of window
		window.setLocationRelativeTo(null);							// put in center
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// how to close
		window.add(new Simple_Graphics(grid));				        // and the custom JPanel to the container
		window.setVisible(true);                                    // make visible
    }	
    
    public static void main(String[] args)
    {
        // Get size of the grid from command arguments
        int gridSize = Integer.parseInt(args[0]);
        
        World grid = new World(gridSize, gridSize);

        new Driver(grid);
    }
}