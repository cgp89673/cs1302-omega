package cs1302.game;

import javafx.scene.shape.Circle;
import java.util.Random;

/**                                                                                      
 * A food object.                                                                          
 */
public class Food extends Circle {
    private Random rng;

    private int maxX;
    private int maxY;

    /**
     * Construct an {@code Food} object.
     */ 
    public Food(int maxX, int maxY) {
        super(20.0);
	    this.rng = new Random();
        this.maxX = maxX;
        this.maxY = maxY;
    } // IdleCat                                                                                                   

    /**
     * Update the position of the food.                           
     */
    public void randomizePos() {
        setCenterX(rng.nextDouble() * (maxX - 40) + 40);
        setCenterY(rng.nextDouble() * (maxY - 40) + 40);
    } // randomizePos

    /**
     * Construct an {@code IdleCat} object.
     * @param x position in x direction
     * @param y position in y direction
     * @return boolean result
     */
    public boolean isCollision(double x, double y) {
        boolean result = false;
        if (contains(x + 15, y + 15)) {
            result = true;
        }
        return result;
    }
} // IdleCat          
