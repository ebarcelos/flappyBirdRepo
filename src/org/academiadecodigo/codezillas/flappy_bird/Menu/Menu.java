package org.academiadecodigo.codezillas.flappy_bird.Menu;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

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
        picture.delete();
        hasFinished = true;
    }

    public void keyReleased(KeyboardEvent var1) {}
}
