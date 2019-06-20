package org.academiadecodigo.codezillas.flappy_bird.Element;

import org.academiadecodigo.codezillas.flappy_bird.Position.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Bird {

    private Position position;
    private Ellipse ellipse;

    public Bird() {
        this.position = new Position(50, (720/2)-(50/2));
        this.ellipse = new Ellipse(position.getX(), position.getY(), 50, 50);
    }

    public void initBird() {
        ellipse.setColor(Color.BLACK);
        ellipse.fill();
    }

    public void fall() {
        int yInit = this.position.getY();
        System.out.println(position.getY());
        this.position.setY(yInit + 1);
        ellipse.translate(0, this.position.getY() - yInit);
    }
}
