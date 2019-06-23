package org.academiadecodigo.codezillas.flappy_bird.Position;

import org.academiadecodigo.codezillas.flappy_bird.Element.Obstacle;
import org.academiadecodigo.codezillas.flappy_bird.Element.ObstacleType;

public class ObstacleFactory {

    public static Obstacle[] getNewObstacle () {

        Position posObstacleUp = new Position(1280, 0);
        Position posObstacleDown = new Position(1280, 400);
        Obstacle[] obstacle = new Obstacle[2];

        int random = (int) (Math.random() * ObstacleType.values().length);
        ObstacleType obstacleType = ObstacleType.values()[random];

        switch (obstacleType) {
            case RED_PIPE_UP:
                obstacle[0] = new Obstacle(posObstacleUp);
                break;
            case RED_PIPE_DOWN:
                obstacle[1] = new Obstacle(posObstacleDown);
                break;
            case BLUE_PIPE_UP:
                obstacle[0] = new Obstacle(posObstacleUp);
                break;
            case BLUE_PIPE_DOWN:
                obstacle[1] = new Obstacle(posObstacleDown);
                break;
            case GREEN_PIPE_UP:
                obstacle[0] = new Obstacle(posObstacleUp);
                break;
            case GREEN_PIPE_DOWN:
                obstacle[1] = new Obstacle(posObstacleDown);
                break;
            case YELLOW_PIPE_UP:
                obstacle[0] = new Obstacle(posObstacleUp);
                break;
            case YELLOW_PIPE_DOWN:
                obstacle[1] = new Obstacle(posObstacleDown);
                break;
            case AC_TRUCK:
                obstacle[1] = new Obstacle(posObstacleDown);
                break;
            case EMATER_TRUCK:
                obstacle[1] = new Obstacle(posObstacleDown);
                break;
            case GUARITA_TRUCK:
                obstacle[1] = new Obstacle(posObstacleDown);
                break;
            case SUPER_BOCK_TRUCK:
                obstacle[1] = new Obstacle(posObstacleDown);
                break;
            case SATA_PLANE:
                obstacle[0] = new Obstacle(posObstacleUp);
                break;
            case TIAGUIM:
                obstacle[1] = new Obstacle(posObstacleDown);
                break;
        }

        return obstacle;
    }
}
