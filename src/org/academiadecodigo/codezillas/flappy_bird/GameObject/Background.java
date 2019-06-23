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


        this.pics[0] = new Picture(0, 0, "resources/img/Background/BackgroundFull.png");
        this.pics[1] = new Picture(1280, 0, "resources/img/Background/BackgroundFull.png");
    }

    public void initBackground() {

        for (int i = 0; i < pics.length; i++) {
            this.pics[i].draw();
        }

    }

    public void scroll() {
        int xInit = this.position.getX();
        System.out.println(position.getX());
        for(int i = 0; i < pics.length; i++) {
            this.position.setX(xInit - 1);
            if (position.getX() <= -1280) {
                this.position.setX(1280);
            }
        }
        for (int i = 0; i < pics.length; i++) {
            pics[i].translate(this.position.getX() - xInit, 0);
        }
    }
}
