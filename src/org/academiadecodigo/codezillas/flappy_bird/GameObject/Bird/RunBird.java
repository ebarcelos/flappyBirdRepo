package org.academiadecodigo.codezillas.flappy_bird.GameObject.Bird;

import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class RunBird extends Thread {

    private Bird bird;
    @Override
    public void run() {
        this.bird = new Bird();
        bird.initBird();

        try {
            while (true) {

                Thread.sleep(5);
                bird.jump();
                bird.fall();
                //bird.initBird();
            }
        } catch (InterruptedException e) {
            System.out.println("deu merda");
        }
    }

}
