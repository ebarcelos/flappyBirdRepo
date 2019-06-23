package org.academiadecodigo.codezillas.flappy_bird.Element;

import java.awt.*;

public interface Obstacle {
    void moveObstacle();

    void init();

    boolean hasPassedBird();

    boolean hasPassedMiddle();

    boolean checkCollision(Rectangle target);
}
