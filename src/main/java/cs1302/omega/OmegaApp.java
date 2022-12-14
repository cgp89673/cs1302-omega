package cs1302.omega;

import cs1302.game.SnakeGame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.Stage;


/**
 * Basic snake game.
 */
public class OmegaApp extends Application {

    /**
     * Constructs an {@code OmegaApp} object. This default (i.e., no argument)
     * constructor is executed in Step 2 of the JavaFX Application Life-Cycle.
     */
    public OmegaApp() {}

    /** {@inheritDoc} */
    @Override
    public void start(Stage stage) {

        // demonstrate how to load local asset using "file:resources/"
        Image bannerImage = new Image("file:resources/snake2.jpg");
        ImageView banner = new ImageView(bannerImage);
        banner.setPreserveRatio(true);
        banner.setFitWidth(640);

        //some labels to display information
        Label score = new Label("Score: " );
        score.setText("Score: " + SnakeGame.count);
        //Label instructions = new Label("Use left, right, up and down arrow keys to try to collect the food.");

        // demo game provided with the starter code (640, 240)
        SnakeGame game = new SnakeGame(630, 420, score);

        // setup scene
        VBox root = new VBox(banner, game, score);
        Scene scene = new Scene(root);

        // setup stage
        stage.setTitle("Snake Game");
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> Platform.exit());
        stage.sizeToScene();
        stage.show();
        // play the game
        game.play();
    } // start

} // OmegaApp
