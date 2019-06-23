package org.academiadecodigo.codezillas.flappy_bird.Bird;

import java.awt.*;

public class RunBird extends Thread {

    Bird bird = new Bird(150, 150);

    @Override
    public void run() {
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

    public Rectangle birdHitbox(){
        return bird.getHitbox();
    }



}
