package org.academiadecodigo.codezillas.flappy_bird.objects.obstacle;

import org.academiadecodigo.codezillas.flappy_bird.position.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public abstract class ObstacleSuperClass implements Obstacle {

    private boolean genObstacle;
    private int obstWidth;
    private int obstHeight;
    private Position position;

    public int getObstHeight() {
        return this.obstHeight;
    }

    public void setObstHeight(int obstHeight) {
        this.obstHeight = obstHeight;
    }

    public int getObstWidth() {
        return this.obstWidth;
    }

    public void setObstWidth (int obstWidth) {
        this.obstWidth = obstWidth;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public abstract void init();

    @Override
    public abstract void moveObstacle();

    @Override
    public abstract boolean checkCollision(Rectangle birdHitbox);

    @Override
    public void genObstacle() {
        this.genObstacle = true;
    }

    @Override
    public boolean hasGenObstacle() {
        return this.genObstacle;
    }

    @Override
    public abstract int getWidth();
}
