package org.academiadecodigo.codezillas.flappy_bird.objects.obstacle;

import org.academiadecodigo.codezillas.flappy_bird.position.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class DoubleObstacle implements Obstacle {

    private Position position;
    private Rectangle topHitbox;
    private Rectangle bottomHitbox;
    private Picture topPicture;
    private Picture bottomPicture;
    private boolean passedBird;
    private boolean genObstacle;
    private int obstWidth = 134;
    private int obstHeight = 564;
    private int opening = 250;
    private int minTopHeight = 60;

    public DoubleObstacle(ObstacleType topType, ObstacleType bottomType) {
        int genTopRectPos = genTopRectPos();
        position = new Position(Position.width, genTopRectPos);

        topHitbox = new Rectangle(position.getX(), genTopRectPos, obstWidth, obstHeight);
        bottomHitbox = new Rectangle(position.getX(), position.getY() + obstHeight + minTopHeight + opening, obstWidth, obstHeight);

//        topPicture = new Picture(topHitbox.getX(), topHitbox.getY(), topType.getPath());
//        bottomPicture = new Picture(bottomHitbox.getX(), bottomHitbox.getY(), bottomType.getPath());
    }

    private int genTopRectPos () {
        int range = Position.height - (2 * minTopHeight) - opening;
        int rand = (int) (Math.random() * range);
        return minTopHeight - obstHeight + rand;
    }

    public void init() {
        topHitbox.setColor(Color.CYAN);
        topHitbox.fill();

        bottomHitbox.setColor(Color.BLUE);
        bottomHitbox.fill();

//        topPicture.draw();
//        bottomPicture.draw();
    }

    @Override
    public void moveObstacle() {
        int initX = position.getX();
        position.setX(position.getX() - 1);

        topHitbox.translate(position.getX() - initX, 0);
        bottomHitbox.translate(position.getX() - initX, 0);

//        topPicture.translate(position.getX() - initX, 0);
//        bottomPicture.translate(position.getX() - initX, 0);

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
        return topHitbox.intersects(birdHitbox) || bottomHitbox.intersects(birdHitbox);
    }

}
