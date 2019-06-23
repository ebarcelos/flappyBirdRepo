package org.academiadecodigo.codezillas.flappy_bird.Element;

import org.academiadecodigo.codezillas.flappy_bird.Position.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class DoubleObstacle implements Obstacle {

    private Position position;
    private Rectangle topRectangle;
    private Rectangle bottomRectangle;
    private Picture topPicture;
    private Picture bottomPicture;
    private boolean passedBird;
    private int obstWidth = 100;
    private int obstHeight = 460;
    private int opening = 200;
    private int minTopHeight = 60;
    private int range = 400;

    public DoubleObstacle(ObstacleType topType, ObstacleType bottomType) {
        int genTopRectPos = genTopRectPos();
        position = new Position(Position.width, genTopRectPos);

        topRectangle = new Rectangle(position.getX(), genTopRectPos, obstWidth, obstHeight);
        bottomRectangle = new Rectangle(position.getX(), position.getY() + obstHeight + minTopHeight + opening, obstWidth, obstHeight);

        topPicture = new Picture(topRectangle.getX(), topRectangle.getY(), topType.getPath());
        bottomPicture = new Picture(bottomRectangle.getX(), bottomRectangle.getY(), bottomType.getPath());
    }

    private int genTopRectPos () {
        int rand = (int) (Math.random() * range);
        return -(rand + minTopHeight);
    }

    public void init() {
        topRectangle.setColor(Color.GREEN);
        bottomRectangle.setColor(Color.YELLOW);

        topRectangle.fill();
        bottomRectangle.fill();

        topPicture.draw();
        bottomPicture.draw();
    }

    @Override
    public void moveObstacle() {
        int initX = position.getX();
        position.setX(position.getX() - 1);
        topRectangle.translate(position.getX() - initX, 0);
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
