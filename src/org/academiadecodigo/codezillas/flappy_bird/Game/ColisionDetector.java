package org.academiadecodigo.codezillas.flappy_bird.Game;

import org.academiadecodigo.codezillas.flappy_bird.GameObject.GameObject;

public class ColisionDetector {

    private GameObject[] gameObjects;

    public ColisionDetector(GameObject[] gameObjects){
        this.gameObjects = gameObjects;
    }
}
