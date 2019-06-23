package org.academiadecodigo.codezillas.flappy_bird;

import org.academiadecodigo.codezillas.flappy_bird.Bird.RunBird;
import org.academiadecodigo.codezillas.flappy_bird.Position.GridPosition;

//test
public class Main {
    public static void main(String[] args) {

        GridPosition grid = new GridPosition(1280, 720);
        grid.init();

        Sound2 dieballs = new Sound2("/resources/surfin_bird80kbps.wav");
        dieballs.play();

        Background background = new Background();
        background.initBackground();

        RunBird runBird = new RunBird();
        runBird.start();

        RunObstacle runObstacle = new RunObstacle();
        runObstacle.start();

        Menu menu = new Menu();
        menu.initMenu();

        try {
            while (true) {

                Thread.sleep(50);
                background.scroll();
            }
        } catch (InterruptedException e) {
            System.out.println("deu merda");
        }

    }
}
