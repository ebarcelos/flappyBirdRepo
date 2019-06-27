package org.academiadecodigo.codezillas.flappy_bird.objects.obstacle;

import org.academiadecodigo.codezillas.flappy_bird.position.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class DoubleObstacle extends ObstacleSuperClass {

    private Rectangle topHitbox;
    private Rectangle bottomHitbox;
    private Picture topPicture;
    private Picture bottomPicture;
    private final int opening = 250;
    private final int minTopHeight = 60;

    public DoubleObstacle(int width, int height, ObstacleType topType, ObstacleType bottomType) {
        setObstWidth(width);
        setObstHeight(height);
        int genTopRectPos = genTopRectPos();
        setPosition(new Position(Position.width, genTopRectPos));

        topHitbox = new Rectangle(getPosition().getX(), genTopRectPos, getObstWidth(), getObstHeight());
        bottomHitbox = new Rectangle(getPosition().getX(), getPosition().getY() + getObstHeight() + minTopHeight + opening, getObstWidth(), getObstHeight());

        topPicture = new Picture(topHitbox.getX()-10, topHitbox.getY()+1, topType.getPath());
        bottomPicture = new Picture(bottomHitbox.getX()-10, bottomHitbox.getY()-1, bottomType.getPath());
    }

    private int genTopRectPos () {
        int range = Position.height - (2 * minTopHeight) - opening;
        int rand = (int) (Math.random() * range);
        return minTopHeight - getObstHeight() + rand;
    }

    @Override
    public void init() {
        //topHitbox.setColor(Color.CYAN);
        topHitbox.draw();

        //bottomHitbox.setColor(Color.BLUE);
        bottomHitbox.draw();

        topPicture.draw();
        bottomPicture.draw();
    }

    @Override
    public void moveObstacle() {
        int initX = getPosition().getX();
        getPosition().setX(getPosition().getX() - 1);

        topHitbox.translate(getPosition().getX() - initX, 0);
        bottomHitbox.translate(getPosition().getX() - initX, 0);

        topPicture.translate(getPosition().getX() - initX, 0);
        bottomPicture.translate(getPosition().getX() - initX, 0);
    }

    @Override
    public boolean checkCollision(Rectangle birdHitbox){
        return topHitbox.intersects(birdHitbox) || bottomHitbox.intersects(birdHitbox);
    }

    public int getWidth() {
        return getObstWidth();
    }
}
