package org.academiadecodigo.codezillas.flappy_bird;

import org.academiadecodigo.codezillas.flappy_bird.Bird.RunBird;
import org.academiadecodigo.codezillas.flappy_bird.Element.RunObstacle;
import org.academiadecodigo.codezillas.flappy_bird.Position.GridPosition;

//test
public class Main {
    public static void main(String[] args) {

        GridPosition grid = new GridPosition(1280, 720);

        grid.init();

        Background background = new Background();
        background.initBackground();

        RunBird runBird = new RunBird();
        runBird.start();

        RunObstacle runObstacle = new RunObstacle();
        runObstacle.run();

        try {
            while (true) {
                Thread.sleep(10);
                background.scroll();

            }
        } catch (InterruptedException e) {
            System.out.println("deu merda");
        }

    }
}
