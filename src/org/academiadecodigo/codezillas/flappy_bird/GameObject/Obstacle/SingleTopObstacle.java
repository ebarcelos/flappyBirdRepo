package org.academiadecodigo.codezillas.flappy_bird.GameObject.Obstacle;

import org.academiadecodigo.codezillas.flappy_bird.Position.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class SingleTopObstacle implements Obstacle {

    private Position position;
    private Rectangle hitbox;
    private Picture picture;
    private boolean passedBird;
    private boolean middlePosition;
    private int obstWidth;
    private int obstHeight;

    public SingleTopObstacle(int width, int height, ObstacleType type) {
        this.obstWidth = width;
        this.obstHeight = height;

        position = new Position(Position.width, 0);
        hitbox = new Rectangle(position.getX(), 0, obstWidth, obstHeight);

        picture = new Picture(hitbox.getX(), hitbox.getY(), type.getPath());
//        picture.grow(hitbox.getWidth() - picture.getWidth(), hitbox.getHeight() - picture.getHeight());
    }

    public void init() {
        picture.draw();
    }

    public Rectangle getHitbox(){
        return hitbox;
    }

    @Override
    public void moveObstacle() {
        int initX = position.getX();
        position.setX(position.getX() - 1);
        hitbox.translate(position.getX() - initX, 0);

        picture.translate(position.getX() - initX, 0);

        checkFinalPosition();
        checkMiddlePosition();
    }

    private void checkFinalPosition () {
        this.passedBird = (this.position.getX() + obstWidth) < 0;
    }

    public boolean hasPassedBird () {
        return passedBird;
    }

    private void checkMiddlePosition () {
        this.middlePosition = position.getX() < (position.getWidth()/2);
    }

    public boolean hasPassedMiddle() {
        return middlePosition;
    }

    public boolean checkCollision(Rectangle birdHitbox){

        if(hitbox.intersects(birdHitbox)){
            System.out.println("yes");
            return true;

        }
        return false;

    }

}
