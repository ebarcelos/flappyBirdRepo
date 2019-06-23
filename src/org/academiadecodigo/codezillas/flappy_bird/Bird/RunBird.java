package org.academiadecodigo.codezillas.flappy_bird.Bird;

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
                bird.initBird();
            }
        } catch (InterruptedException e) {
            System.out.println("deu merda");
        }
    }
}
