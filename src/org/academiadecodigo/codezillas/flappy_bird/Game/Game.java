 package org.academiadecodigo.codezillas.flappy_bird.Game;

import org.academiadecodigo.codezillas.flappy_bird.GameObject.Bird.*;
import org.academiadecodigo.codezillas.flappy_bird.Position.GridPosition;
import org.academiadecodigo.codezillas.flappy_bird.GameObject.Obstacle.RunObstacle;
import org.academiadecodigo.codezillas.flappy_bird.GameObject.RunBackground;

public class Game {
    private Thread background;
    private Thread birdie;
    private Thread obs;

    public void init(){
        GridPosition grid = new GridPosition(1280, 720);
        grid.init();


        this.background = new Thread(new RunBackground());
        //background.start();

        //this.obs = new Thread(new RunObstacle());
        //obs.start();

        this.birdie = new Thread(new RunBird());
        birdie.start();

        start();

    }

    public void start(){
        try {
            while (true) {
                Thread.sleep(5);
                Thread.sleep(50);
                background.start();
            }
        } catch (InterruptedException e) {
            System.out.println("deu merda");
        }
    }
}
