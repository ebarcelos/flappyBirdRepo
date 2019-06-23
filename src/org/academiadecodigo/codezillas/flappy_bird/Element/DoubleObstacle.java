package org.academiadecodigo.codezillas.flappy_bird.Element;

import org.academiadecodigo.codezillas.flappy_bird.Position.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class DoubleObstacle implements Obstacle {

    private Position position;
    private Rectangle topHitbox;
    private Rectangle bottomHitbox;
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

        topHitbox = new Rectangle(position.getX(), genTopRectPos, obstWidth, obstHeight);
        bottomHitbox = new Rectangle(position.getX(), position.getY() + obstHeight + minTopHeight + opening, obstWidth, obstHeight);

        topPicture = new Picture(topHitbox.getX(), topHitbox.getY(), topType.getPath());
        bottomPicture = new Picture(bottomHitbox.getX(), bottomHitbox.getY(), bottomType.getPath());
    }

    private int genTopRectPos () {
        int rand = (int) (Math.random() * range);
        return -(rand + minTopHeight);
    }

    public void init() {
        //topHitbox.setColor(Color.GREEN);
        //bottomHitbox.setColor(Color.YELLOW);

        //topHitbox.draw();
        //bottomHitbox.draw();

        topPicture.draw();
        bottomPicture.draw();
    }

    @Override
    public void moveObstacle() {
        int initX = position.getX();
        position.setX(position.getX() - 1);

        topHitbox.translate(position.getX() - initX, 0);
        bottomHitbox.translate(position.getX() - initX, 0);

        topPicture.translate(position.getX() - initX, 0);
        bottomPicture.translate(position.getX() - initX, 0);

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

    public boolean checkCollision(Rectangle birdHitbox){

        if(topHitbox.intersects(birdHitbox) || bottomHitbox.intersects(birdHitbox) ){
            System.out.println("yes");
            return true;
        }
        return false;

    }
}
