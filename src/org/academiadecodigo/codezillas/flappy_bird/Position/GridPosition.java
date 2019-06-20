package org.academiadecodigo.codezillas.flappy_bird.Position;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GridPosition {
    private int xPos;
    private int yPos;
    public int height;
    public int width;
    public final int PADDING = 10;
    Rectangle canvas;

    public GridPosition() {
    }

    public GridPosition (int width, int height) {
        this.width = width;
        this.height = height;

        canvas = new Rectangle(PADDING, PADDING, width, height);
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
//        if (yValue < (height - 50)){
//            this.yPos = yValue;
//            return;
//        }
//        this.yPos = height-50;
        this.yPos = yValue;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
