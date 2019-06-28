package org.academiadecodigo.codezillas.flappy_bird.objects.obstacle;

import org.academiadecodigo.codezillas.flappy_bird.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public abstract class Obstacle implements Movable {

    private int width;
    private int height;
    private GridPosition position;

    int getHeight() {
        return this.height;
    }

    void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    void setWidth(int width) {
        this.width = width;
    }

    public void setPosition(GridPosition position) {
        this.position = position;
    }

    @Override
    public GridPosition getPosition() {
        return this.position;
    }

    @Override
    public abstract void move();

    @Override
    public abstract boolean checkCollision(Rectangle birdHitbox);
}
