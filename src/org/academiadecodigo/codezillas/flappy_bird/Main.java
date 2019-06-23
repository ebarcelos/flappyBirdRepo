package org.academiadecodigo.codezillas.flappy_bird;

import org.academiadecodigo.codezillas.flappy_bird.Game.Game;
import org.academiadecodigo.codezillas.flappy_bird.GameObject.GameObject;
import org.academiadecodigo.codezillas.flappy_bird.GameObject.Obstacle.ObstacleFactory;
import org.academiadecodigo.codezillas.flappy_bird.Position.GridPosition;
import org.academiadecodigo.codezillas.flappy_bird.GameObject.Background;
import org.academiadecodigo.codezillas.flappy_bird.GameObject.Bird.RunBird;

public class Main {
    public static void main(String[] args) {

        Game engine = new Game();
        engine.init();

    }
}
