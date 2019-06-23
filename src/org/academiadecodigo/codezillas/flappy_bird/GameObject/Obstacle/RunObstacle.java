package org.academiadecodigo.codezillas.flappy_bird.GameObject.Obstacle;

import org.academiadecodigo.codezillas.flappy_bird.Position.ObstacleFactory;

import java.awt.*;

public class RunObstacle extends Thread {

    private Obstacle[] obstacles = new Obstacle[2];


    public void runGame(Rectangle targetHitbox) {
        super.run();
        obstacles[0] = ObstacleFactory.getNewObstacle();

        try {
            while (true) {

                Thread.sleep(5);

                for ( int i=0; i<obstacles.length; i++) {

                    if (obstacles[i] != null) {
                        obstacles[i].moveObstacle();

                        if (obstacles[i].hasPassedBird()) {
                            obstacles[i] = ObstacleFactory.getNewObstacle();
                            obstacles[i].init();
                        }

                        if (obstacles[i].hasPassedMiddle()){
                            fillObstacles();
                        }

                        if (obstacles[i].hasPassedMiddle()){
                            fillObstacles();
                        }

                        if (obstacles[i].checkCollision(targetHitbox)){
                            System.out.println("GAME OVER");

                        }


                    }

                }

            }
        } catch (InterruptedException e) {
            System.out.println("deu merda no obstacle");
        }
    }

    public void fillObstacles() {
        for (int i=0; i<obstacles.length; i++) {
            if (obstacles[i] == null) {
                obstacles[i] = ObstacleFactory.getNewObstacle();
            }
        }
    }

}

