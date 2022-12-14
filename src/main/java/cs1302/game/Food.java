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
     * @param maxX the max value of x
     * @param maxY the max value of y
     */
    public Food(int maxX, int maxY) {
        super(20.0);
        rng = new Random();
        this.maxX = maxX;
        this.maxY = maxY;
    } // Food

    /**
     * Update the position of the food.
     */
    public void randomizePos() {
        setCenterX(rng.nextDouble() * (maxX - 40) + 50);
        setCenterY(rng.nextDouble() * (maxY - 40) + 50);
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
} // Food
