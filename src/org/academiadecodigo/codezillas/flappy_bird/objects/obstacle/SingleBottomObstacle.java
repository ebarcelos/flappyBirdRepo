package org.academiadecodigo.codezillas.flappy_bird.objects.obstacle;

import org.academiadecodigo.codezillas.flappy_bird.position.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SingleBottomObstacle extends ObstacleSuperClass {

    private Rectangle hitbox;
    private Picture picture;

    public SingleBottomObstacle(int width, int height, ObstacleType type) {
        setObstHeight(width);
        setObstHeight(height);

        setPosition(new Position(Position.width, Position.height-getObstHeight()));
        hitbox = new Rectangle(getPosition().getX(), getPosition().getY(), getObstWidth(), getObstHeight());

//        picture = new Picture(hitbox.getX(), hitbox.getY(), type.getPath());
//        picture.grow(hitbox.getWidth() - picture.getWidth(), hitbox.getHeight() - picture.getHeight());
    }

    @Override
    public void init() {
        hitbox.setColor(Color.RED);
        hitbox.fill();
//        picture.draw();
    }

    @Override
    public void moveObstacle() {

        int initX = getPosition().getX();
        getPosition().setX(getPosition().getX() - 1);

        hitbox.translate(getPosition().getX() - initX, 0);
//        picture.translate(getPosition().getX() - initX, 0);
    }

    @Override
    public boolean checkCollision(Rectangle birdHitbox) {
        return hitbox.intersects(birdHitbox);
    }

    public int getWidth() {
        return getObstWidth();
    }
}