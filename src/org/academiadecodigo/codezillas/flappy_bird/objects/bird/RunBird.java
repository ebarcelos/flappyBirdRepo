package org.academiadecodigo.codezillas.flappy_bird.objects.bird;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class RunBird extends Thread {

    private Bird bird;

    public RunBird () {
        bird = new Bird(150, 129);
        bird.initBird();
    }

    @Override
    public void run () {

        try {
            while (true) {

                Thread.sleep(5);
                bird.jump();
                bird.fall();

            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public Rectangle birdHitbox(){
        return bird.getHitbox();
    }


}
