package org.academiadecodigo.codezillas.flappy_bird.menu;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu implements KeyboardHandler, MouseHandler {

    private static Picture picture;
    private static boolean hasFinished;
    private Keyboard keyboard = new Keyboard(this);
    private Mouse mouse = new Mouse(this);

    public Menu() {
        picture = new Picture(0, 0, "resources/img/Background/startMenu.jpg");
    }

    public void initMenu() {

        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
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

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println(mouseEvent.getX() + " " + mouseEvent.getY());
            picture.delete();
            hasFinished = true;
        System.out.println("working");
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
