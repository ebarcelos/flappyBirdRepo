package org.academiadecodigo.codezillas.flappy_bird.GameObject.Bird;

import org.academiadecodigo.codezillas.flappy_bird.GameObject.GameObject;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class BirdHandler implements KeyboardHandler {

    private Bird bird;

    public void setBird(Bird bird) {
        this.bird = bird;
    }

    public void keyPressed(KeyboardEvent var1) {

        if (!bird.isJumping()) {
            bird.startTimer();
            bird.setJumptrue();
            bird.initBird();
        }
    }

    public void keyReleased(KeyboardEvent var1) {
        bird.setJumpfalse();
    }


}
