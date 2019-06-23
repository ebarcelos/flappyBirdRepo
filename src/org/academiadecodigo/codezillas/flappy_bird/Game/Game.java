 package org.academiadecodigo.codezillas.flappy_bird.Game;

import org.academiadecodigo.codezillas.flappy_bird.GameObject.Background;
import org.academiadecodigo.codezillas.flappy_bird.GameObject.Bird.*;
import org.academiadecodigo.codezillas.flappy_bird.GameObject.GameObject;
import org.academiadecodigo.codezillas.flappy_bird.GameObject.Obstacle.ObstacleFactory;
import org.academiadecodigo.codezillas.flappy_bird.Position.GridPosition;

public class Game {

    public void init() {
        GridPosition grid = new GridPosition(1280, 720);
        grid.init();

        Background background = new Background();
        background.initBackground();

        GameObject x = ObstacleFactory.getNewObstacle();
        x.init();

        RunBird runBird = new RunBird();
        runBird.start();

        try {
            while (true) {

                Thread.sleep(15);
                x.moveObstacle();
                background.scroll();
                x.moveObstacle();
            }
        } catch (InterruptedException e) {
            System.out.println("deu merda");
        }
    }
}
