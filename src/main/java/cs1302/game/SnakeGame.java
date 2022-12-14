package cs1302.game;

import java.util.Random;
import java.util.logging.Level;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;


/**
 * An example of a simple game in JavaFX. The play can move the rectangle left/right
 * with the arrow keys or teleport the rectangle by clicking it!
 */
public class SnakeGame extends Game {

    private Random rng;       // random number generator
    private Rectangle player; // some rectangle to represent the player
    private Trail trail;
    private int playerDelay = 0;
    private Direction playerDirection = Direction.RIGHT;
    private Food food;
    public static int count;
    private Label score;

    /**
     * enum for direction.
     */
    private enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }

    /**
     * Construct a {@code DemoGame} object.
     * @param width scene width
     * @param height scene height
     * @param score the score
     */
    public SnakeGame(int width, int height, Label score) {
        super(width, height, 60);        // call parent constructor
        setStyle("-fx-background-color: #FFE4E1");
        setLogLevel(Level.INFO);             // enable logging
        this.rng = new Random();             // random number generator
        this.player = new Rectangle(30, 30); // some rectangle to represent the player
        this.trail = new Trail();
        this.food = new Food(width, height);
        this.count = 0;
        this.score = score;
    } // DemoGame

    /** {@inheritDoc} */
    @Override
    protected void init() {
        // setup subgraph for this component
        getChildren().addAll(player, food);         // add to main container
        // setup player
        player.setX(300);                     // 50px in the x direction (right)
        player.setY(150);                     // 50ps in the y direction (down)
        food.setCenterX(rng.nextDouble() * getWidth());
        food.setCenterY(rng.nextDouble() * getHeight());
        food.setFill(Color.GREEN);
    } // init

    /** {@inheritDoc} */
    @Override
    protected void update() {
        isKeyPressed(KeyCode.LEFT, () -> playerDirection = Direction.LEFT);
        isKeyPressed(KeyCode.RIGHT, () -> playerDirection = Direction.RIGHT);
        isKeyPressed(KeyCode.UP, () -> playerDirection = Direction.UP);
        isKeyPressed(KeyCode.DOWN, () -> playerDirection = Direction.DOWN);
        playerDelay++;
        if (playerDelay % 10 == 0) {
            Rectangle currentLocation = new Rectangle(30, 30);
            currentLocation.setX(player.getX());
            currentLocation.setY(player.getY());
            currentLocation.setFill(Color.GRAY);
            Rectangle oldest = trail.addNewest(currentLocation);
            getChildren().addAll(currentLocation);
            if (oldest != null) {
                getChildren().remove(oldest);
            }
            switch (playerDirection) {
            case LEFT: player.setX(player.getX() - 30.0);
                break;
            case RIGHT: player.setX(player.getX() + 30.0);
                break;
            case UP: player.setY(player.getY() - 30.0);
                break;
            case DOWN: player.setY(player.getY() + 30.0);
                break;
            }

            if (trail.isCollision(player.getX(), player.getY()) || player.getX() == 0
                || player.getX() == 600 || player.getY() == 0 || player.getY() == 390) {
                logger.info("collision! You lost.");
                score.setText("You lost!");
                stop();
            }
            if (food.isCollision(player.getX(), player.getY())) { //playerDelay % 200 == 0
                trail.lengthen();
                food.randomizePos();
                count++;
                score.setText("Score: " + count);
            }
        }
    } // update
} // DemoGame
