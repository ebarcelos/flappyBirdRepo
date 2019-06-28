package org.academiadecodigo.codezillas.flappy_bird.objects;

import org.academiadecodigo.codezillas.flappy_bird.GameConfig;

public class RunBackground extends Thread {

    @Override
    public void run() {
        Background background = new Background();
        background.initBackground();

        try {
            while (true) {
                Thread.sleep(GameConfig.SCREEN_SCROLL_DELAY);
                background.scroll();

            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
