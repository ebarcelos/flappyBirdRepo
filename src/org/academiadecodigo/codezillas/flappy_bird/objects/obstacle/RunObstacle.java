package org.academiadecodigo.codezillas.flappy_bird.objects.obstacle;

import org.academiadecodigo.codezillas.flappy_bird.objects.score.ObstacleCounter;
import org.academiadecodigo.codezillas.flappy_bird.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class RunObstacle extends Thread {

    private Obstacle[] obstacles;
    private Rectangle targetHitbox;
    private static final int MIN_DIFICULTY = 1;
    private static final int MAX_DIFICULTY = 4;
    private static final int OBSTACLE_INCREASE_DELTA = 5;
    private int difficultyLevel;

    public RunObstacle (Rectangle targetHitbox) {
        this.targetHitbox = targetHitbox;
        difficultyLevel = MIN_DIFICULTY;

        obstacles = new Obstacle[MAX_DIFICULTY + 1];
    }

    public void increaseDifficulty() {
        if (this.difficultyLevel < MAX_DIFICULTY) {
            difficultyLevel++;
        }
    }

    @Override
    public void run () {
        fillNextNull();
        ObstacleCounter.growSize();

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

                if (obstacles[i].getPosition().getX() + 134 < 0) {
                    ObstacleCounter.addCounter();
                    obstacles[i] = null;
                    continue;
                }

                if (obstacles[i] instanceof DoubleObstacle) {
                    if (obstacles[i].getPosition().getX() < GridPosition.width - (GridPosition.width / difficultyLevel)) {
                        if (!obstacles[i].hasGenObstacle()) {
                            obstacles[i].genObstacle();
                            fillNextNull();
                        }
                    }
                } else {
                    if (obstacles[i].getPosition().getX() + obstacles[i].getWidth() < GridPosition.width - (GridPosition.width / difficultyLevel)) {
                        if (!obstacles[i].hasGenObstacle()) {
                            obstacles[i].genObstacle();
                            fillNextNull();
                        }
                    }
                }

                if (obstacles[i].checkCollision(targetHitbox)) {
                    return;
                }

                if (ObstacleCounter.getCounter() == (difficultyLevel * OBSTACLE_INCREASE_DELTA)) {
                    increaseDifficulty();
                }

                ObstacleCounter.showCounter();
            }
        }
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
