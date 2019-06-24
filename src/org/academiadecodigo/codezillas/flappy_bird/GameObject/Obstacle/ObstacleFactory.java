package org.academiadecodigo.codezillas.flappy_bird.GameObject.Obstacle;

public class ObstacleFactory {

    private static final int PIPE_CHANCES = 90;

    public static Obstacle getNewObstacle() {

        int random = (int) (Math.random() * 100);

        if (random < PIPE_CHANCES) {
            return doubleObstacle();
        } else {

            if (Math.random() > 0.5) {
               return singleTopObstacle();
            } else {
               return singleBottomObstacle();
            }
        }

    }

    private static Obstacle singleTopObstacle() {
        return new SingleTopObstacle(808, 200, ObstacleType.SATA_PLANE);
    }

    private static Obstacle singleBottomObstacle() {
        int randSingle = (int) (Math.floor(Math.random() * 5));
        switch (randSingle) {
            case 0:
                return new SingleBottomObstacle(182, 175, ObstacleType.TIAGUIM);
            case 1:
                return new SingleBottomObstacle(496, 204, ObstacleType.EMATER_TRUCK);
            case 2:
                return new SingleBottomObstacle(400, 204, ObstacleType.AC_TRUCK);
            case 3:
                return new SingleBottomObstacle(400, 204, ObstacleType.GUARITA_TRUCK);
            default:
                return new SingleBottomObstacle(400, 204, ObstacleType.SUPER_BOCK_TRUCK);
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
