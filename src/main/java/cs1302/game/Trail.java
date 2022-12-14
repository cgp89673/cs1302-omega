package cs1302.game;

import javafx.scene.shape.Rectangle;
import java.util.LinkedList;
import java.util.List;

/**
 * Constructs trail object.
 */
public class Trail {

    private List<Rectangle> trail = new LinkedList<>();
    private int length = 5;

     /**
      * Returns newest rectangle.
      * @param rectangle rectangle
      * @return newest rectangle in trail
      */
    public Rectangle addNewest(Rectangle rectangle) {
        trail.add(rectangle);
        if (trail.size() > length) {
            return trail.remove(0);
        } else {
            return null;
        }
    }

     /**
      * Detects a collision with itself.
      * @param x position in x direction
      * @param y position in y direction
      * @return result
      */
    public boolean isCollision(double x, double y) {
        boolean result = false;
        for (Rectangle rectangle : trail) {
            if (rectangle.contains(x, y)) {
                result = true;
            }
        }
        return result;
    }

     /**
      * Lengthens the trail.
      */
    public void lengthen() {
        length++;
    }
}
