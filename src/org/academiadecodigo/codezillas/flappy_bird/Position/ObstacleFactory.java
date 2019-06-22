package org.academiadecodigo.codezillas.flappy_bird.Position;

import org.academiadecodigo.codezillas.flappy_bird.Element.Obstacle;

public class ObstacleFactory {

    public static Obstacle[] getNewObstacle () {

        Position posObstacleUp = new Position(1280, 0);
        Position posObstacleDown = new Position(1280, 400);
        Obstacle[] obstacle = new Obstacle[2];
        obstacle[0] = new Obstacle(posObstacleUp);
        obstacle[1] = new Obstacle(posObstacleDown);
        return obstacle;
    }
}
