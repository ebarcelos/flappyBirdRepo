package org.academiadecodigo.codezillas.flappy_bird.objects;

public class RunBackground extends Thread {

    private Background background;

    public RunBackground() {
    }

    @Override
    public void run() {
        background = new Background();
        background.initBackground();

        try {
            while (true) {
                Thread.sleep(50);
                background.scroll();

            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
