package org.academiadecodigo.codezillas.flappy_bird.GameObject;
import org.academiadecodigo.codezillas.flappy_bird.Position.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;
import java.util.List;

public class Background {
    private Position position;
    private Picture picture;

    public Background() {
        this.position = new Position(0, 0);
        this.picture = new Picture(0, 0, "resources/background3.jpg");

    }

    public void initBackground() {
        this.picture.draw();

    }

    public void scroll() {
        int xInit = this.position.getX();
        //System.out.println(position.getX());
        this.position.setX(xInit - 1);

        if (position.getX() <= -1280) {
            this.position.setX(0);
            picture.translate(0,0);
        }

        picture.translate(this.position.getX() - xInit, 0);
    }
}

