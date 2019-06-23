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
    private int obstWidth = 100;
    private int obstHeight = 460;

    public SingleBottomObstacle (int width, int height, ObstacleType type) {
        this.obstWidth = width;
        this.obstHeight = height;

        position = new Position(Position.width, 0);
        bottomRectangle = new Rectangle(position.getX(), 0, obstWidth, obstHeight);

        picture = new Picture(bottomRectangle.getX(), bottomRectangle.getY(), type.getPath());
    }

    public void init() {
        bottomRectangle.setColor(Color.ORANGE);
        bottomRectangle.fill();
        picture.draw();
    }

    @Override
    public void moveObstacle() {
        int initX = position.getX();
        position.setX(position.getX() - 1);
        bottomRectangle.translate(position.getX() - initX, 0);
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
