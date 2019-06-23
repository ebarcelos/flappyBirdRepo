package org.academiadecodigo.codezillas.flappy_bird.GameObject.Bird;

public class RunBird implements Runnable {

    @Override
    public void run() {
        Bird bird = new Bird();
        bird.initBird();

        while (true) {
            bird.jump();
            bird.fall();
            bird.initBird();

            try {

                Thread.sleep(5);
                bird.initBird();
            } catch (InterruptedException e) {
                System.out.println("deu merda");
            }
        }
    }

}
