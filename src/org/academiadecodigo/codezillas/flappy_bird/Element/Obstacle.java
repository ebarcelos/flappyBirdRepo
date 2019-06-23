package org.academiadecodigo.codezillas.flappy_bird.Element;

public interface Obstacle {

    void moveObstacle();

    void init();

    boolean hasPassedBird();

    boolean hasPassedMiddle();
}
