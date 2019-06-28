package org.academiadecodigo.codezillas.flappy_bird.objects.obstacle;

import org.academiadecodigo.codezillas.flappy_bird.GameConfig;
import org.academiadecodigo.codezillas.flappy_bird.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SingleBottomMovable extends Obstacle {

    //TODO: Consider moving this constructor and these properties to the super class
    //TODO: Make sure it does not interfere with DoubleMovable
    private Rectangle hitbox;
    private Picture picture;

    public SingleBottomMovable(int width, int height, ObstacleType type) {
        setHeight(width);
        setHeight(height);

        setPosition(new GridPosition(GameConfig.SCREEN_WIDTH,
                GameConfig.SCREEN_HEIGHT - getHeight()
        ));
        hitbox = new Rectangle(getPosition().getX(), getPosition().getY(), getWidth(), getHeight());

//        picture = new Picture(hitbox.getX(), hitbox.getY(), type.getPath());
    }

    @Override
    public void init() {
        hitbox.setColor(Color.RED);
        hitbox.fill();
//        picture.draw();
    }

    @Override
    public void hide() {
        //picture.delete();
        hitbox.delete();
    }

    @Override
    public void move() {

        int initX = getPosition().getX();
        getPosition().setX(getPosition().getX() - 1);

        hitbox.translate(getPosition().getX() - initX, 0);
//        picture.translate(getPosition().getX() - initX, 0);
    }

    @Override
    public boolean checkCollision(Rectangle birdHitbox) {
        return hitbox.intersects(birdHitbox);
    }
}