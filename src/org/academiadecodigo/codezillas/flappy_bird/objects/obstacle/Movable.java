package org.academiadecodigo.codezillas.flappy_bird.objects.obstacle;

import org.academiadecodigo.codezillas.flappy_bird.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public interface Movable {

    void move();

    boolean checkCollision(Rectangle birdHitbox);

    void init();

    GridPosition getPosition();

    int getWidth();

    //TODO: implement this please
    void hide();
}
