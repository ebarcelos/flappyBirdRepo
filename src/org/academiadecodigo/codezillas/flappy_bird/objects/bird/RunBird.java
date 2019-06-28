package org.academiadecodigo.codezillas.flappy_bird.objects.bird;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class RunBird extends Thread {

    private Bird bird;

    public RunBird () {
        //TODO: Magic numbers
        bird = new Bird(150, 129);
        bird.initBird();
    }

    @Override
    public void run () {
        try {
            while (true) {
                //TODO: oi
                Thread.sleep(5);
                bird.jump();
                bird.fall();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Rectangle birdHitbox(){
        return bird.getHitbox();
    }
}
