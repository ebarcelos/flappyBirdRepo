package org.academiadecodigo.codezillas.flappy_bird.Element;

import org.academiadecodigo.codezillas.flappy_bird.Position.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SingleTopObstacle implements Obstacle {

    private Position position;
    private Rectangle topRectangle;
    private Picture picture;
    private boolean passedBird;
    private int obstWidth = 100;
    private int obstHeight = 460;

    public SingleTopObstacle(int width, int height, ObstacleType type) {
        this.obstWidth = width;
        this.obstHeight = height;

        position = new Position(Position.width, 0);
        topRectangle = new Rectangle(position.getX(), 0, obstWidth, obstHeight);

        picture = new Picture(topRectangle.getX(), topRectangle.getY(), type.getPath());
    }

    public void init() {
        topRectangle.setColor(Color.GREEN);
        topRectangle.fill();
        picture.draw();
    }

    @Override
    public void moveObstacle() {
        int initX = position.getX();
        position.setX(position.getX() - 1);
        topRectangle.translate(position.getX() - initX, 0);
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
