/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /* 
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
 		// If n=0, draw the line and stop.
        if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        }
        
        // Calculate distance between the two points
        double distX = x2 - x1;
        double distY = y2 - y1;

        // Calculate the point at the 1/3 mark
        double x_third = x1 + distX / 3;
        double y_third = y1 + distY / 3;

        // Calculate the point at the 2/3 mark
        double x_two_thirds = x1 + (distX * 2) / 3;
        double y_two_thirds = y1 + (distY * 2) / 3;

        // Calculate the peak
        double x_peak = (Math.sqrt(3) / 6) * (y1 - y2) + (x1 + x2) / 2;
        double y_peak = (Math.sqrt(3) / 6) * (x2 - x1) + (y1 + y2) / 2;

    	// Start to 1/3
        curve(n - 1, x1, y1, x_third, y_third);
        
        // 1/3 to Peak 
        curve(n - 1, x_third, y_third, x_peak, y_peak);
        
        // Peak to 2/3 
        curve(n - 1, x_peak, y_peak, x_two_thirds, y_two_thirds);
        
        // 2/3 to End
        curve(n - 1, x_two_thirds, y_two_thirds, x2, y2);
		}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
        StdDraw.setYscale(0, 1.1);
        StdDraw.setXscale(0, 1.1);

        // Draws a Koch snowflake of depth n
        double x1 = 0.200, y1 = 0.750; // Top Left
        double x2 = 0.800, y2 = 0.750; // Top Right
        double height = (Math.sqrt(3) / 2) * 0.6;
        double x3 = 0.500, y3 = 0.750 - height; // Bottom Tip

        curve(n, x1, y1, x2, y2);
        curve(n, x2, y2, x3, y3);
        curve(n, x3, y3, x1, y1);
	}
}
