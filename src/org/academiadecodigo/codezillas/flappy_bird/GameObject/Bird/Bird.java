package org.academiadecodigo.codezillas.flappy_bird.GameObject.Bird;

import org.academiadecodigo.codezillas.flappy_bird.GameObject.GameObject;
import org.academiadecodigo.codezillas.flappy_bird.Position.GridPosition;
import org.academiadecodigo.codezillas.flappy_bird.Position.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bird implements GameObject {

    private Position position;
    private Ellipse ellipse;
    private Picture picture;

    private double timer;
    private static final double TIMER_MAX = 2;

    private boolean timerStarted;
    private boolean isJumping;

    public Bird() {

        position = new Position(50, (720 - 150) - (50 / 2));
        ellipse = new Ellipse(position.getX(), position.getY(), 50, 50);
        picture = new Picture(ellipse.getX(), ellipse.getY(),"resources/img/BirdNest.png");

    }

    public void initBird() {
        picture.draw();

    }

    public void setJumpfalse() {
        isJumping = false;
    }

    public void setJumptrue() {
        isJumping = true;
    }

    public boolean isJumping() {
        return isJumping;
    }

    public void startTimer() {
        timerStarted = true;
    }




    public void fall() {

        int yInit = position.getY();

        if (position.getY() + 150 < GridPosition.height) {
            this.position.setY(yInit + 2);
            picture.translate(0, this.position.getY() - yInit);
            ellipse.translate(0, this.position.getY() - yInit);

        }

    }


    public void jump() {


        BirdHandler birdHandler = new BirdHandler();
        KeyboardEvent spacePress = new KeyboardEvent();
        KeyboardEvent spaceRelease = new KeyboardEvent();

        birdHandler.setBird(this);

        spacePress.setKey(KeyboardEvent.KEY_SPACE);
        spacePress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        spaceRelease.setKey(KeyboardEvent.KEY_SPACE);
        spaceRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        Keyboard k = new Keyboard(birdHandler);

        k.addEventListener(spacePress);
        k.addEventListener(spaceRelease);

        if (timerStarted) {
            picture.load("resources/img/BirdUp.png");
            timer += 0.1;
            if (position.getY() > 0) {
                int yInit = position.getY();
                this.position.setY(yInit - 8);
                ellipse.translate(0, this.position.getY() - yInit);
                picture.translate(0, this.position.getY() - yInit);

            }

            if (timer > TIMER_MAX) {
                picture.load("resources/img/BirdDown.png");
                timerStarted = false;
                timer = 0;
            }
        }


    }
}


