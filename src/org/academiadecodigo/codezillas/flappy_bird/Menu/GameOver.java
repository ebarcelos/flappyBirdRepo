package org.academiadecodigo.codezillas.flappy_bird.Menu;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class GameOver {

    private static Picture picture;

    public GameOver() {
        picture = new Picture(0, 0, "resources/img/Background/endMenu.jpg");

    }

    public void draw(){
        picture.draw();
    }
}
