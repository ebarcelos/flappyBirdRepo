package org.academiadecodigo.codezillas.flappy_bird.Position;

import org.academiadecodigo.codezillas.flappy_bird.Bird.Bird;

import java.awt.*;

public class ColisionDetection {

    private Rectangle targetHitbox;
    private Rectangle hitbox;


    public ColisionDetection(Bird target){

        targetHitbox = target.getHitbox();

    }

    public void checkCollision(){

        if(hitbox.intersects(targetHitbox)){
            System.out.println("yes");
        }

    }


}
