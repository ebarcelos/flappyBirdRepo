package org.academiadecodigo.codezillas.flappy_bird;

import org.academiadecodigo.codezillas.flappy_bird.Position.GridPosition;
import org.academiadecodigo.codezillas.flappy_bird.Position.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Background {
    private Position position;
    private Rectangle rectangle;

    public Background() {
        this.position = new Position(0, 0);
        this.rectangle = new Rectangle(position.getX(), position.getY(), 1280, 720);

    }

    public void initBackground() {
        rectangle.setColor(Color.BLUE);
        rectangle.fill();


    }

    public void scroll() {
        int xInit = this.position.getX();
        System.out.println(position.getX());
        this.position.setX(xInit - 1);

        if (position.getX() <= -1280) {
            this.position.setX(0);
        }

        rectangle.translate(this.position.getX() - xInit, 0);
    }
}
