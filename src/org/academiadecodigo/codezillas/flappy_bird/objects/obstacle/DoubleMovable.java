package org.academiadecodigo.codezillas.flappy_bird.objects.obstacle;

import org.academiadecodigo.codezillas.flappy_bird.GameConfig;
import org.academiadecodigo.codezillas.flappy_bird.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class DoubleMovable extends Obstacle {

    private Rectangle topHitbox;
    private Rectangle bottomHitbox;
    private Picture topPicture;
    private Picture bottomPicture;
    private final int opening = 250;
    private final int minTopHeight = 60;

    public DoubleMovable(int width, int height, ObstacleType topType, ObstacleType bottomType) {
        setWidth(width);
        setHeight(height);
        int genTopRectPos = genTopRectPos();
        setPosition(new GridPosition(GameConfig.SCREEN_WIDTH, genTopRectPos));

        topHitbox = new Rectangle(getPosition().getX(), genTopRectPos, getWidth(), getHeight());
        bottomHitbox = new Rectangle(getPosition().getX(), getPosition().getY() + getHeight() + minTopHeight + opening, getWidth(), getHeight());

        //TODO: Find a name for a constant for 10
        topPicture = new Picture(topHitbox.getX() - 10, topHitbox.getY() + 1, topType.getPath());
        bottomPicture = new Picture(bottomHitbox.getX() - 10, bottomHitbox.getY() - 1, bottomType.getPath());
    }

    private int genTopRectPos() {
        int range = GameConfig.SCREEN_HEIGHT - (2 * minTopHeight) - opening;
        int rand = (int) (Math.random() * range);
        return minTopHeight - getHeight() + rand;
    }

    @Override
    public void init() {
        topHitbox.draw();
        bottomHitbox.draw();
        topPicture.draw();
        bottomPicture.draw();
    }

    @Override
    public void hide() {
        topHitbox.delete();
        bottomHitbox.delete();
        topPicture.delete();
        bottomPicture.delete();
    }

    @Override
    public void move() {
        int initX = getPosition().getX();
        getPosition().setX(getPosition().getX() - 1);
        int distance = getPosition().getX() - initX;

        topHitbox.translate(distance, 0);
        bottomHitbox.translate(distance, 0);
        topPicture.translate(distance, 0);
        bottomPicture.translate(distance, 0);
    }

    @Override
    public boolean checkCollision(Rectangle birdHitbox) {
        return topHitbox.intersects(birdHitbox) || bottomHitbox.intersects(birdHitbox);
    }
}
