package org.academiadecodigo.codezillas.flappy_bird.objects;

public class RunBackground implements Runnable {

    @Override
    public void run() {
        Background background = new Background();
        background.initBackground();

        while (true) {

            background.scroll();

            try {

                Thread.sleep(20);

            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
