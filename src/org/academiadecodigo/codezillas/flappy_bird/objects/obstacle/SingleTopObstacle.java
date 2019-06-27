package org.academiadecodigo.codezillas.flappy_bird.objects.obstacle;

import org.academiadecodigo.codezillas.flappy_bird.position.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SingleTopObstacle extends ObstacleSuperClass {

    private Rectangle hitbox;
    private Picture picture;

    public SingleTopObstacle(int width, int height, ObstacleType type) {
        setObstWidth(width);
        setObstHeight(height);

        setPosition(new Position(Position.width, 0));
        hitbox = new Rectangle(getPosition().getX(), 0, getObstWidth(), getObstHeight());
//        picture = new Picture(hitbox.getX(), hitbox.getY(), type.getPath());
    }

    @Override
    public void init(){
        hitbox.setColor(Color.GREEN);
        hitbox.fill();
//        picture.draw();
    }

    @Override
    public void moveObstacle() {
        int initX = getPosition().getX();
        getPosition().setX(getPosition().getX() - 1);

        hitbox.translate(getPosition().getX() - initX, 0);
//        picture.translate(position.getX() - initX, 0);
    }

    @Override
    public boolean checkCollision(Rectangle birdHitbox){
        return hitbox.intersects(birdHitbox);
    }

    public int getWidth() {
        return getObstWidth();
    }
}
