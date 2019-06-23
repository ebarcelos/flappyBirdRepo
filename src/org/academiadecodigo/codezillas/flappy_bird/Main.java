package org.academiadecodigo.codezillas.flappy_bird;

import org.academiadecodigo.codezillas.flappy_bird.Game.Game;
import org.academiadecodigo.codezillas.flappy_bird.GameObject.Obstacle.Obstacle;
import org.academiadecodigo.codezillas.flappy_bird.Position.GridPosition;
import org.academiadecodigo.codezillas.flappy_bird.GameObject.Background;
import org.academiadecodigo.codezillas.flappy_bird.GameObject.Bird.RunBird;

public class Main {
    public static void main(String[] args) {

        GridPosition grid = new GridPosition(1280, 720);
        grid.init();

        Background background = new Background();
        background.initBackground();

        RunBird runBird = new RunBird();
        runBird.start();

        Obstacle obstacle = new Obstacle();
        obstacle.init();
        obstacle.getBounds();


        try {
            while (true) {

                Thread.sleep(10);
                background.scroll();
                obstacle.moveObstacle();
            }
        } catch (InterruptedException e) {
            System.out.println("deu merda");
        }

    }
}
