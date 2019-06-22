package org.academiadecodigo.codezillas.flappy_bird;

import org.academiadecodigo.codezillas.flappy_bird.Bird.Bird;

public class RunBird extends Thread {

    @Override
    public void run() {
        Bird bird = new Bird();
        bird.initBird();

        try {
            while (true) {

                Thread.sleep(5);
                bird.jump();
                bird.fall();

            }
        } catch (InterruptedException e) {
            System.out.println("deu merda");
        }
    }
}
