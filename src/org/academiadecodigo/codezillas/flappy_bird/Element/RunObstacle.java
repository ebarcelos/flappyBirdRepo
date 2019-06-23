package org.academiadecodigo.codezillas.flappy_bird.Element;

import org.academiadecodigo.codezillas.flappy_bird.Position.ObstacleFactory;

import java.awt.*;

public class RunObstacle extends Thread {

    private Obstacle[] obstacles = new Obstacle[2];
    private Rectangle targetHitbox;


    public void runGame(Rectangle targetHitbox) {
        super.run();
        this.targetHitbox = getTargetHitbox();
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

    public boolean checkCollision(Rectangle targetHitbox) {
        System.out.println("yes;");
        for (int i = 0; i < obstacles.length; i++) {
            if (obstacles[i] != null) {
                return obstacles[i].checkCollision(targetHitbox);
            }
        }
        return false;
    }

    public void paint (Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

            g2.draw(targetHitbox);

    }

    public Rectangle getTargetHitbox() {
        return targetHitbox;
    }
}
