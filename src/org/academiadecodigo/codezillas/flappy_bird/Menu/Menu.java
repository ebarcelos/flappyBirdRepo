package org.academiadecodigo.codezillas.flappy_bird.Menu;

import org.academiadecodigo.codezillas.flappy_bird.Position.Position;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.swing.Timer;


public class Menu implements KeyboardHandler {

    private static Picture picture;
    private static boolean hasFinished;
    private Keyboard keyboard = new Keyboard(this);


    public Menu() {
        picture = new Picture(0, 0, "resources/img/Background/startMenu.jpg");

    }

    public void initMenu() {


        KeyboardEvent spacePress = new KeyboardEvent();

        spacePress.setKey(KeyboardEvent.KEY_SPACE);
        spacePress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        keyboard.addEventListener(spacePress);

        picture.draw();

    }

    public boolean hasFinished() {
        return hasFinished;
    }

    public void keyPressed(KeyboardEvent var1) {

        hasFinished=true;
        picture.delete();

    }

    public void keyReleased(KeyboardEvent var1) {

    }
}
