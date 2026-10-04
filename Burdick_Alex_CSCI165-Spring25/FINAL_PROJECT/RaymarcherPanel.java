import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Displays and updates the logic for the raymarcher.
 */
public class RaymarcherPanel extends JPanel { 
	
	private final RaymarcherRunner raymarcherRunner; // reference to the parent app
	// Create a camera object to add to the panel
	Camera camera = new Camera(new Color(255, 255, 255), true, new Point(250,250));
	
	public RaymarcherPanel(RaymarcherRunner raymarcherRunner) {
		// Start listening for mouse events
		addMouseMotionListener(camera);
		addMouseListener(camera);

		this.raymarcherRunner = raymarcherRunner;
		this.setPreferredSize(new Dimension(this.raymarcherRunner.getFrame().getHeight(), 
				this.raymarcherRunner.getFrame().getHeight()));		
	}
	
	// All drawing code goes here
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, this.getWidth(),this.getHeight());

		ArrayList<Shape> shapes = createShapes();

		for (Shape s : shapes) {
			s.drawObject(g2d);
		}
		camera.drawObject(g2d); // draw the camera last so it is on top of the other shapes

		// Draw the raymarcher
		ArrayList<March> marches = createMarches(shapes, g2d);
		Ray r = new Ray(marches); // create a new ray object
		r.drawRay(g2d); // draw the ray object
	}

	/**
	 * Create an array list of shapes
	 * 
	 * @param shapes the list of shapes to create
	 * @return the list of shapes
	 */
	public ArrayList<Shape> createShapes() {
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(new Circle(new Color(0,0,255), true, new Point(500,100), 40));
		shapes.add(new Rectangle(new Color(0,255,0), true, new Point(100, 220), 75, 60));
		shapes.add(new Triangle(new Color(255,0,0), true, new Point(400,400), 60, 110));
		shapes.add(new Circle(new Color(0,0,255), true, new Point(150,600), 30));
		shapes.add(new Rectangle(new Color(0,255,0), true, new Point(500, 490), 25, 25));
		shapes.add(new Triangle(new Color(255,0,0), true, new Point(330,250), 80, 40));

		return shapes;
	}

	/**
	 * Find the smallest distance from the camera to any of the shapes
	 * 
	 * @param shapes the list of shapes to check
	 * @return the distance from the camera to the closest shape
	 */
	public double smallestDistance(ArrayList<Shape> shapes, Point p) {
		double minDistance = Double.MAX_VALUE;
		for (Shape s : shapes) {
			double distance = s.computeDistance(p);
			if (distance < minDistance) {
				minDistance = distance;
			}
		}
		return minDistance;
	}

	/**
	 * Create an array list of marches based on the shapes and the position of the camera
	 * 
	 * @param shapes the list of shapes test
	 * @return the list of marches
	 */
	public ArrayList<March> createMarches(ArrayList<Shape> shapes, Graphics2D g2d) {
		// Create a new array list of marches
		ArrayList<March> marches = new ArrayList<March>();

		// Get the first shortest distance and starting point (camera position)
		double radius = smallestDistance(shapes, camera.getPoint());
		Point p = camera.getPoint();

		// Create a total distance variable to keep track of the distance
		double totalDistance = 0;
		
		// Size of the panel to limit the continuation of the raymarch
		double width = this.getWidth();
		double height = this.getHeight();
		double size = Math.sqrt((width * width) + (height * height));
		
		// While loop that stops when the distance to the next Shape is too small
		// indicating a collision, or when the raymarcher is outside of the JPanel
		while (radius > 0.01 && totalDistance <= size) {
			// Create a new March object with the starting point and the radius
			March m = new March (p, radius, camera.marchAngle); // create a new march object
			marches.add(m); // add March to the list

			// Reset the start point and distance
			radius = smallestDistance(shapes, m.getEnd()); // get the next distance
			p = m.getEnd(); // start for the previous March's end

			totalDistance += radius; // add the distance to the total distance
		}
		
		return marches;
	}
}
