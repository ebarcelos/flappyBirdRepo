package org.academiadecodigo.codezillas.flappy_bird.Element;


public enum ObstacleType {

    RED_PIPE_UP("resources/img/ObstaclePipeRedUp.png"),
    RED_PIPE_DOWN("resources/img/ObstaclePipeRedDown.png"),
    BLUE_PIPE_UP("resources/img/ObstaclePipeBlueUp.png"),
    BLUE_PIPE_DOWN("resources/img/ObstaclePipeBlueDown.png"),
    GREEN_PIPE_UP("resources/img/ObstaclePipeGreenUp.png"),
    GREEN_PIPE_DOWN("resources/img/ObstaclePipeGreenDown.png"),
    YELLOW_PIPE_UP("resources/img/ObstaclePipeYellowUp.png"),
    YELLOW_PIPE_DOWN("resources/img/ObstaclePipeYellowDown.png"),
    AC_TRUCK("resources/img/ObstacleAC.png"),
    EMATER_TRUCK("resources/img/ObstacleEmater.png"),
    GUARITA_TRUCK("resources/img/ObstacleGuarita.png"),
    SUPER_BOCK_TRUCK("resources/img/ObstacleSBock.png"),
    SATA_PLANE("resources/img/ObstacleSata.png"),
    TIAGUIM("resources/img/ObstacleTiaguim.png");


    private String path;

    ObstacleType(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
