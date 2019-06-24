package org.academiadecodigo.codezillas.flappy_bird.GameObject.PointCounter;

import org.academiadecodigo.simplegraphics.graphics.Text;

public class ObstacleCounter {

    private static Text text = new Text(90, 30, "SCORE: 0");
    private static int counter = 0;

    public static void growSize() {
        text.grow(80, 30);
    }

    public static void addCounter() {
        counter++;
    }

    public static void showCounter() {

        text.draw();

        text.setText("SCORE: " + counter);



    }
}
