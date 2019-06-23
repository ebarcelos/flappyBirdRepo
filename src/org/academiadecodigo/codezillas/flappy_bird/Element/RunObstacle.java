package org.academiadecodigo.codezillas.flappy_bird.Element;

public class RunObstacle extends Thread {

    @Override
    public void run() {
        Obstacle obstacle = new Obstacle();
        obstacle.init();

        try {
            while (true) {

                Thread.sleep(5);
                obstacle.moveObstacle();
                if (obstacle.hasPassedBird()) {
                    obstacle = new Obstacle();
                    obstacle.init();
                }

            }
        } catch (InterruptedException e) {
            System.out.println("deu merda no obstacle");
        }
    }
}
