package org.academiadecodigo.codezillas.flappy_bird.Position;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GridPosition {
    private int xPos;
    private int yPos;
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

