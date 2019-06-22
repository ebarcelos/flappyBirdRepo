 package org.academiadecodigo.codezillas.flappy_bird.Game;

import org.academiadecodigo.codezillas.flappy_bird.GameObject.Background;
import org.academiadecodigo.codezillas.flappy_bird.GameObject.Bird.*;
import org.academiadecodigo.codezillas.flappy_bird.Position.GridPosition;

public class Game {
    private Background background;
    private RunBird bird;

    public void init(){
        GridPosition grid = new GridPosition(1280, 720);
        grid.init();

        this.background = new Background();
        background.initBackground();

        this.bird = new RunBird();

        bird.run();

    }

    public void start(){
        try {
            while (true) {
                Thread.sleep(5);
                Thread.sleep(50);
                background.scroll();
            }
        } catch (InterruptedException e) {
            System.out.println("deu merda");
        }
    }
}
