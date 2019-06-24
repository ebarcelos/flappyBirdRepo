package org.academiadecodigo.codezillas.flappy_bird.GameObject.Bird;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class RunBird extends Thread {

    private Bird bird;

    @Override
    public void run() {
        bird = new Bird(150, 129);
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

    public Rectangle birdHitbox(){
        return bird.getHitbox();
    }


}
