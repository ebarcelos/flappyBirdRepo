package org.academiadecodigo.codezillas.flappy_bird.objects.obstacle;

import org.academiadecodigo.codezillas.flappy_bird.objects.GameObject;
import org.academiadecodigo.codezillas.flappy_bird.position.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public interface Obstacle extends GameObject {

    void moveObstacle();

    void init();

    boolean hasPassedBird();

    boolean checkCollision(Rectangle target);

    Position getPosition();

    void genObstacle ();

    boolean hasGenObstacle ();
}
