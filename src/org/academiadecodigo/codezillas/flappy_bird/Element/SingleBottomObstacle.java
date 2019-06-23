package org.academiadecodigo.codezillas.flappy_bird.Element;

import org.academiadecodigo.codezillas.flappy_bird.Position.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SingleBottomObstacle implements Obstacle {

    private Position position;
    private Rectangle bottomRectangle;
    private Picture picture;
    private boolean passedBird;
    private int obstWidth;
    private int obstHeight;

    public SingleBottomObstacle (int width, int height, ObstacleType type) {
        this.obstWidth = width;
        this.obstHeight = height;

        position = new Position(Position.width, Position.height);
        bottomRectangle = new Rectangle(position.getX(), position.getY()-obstHeight, obstWidth, obstHeight);

        picture = new Picture(bottomRectangle.getX(), bottomRectangle.getY(), type.getPath());
        picture.grow(bottomRectangle.getWidth() - picture.getWidth(), bottomRectangle.getHeight() - picture.getHeight());
    }

    public void init() {
        bottomRectangle.setColor(Color.ORANGE);
        bottomRectangle.draw();
        picture.draw();
    }

    @Override
    public void moveObstacle() {
        int initX = position.getX();
        position.setX(position.getX() - 1);
        bottomRectangle.translate(position.getX() - initX, 0);

        picture.translate(position.getX() - initX, 0);

        checkFinalPosition();
    }

    private void checkFinalPosition () {
        this.passedBird = (this.position.getX() + obstWidth) < 0;
    }

    public boolean hasPassedBird () {
        return passedBird;
    }

    public boolean hasPassedMiddle() {
        return position.getX() < (position.getWidth()/2);
    }

}