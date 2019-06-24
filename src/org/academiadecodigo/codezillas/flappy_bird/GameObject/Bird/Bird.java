package org.academiadecodigo.codezillas.flappy_bird.GameObject.Bird;

import org.academiadecodigo.codezillas.flappy_bird.Position.GridPosition;
import org.academiadecodigo.codezillas.flappy_bird.Position.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Bird implements KeyboardHandler {

    private Position position;
    private Rectangle hitbox;
//    private Picture picture;
    private int birdWidth;
    private int birdHeight;

    private double timer;
    private static final double TIMER_MAX = 3;

    private boolean timerStarted;
    private boolean isJumping;

    public Bird(int birdWidth, int birdHeight) {
        this.birdWidth = birdWidth;
        this.birdHeight = birdHeight;
        position = new Position(100, (720 / 2) - (this.birdHeight / 2));
        hitbox = new Rectangle(position.getX(), position.getY(), this.birdWidth, this.birdHeight);
//        picture = new Picture(hitbox.getX(), hitbox.getY(), "resources/img/BirdDown.png");
//        picture.grow(-24,-11);
    }

    public void initBird() {
        hitbox.setColor(Color.BLACK);
        hitbox.fill();
//        picture.draw();
        KeyboardEvent spacePress = new KeyboardEvent();
        KeyboardEvent spaceRelease = new KeyboardEvent();

        spacePress.setKey(KeyboardEvent.KEY_SPACE);
        spacePress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        spaceRelease.setKey(KeyboardEvent.KEY_SPACE);
        spaceRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        Keyboard k = new Keyboard(this);

        k.addEventListener(spacePress);
        k.addEventListener(spaceRelease);
    }

    public void keyPressed(KeyboardEvent var1) {

        if (!isJumping()) {
            startTimer();
            setJumptrue();
            initBird();
        }
    }

    public void keyReleased(KeyboardEvent var1) {
        setJumpfalse();
    }

    public Rectangle getHitbox() {
        return hitbox;
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

        if (position.getY() + 200 < GridPosition.height) {
            this.position.setY(yInit + 2);
//            picture.translate(0, this.position.getY() - yInit);
            hitbox.translate(0, this.position.getY() - yInit);
        }
    }


    public void jump() {

        if (timerStarted) {
//            picture.load("resources/img/BirdUp.png");
            timer += 0.1;
            if (position.getY() > 0) {
                int yInit = position.getY();
                position.setY(yInit - 5);
                hitbox.translate(0, position.getY() - yInit);
 //               picture.translate(0, this.position.getY() - yInit);
            }

            if (timer > TIMER_MAX) {
//                picture.load("resources/img/BirdDown.png");
                timerStarted = false;
                timer = 0;
            }
        }

    }

}



