package org.academiadecodigo.codezillas.flappy_bird.objects.score;

import org.academiadecodigo.codezillas.flappy_bird.GameConfig;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Score {

    private static int counter = 0;
    private static Text text = new Text(
            GameConfig.SCORE_INITIAL_X,
            GameConfig.SCORE_INITIAL_Y,
            GameConfig.SCORE_MESSAGE + counter
    );

    //TODO: Check if this is not throwing a NullPointerException
    static {
        text.grow(GameConfig.SCORE_X_RESIZE, GameConfig.SCORE_Y_RESIZE);
    }

    private Score() {
    }

    public static void increase() {
        counter++;
    }

    public static int getCounter () {
        return counter;
    }

    public static void restartCounter() {
        counter = 0;
    }

    public static void render() {
        text.setText(GameConfig.SCORE_MESSAGE + counter);
        text.draw();
    }
}
