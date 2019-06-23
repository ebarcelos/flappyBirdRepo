package org.academiadecodigo.codezillas.flappy_bird;

import org.academiadecodigo.codezillas.flappy_bird.Bird.Bird;
import org.academiadecodigo.codezillas.flappy_bird.Element.Obstacle;
import org.academiadecodigo.codezillas.flappy_bird.Position.GridPosition;

public class Main {
    public static void main(String[] args) {

        GridPosition grid = new GridPosition(1280, 720);
        grid.init();

        Background background = new Background();
        background.initBackground();

        Obstacle obstacle = new Obstacle();
        obstacle.init();

        Bird bird = new Bird();
        bird.initBird();

        try {
            while (true) {
                Thread.sleep(5);
                bird.jump();
                bird.fall();
                obstacle.moveObstacle();
                System.out.println(""+obstacle.hasPassedBird());
                if (obstacle.hasPassedBird()){
                    obstacle = new Obstacle();
                    obstacle.init();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("deu merda");
        }

    }
}
