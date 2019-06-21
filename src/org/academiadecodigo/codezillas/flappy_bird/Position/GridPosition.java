package org.academiadecodigo.codezillas.flappy_bird.Position;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GridPosition {
    private int xPos;
    private int yPos;
    private int obstacleX1;
    private int obstacleY1;
    private int obstacleX2;
    private int obstacleY2;
    public static int height;
    public static int width;
    Rectangle canvas;

    public GridPosition() {
    }

    public GridPosition (int width, int height) {
        this.width = width;
        this.height = height;

        canvas = new Rectangle(0, 0, width, height);
    }

    public void init () {
        canvas.draw();
    }

    public void goUp() {
        this.yPos -= 10;
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public void setX(int xValue) {
        this.xPos = xValue;
    }

    //*
    public void setObstacleX1(int obstacleX1) {
        this.obstacleX1 = obstacleX1;
    }

    public void setObstacleY1(int obstacleY1) {
        this.obstacleY1 = obstacleY1;
    }

    public void setObstacleX2(int obstacleX2) {
        this.obstacleX2 = obstacleX2;
    }

    public void setObstacleY2(int obstacleY2) {
        this.obstacleY2 = obstacleY2;
    }

    public void setY(int yValue) {
        this.yPos = yValue;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}

