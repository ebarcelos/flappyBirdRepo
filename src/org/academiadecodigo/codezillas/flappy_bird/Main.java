package org.academiadecodigo.codezillas.flappy_bird;

import org.academiadecodigo.codezillas.flappy_bird.Bird.Bird;
import org.academiadecodigo.codezillas.flappy_bird.Position.GridPosition;

public class Main {
    public static void main(String[] args) {

        GridPosition grid = new GridPosition(1280, 720);
        grid.init();

        Bird bird = new Bird();
        bird.initBird();

        try {
            while (true) {
                Thread.sleep(5);
                bird.fall();
                bird.jump();

            }
        } catch (InterruptedException e) {
            System.out.println("deu merda");
        }

    }
}
