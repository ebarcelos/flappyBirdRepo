package org.academiadecodigo.codezillas.flappy_bird.GameObject;
import org.academiadecodigo.codezillas.flappy_bird.Position.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;
import java.util.List;

public class Background {
    private Position position;
    private Picture[] pics;


    public Background() {
        this.position = new Position(0, 0);
        this.pics = new Picture[2];

        for (int i = 0; i < pics.length; i++) {
            this.pics[i] = new Picture(0, 0, "resources/img/Background/BackgroundFull.png");
        }
    }

    public void initBackground() {

        for (int i = 0; i < pics.length; i++) {
            this.pics[i].draw();
        }

    }

    public void scroll() {
        int xInit = this.position.getX();
        System.out.println(position.getX());
        this.position.setX(xInit - 1);
        if (position.getX() <= -1280) {
            this.position.setX(0);
        }

        for (int i = 0; i < pics.length; i++) {
            pics[i].translate(this.position.getX() - xInit, 0);
        }
    }
}
