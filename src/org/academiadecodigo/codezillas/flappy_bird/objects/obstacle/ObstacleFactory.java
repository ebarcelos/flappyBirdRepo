package org.academiadecodigo.codezillas.flappy_bird.objects.obstacle;

public class ObstacleFactory {

    private static final int PIPE_CHANCES = 100;

    public static Movable getNewObstacle() {

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

    //TODO: Fix magic numbers

    private static Movable singleTopObstacle() {
        return new SingleTopMovable(808, 200, ObstacleType.SATA_PLANE);
    }

    private static Movable singleBottomObstacle() {
        int randSingle = (int) (Math.floor(Math.random() * 5));
        switch (randSingle) {
            case 0:
                return new SingleBottomMovable(182, 175, ObstacleType.TIAGUIM);
            case 1:
                return new SingleBottomMovable(496, 204, ObstacleType.EMATER_TRUCK);
            case 2:
                return new SingleBottomMovable(400, 204, ObstacleType.AC_TRUCK);
            case 3:
                return new SingleBottomMovable(400, 204, ObstacleType.GUARITA_TRUCK);
            default:
                return new SingleBottomMovable(400, 204, ObstacleType.SUPER_BOCK_TRUCK);
        }
    }

    private static Movable doubleObstacle() {
        int randSingle = (int) (Math.floor(Math.random() * 4));

        switch (randSingle) {
            case 0:
                return new DoubleMovable(115, 564, ObstacleType.BLUE_PIPE_UP, ObstacleType.BLUE_PIPE_DOWN);
            case 1:
                return new DoubleMovable(115, 564, ObstacleType.GREEN_PIPE_UP, ObstacleType.GREEN_PIPE_DOWN);
            case 2:
                return new DoubleMovable(115, 564, ObstacleType.YELLOW_PIPE_UP, ObstacleType.YELLOW_PIPE_DOWN);
            default:
                return new DoubleMovable(115, 564, ObstacleType.RED_PIPE_UP, ObstacleType.RED_PIPE_DOWN);
        }
    }
}
