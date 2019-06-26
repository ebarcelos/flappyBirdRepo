package org.academiadecodigo.codezillas.flappy_bird.objects.obstacle;

import org.academiadecodigo.codezillas.flappy_bird.position.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SingleTopObstacle implements Obstacle {

    private Position position;
    private Rectangle hitbox;
    private Picture picture;
    private boolean passedBird;
    private boolean genObstacle;
    private int obstWidth;
    private int obstHeight;

    public SingleTopObstacle(int width, int height, ObstacleType type) {
        this.obstWidth = width;
        this.obstHeight = height;

        position = new Position(Position.width, 0);
        hitbox = new Rectangle(position.getX(), 0, obstWidth, obstHeight);
//        picture = new Picture(hitbox.getX(), hitbox.getY(), type.getPath());
    }

    public void init(){
        hitbox.setColor(Color.GREEN);
        hitbox.fill();
//        picture.draw();
    }

    public Rectangle getHitbox(){
        return hitbox;
    }

    @Override
    public void moveObstacle() {
        int initX = position.getX();
        position.setX(position.getX() - 1);
        hitbox.translate(position.getX() - initX, 0);

//        picture.translate(position.getX() - initX, 0);

        checkFinalPosition();
    }

    private void checkFinalPosition () {
        this.passedBird = (this.position.getX() + obstWidth) < 0;
    }

    public boolean hasPassedBird () {
        return passedBird;
    }

    public Position getPosition() {
        return position;
    }

    public void genObstacle () {
        genObstacle = true;
    }

    public boolean hasGenObstacle () {
        return genObstacle;
    }

    public boolean checkCollision(Rectangle birdHitbox){

        return hitbox.intersects(birdHitbox);

    }

}
