package org.academiadecodigo.codezillas.flappy_bird.GameObject.Obstacle;

import org.academiadecodigo.codezillas.flappy_bird.GameObject.PointCounter.ObstacleCounter;
import org.academiadecodigo.codezillas.flappy_bird.Position.GridPosition;
import org.academiadecodigo.codezillas.flappy_bird.Position.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class RunObstacle extends Thread {

    private Obstacle[] obstacles;
    private Rectangle targetHitbox;
    private static final int MIN_DIFICULTY = 2;
    private static final int MAX_DIFICULTY = 4;
    private static final int OBSTACLE_INCREASE_DELTA = 2;
    private int difficultyLevel;

    public RunObstacle (Rectangle targetHitbox) {
        this.targetHitbox = targetHitbox;
        difficultyLevel = MIN_DIFICULTY;

        obstacles = new Obstacle[MAX_DIFICULTY];
    }

    public void increaseDificulty() {
        if (this.difficultyLevel < MAX_DIFICULTY) {
            difficultyLevel++;
        }
    }

    @Override
    public void run () {
//        super.run();
        fillNextNull();
        ObstacleCounter.growSize();

 //       try {
            while (true) {

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }

                for (int i = 0; i < obstacles.length; i++) {
                    if (obstacles[i] == null) {
                        continue;
                    }

                    obstacles[i].moveObstacle();

                    if (obstacles[i].getPosition().getX() + 150 < 0) {
                        ObstacleCounter.addCounter();
                        obstacles[i] = null;
                        continue;
                    }

                    if (obstacles[i].getPosition().getX() < GridPosition.width - (GridPosition.width / difficultyLevel)) {
                        if (!obstacles[i].hasGenObstacle()) {
                            obstacles[i].genObstacle();
                            fillNextNull();
                        }
                    }

                    if (obstacles[i].checkCollision(targetHitbox)) {
                        return;
                    }

                    if (ObstacleCounter.getCounter() > (difficultyLevel * OBSTACLE_INCREASE_DELTA)) {
                        increaseDificulty();
                    }

                    ObstacleCounter.showCounter();
                }
            }
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
        }


    private void fillNextNull() {
        for (int i=0; i<obstacles.length; i++) {
            if (obstacles[i] == null) {
                obstacles[i] = ObstacleFactory.getNewObstacle();
                obstacles[i].init();
                return;
            }
        }
    }

}
