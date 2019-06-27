package org.academiadecodigo.codezillas.flappy_bird.objects.obstacle;

import org.academiadecodigo.codezillas.flappy_bird.position.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public interface Obstacle {

    void init();

    void moveObstacle();

    boolean checkCollision(Rectangle birdHitbox);

    Position getPosition();

    void genObstacle ();

    boolean hasGenObstacle ();

    int getWidth();
}
