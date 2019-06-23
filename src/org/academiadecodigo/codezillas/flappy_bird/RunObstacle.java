package org.academiadecodigo.codezillas.flappy_bird;

import org.academiadecodigo.codezillas.flappy_bird.Bird.Bird;

public class RunObstacle extends Thread{

    @Override
    public void run() {
        Obstacle obstacle = new Obstacle();
        obstacle.initObstacle();

        try {
            while (true) {

                Thread.sleep(10);
                obstacle.scroll();

            }
        } catch (InterruptedException e) {
            System.out.println("deu merda");
        }
    }
}
