package org.academiadecodigo.codezillas.flappy_bird.objects.bird;

import org.academiadecodigo.codezillas.flappy_bird.position.GridPosition;
import org.academiadecodigo.codezillas.flappy_bird.position.Position;
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
    private Picture picture;
    private int birdWidth;
    private int birdHeight;
    private double timer;
    private static final double TIMER_MAX = 3;
    private boolean timerStarted;
    private boolean isJumping;

//    Rectangle hitbox1;
//    Rectangle hitbox2;
//    Rectangle hitbox3;

    public Bird(int birdWidth, int birdHeight) {
        this.birdWidth = birdWidth;
        this.birdHeight = birdHeight;
        position = new Position(100, (720 / 2) - (this.birdHeight / 2));
        hitbox = new Rectangle(position.getX(), position.getY(), this.birdWidth-20, this.birdHeight-20);

//        hitbox1 = new Rectangle(position.getX(), position.getY(), this.birdWidth-20, this.birdHeight/3);
//        hitbox2 = new Rectangle(position.getX(), position.getY() +  this.birdHeight/3, this.birdWidth-50, this.birdHeight/3);
//        hitbox3 = new Rectangle(position.getX()+20, position.getY() + 2*this.birdHeight/3, this.birdWidth-110, this.birdHeight/3);

        picture = new Picture(hitbox.getX(), hitbox.getY()-10, "resources/img/BirdDown.png");
    }

    public void initBird() {
//        hitbox1.draw();
//        hitbox2.draw();
//        hitbox3.draw();

        hitbox.draw();
        picture.draw();

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

        if (position.getY() + 135 < GridPosition.height) {
            this.position.setY(yInit + 2);
            hitbox.translate(0, this.position.getY() - yInit);
            picture.translate(0, this.position.getY() - yInit);
        }
    }

    public void jump() {
        if (timerStarted) {
            picture.load("resources/img/BirdUp.png");
            timer += 0.1;
            if (position.getY() > 0) {
                int yInit = position.getY();
                position.setY(yInit - 5);
                hitbox.translate(0, position.getY() - yInit);
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



