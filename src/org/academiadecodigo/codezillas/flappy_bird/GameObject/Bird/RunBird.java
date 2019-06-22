package org.academiadecodigo.codezillas.flappy_bird.GameObject.Bird;

public class RunBird implements Runnable {

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
