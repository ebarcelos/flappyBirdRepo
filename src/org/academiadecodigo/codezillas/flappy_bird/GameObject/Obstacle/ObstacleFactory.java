package org.academiadecodigo.codezillas.flappy_bird.GameObject.Obstacle;

import org.academiadecodigo.codezillas.flappy_bird.GameObject.Obstacle.Obstacle;

public class ObstacleFactory {

    private Obstacle[][] obstacles;
    public Obstacle getObstacle() {

        Obstacle obstacle = new Obstacle();
        return obstacle;
    }
}
