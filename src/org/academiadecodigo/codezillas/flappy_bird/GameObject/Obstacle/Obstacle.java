package org.academiadecodigo.codezillas.flappy_bird.GameObject.Obstacle;

import org.academiadecodigo.codezillas.flappy_bird.GameObject.GameObject;

import java.awt.*;

public interface Obstacle extends GameObject {

    void moveObstacle();

    void init();

    boolean hasPassedBird();

    boolean hasPassedMiddle();

    boolean checkCollision(Rectangle target);


}
