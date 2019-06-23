package org.academiadecodigo.codezillas.flappy_bird;

import org.academiadecodigo.codezillas.flappy_bird.Position.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Obstacle {

    private Position position;
    private Rectangle obstacle;

    public Obstacle() {
        position = new Position(1100, 0);
        obstacle = new Rectangle(position.getX(), position.getY(), 100, 300);
    }

    public void initObstacle() {
        obstacle.fill();
    }

    public void scroll() {
        int xInit = this.position.getX();
        //System.out.println(position.getX());
        this.position.setX(xInit - 1);

        if (position.getX() <= -1280) {
            this.position.setX(0);
            obstacle.translate(0,0);
        }

        obstacle.translate(this.position.getX() - xInit, 0);
    }
}
