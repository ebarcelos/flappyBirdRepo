package org.academiadecodigo.codezillas.flappy_bird.menu;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameOver implements KeyboardHandler {

    private static Picture picture;
    private static boolean restartGame;
    private Keyboard keyboard = new Keyboard(this);

    public GameOver() {
        picture = new Picture(0, 0, "resources/img/Background/endMenu.png");
    }

    public void initGameOver(){
        KeyboardEvent rKeyPress = new KeyboardEvent();

        rKeyPress.setKey(KeyboardEvent.KEY_R);
        rKeyPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(rKeyPress);
        picture.draw();
    }

    public boolean hasRestartedGame() {
        return restartGame;
    }

    public void keyPressed(KeyboardEvent var1) {
        picture.delete();
        restartGame = true;
    }

    public void keyReleased(KeyboardEvent var1) {

    }
    public void changeRestart(){
        restartGame = false;
    }

}
