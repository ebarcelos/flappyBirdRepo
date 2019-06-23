package org.academiadecodigo.codezillas.flappy_bird.Position;

import org.academiadecodigo.codezillas.flappy_bird.Element.Obstacle;
import org.academiadecodigo.codezillas.flappy_bird.Element.ObstacleType;
import org.academiadecodigo.codezillas.flappy_bird.Element.DoubleObstacle;
import org.academiadecodigo.codezillas.flappy_bird.Element.SingleTopObstacle;
import org.academiadecodigo.codezillas.flappy_bird.Element.SingleBottomObstacle;

public class ObstacleFactory {

    public static Obstacle getNewObstacle() {

//        Position posObstacleUp = new Position(1280, 0);
//        Position posObstacleDown = new Position(1280, 400);
//        DoubleObstacle[] obstacle = new DoubleObstacle[2];

//        int random = (int) (Math.random() * ObstacleType.values().length);
//        ObstacleType obstacleType = ObstacleType.values()[random];

        int obstObjType = (int) (Math.floor(Math.random() * 3));

        switch (obstObjType) {
            case 0:
                return singleTopObstacle();
            case 1:
                return singleBottomObstacle();
            default:
                return doubleObstacle();
        }
    }


    private static Obstacle singleTopObstacle() {
        return new SingleTopObstacle(500, 200, ObstacleType.SATA_PLANE);
    }

    private static Obstacle singleBottomObstacle() {
        int randSingle = (int) (Math.floor(Math.random() * 5));
        switch (randSingle) {
            case 0:
                return new SingleBottomObstacle(300, 200, ObstacleType.TIAGUIM);
            case 1:
                return new SingleBottomObstacle(300, 200, ObstacleType.EMATER_TRUCK);
            case 2:
                return new SingleBottomObstacle(300, 200, ObstacleType.AC_TRUCK);
            case 3:
                return new SingleBottomObstacle(300, 200, ObstacleType.GUARITA_TRUCK);
            default:
                return new SingleBottomObstacle(300, 200, ObstacleType.SUPER_BOCK_TRUCK);
        }
    }

    private static Obstacle doubleObstacle() {
        int randSingle = (int) (Math.floor(Math.random() * 4));
        switch (randSingle) {
            case 0:
                return new DoubleObstacle(ObstacleType.BLUE_PIPE_UP, ObstacleType.BLUE_PIPE_DOWN);
            case 1:
                return new DoubleObstacle(ObstacleType.GREEN_PIPE_UP, ObstacleType.GREEN_PIPE_DOWN);
            case 2:
                return new DoubleObstacle(ObstacleType.YELLOW_PIPE_UP, ObstacleType.YELLOW_PIPE_DOWN);
            default:
                return new DoubleObstacle(ObstacleType.RED_PIPE_UP, ObstacleType.RED_PIPE_DOWN);
        }
    }
}
//        switch (obstacleType) {
//            case RED_PIPE_UP:
//                obstacle[0] = new DoubleObstacle(posObstacleUp);
//                break;
//            case RED_PIPE_DOWN:
//                obstacle[1] = new DoubleObstacle(posObstacleDown);
//                break;
//            case BLUE_PIPE_UP:
//                obstacle[0] = new DoubleObstacle(posObstacleUp);
//                break;
//            case BLUE_PIPE_DOWN:
//                obstacle[1] = new DoubleObstacle(posObstacleDown);
//                break;
//            case GREEN_PIPE_UP:
//                obstacle[0] = new DoubleObstacle(posObstacleUp);
//                break;
//            case GREEN_PIPE_DOWN:
//                obstacle[1] = new DoubleObstacle(posObstacleDown);
//                break;
//            case YELLOW_PIPE_UP:
//                obstacle[0] = new DoubleObstacle(posObstacleUp);
//                break;
//            case YELLOW_PIPE_DOWN:
//                obstacle[1] = new DoubleObstacle(posObstacleDown);
//                break;
//            case AC_TRUCK:
//                obstacle[1] = new DoubleObstacle(posObstacleDown);
//                break;
//            case EMATER_TRUCK:
//                obstacle[1] = new DoubleObstacle(posObstacleDown);
//                break;
//            case GUARITA_TRUCK:
//                obstacle[1] = new DoubleObstacle(posObstacleDown);
//                break;
//            case SUPER_BOCK_TRUCK:
//                obstacle[1] = new DoubleObstacle(posObstacleDown);
//                break;
//            case SATA_PLANE:
//                obstacle[0] = new DoubleObstacle(posObstacleUp);
//                break;
//            case TIAGUIM:
//                obstacle[1] = new DoubleObstacle(posObstacleDown);
//                break;
//        }

