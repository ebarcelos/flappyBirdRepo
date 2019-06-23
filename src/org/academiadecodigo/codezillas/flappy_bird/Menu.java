package org.academiadecodigo.codezillas.flappy_bird;

import org.academiadecodigo.codezillas.flappy_bird.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {

    private Position position;
    private Picture picture;
    private Timer timer;

    ActionListener taskPerformer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            picture.delete();
        }
    };

    public Menu() {
        this.position = new Position(0, 0);
        this.picture = new Picture(0, 0, "resources/maxresdefault.jpg");

    }

    public void initMenu() {

        timer = new Timer(5000, taskPerformer);
        timer.setRepeats(false);
        timer.start();

        this.picture.draw();
    }
}
