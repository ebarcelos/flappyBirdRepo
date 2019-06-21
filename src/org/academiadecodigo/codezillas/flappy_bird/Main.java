package org.academiadecodigo.codezillas.flappy_bird;

import org.academiadecodigo.codezillas.flappy_bird.Element.Bird;
import org.academiadecodigo.codezillas.flappy_bird.Element.Obstacle;
import org.academiadecodigo.codezillas.flappy_bird.Position.GridPosition;
import org.academiadecodigo.codezillas.flappy_bird.Position.ObstacleFactory;

public class Main {
    public static void main(String[] args) {

        GridPosition grid = new GridPosition(1280, 720);
        grid.init();

        Bird bird = new Bird();
        bird.initBird();

        ObstacleFactory.getObstacle();

        try {
            while (true) {
                Thread.sleep(3);
                bird.fall();
            }
        } catch (InterruptedException e) {
            System.out.println("deu merda");
        }
    }
}
