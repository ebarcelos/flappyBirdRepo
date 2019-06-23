package org.academiadecodigo.codezillas.flappy_bird;

public class RunBackground extends Thread {

    @Override
    public void run() {
        Background background = new Background();
        background.initBackground();

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
