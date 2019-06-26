package org.academiadecodigo.codezillas.flappy_bird.game;

import org.academiadecodigo.codezillas.flappy_bird.objects.Background;
import org.academiadecodigo.codezillas.flappy_bird.objects.bird.*;
import org.academiadecodigo.codezillas.flappy_bird.objects.obstacle.RunObstacle;
import org.academiadecodigo.codezillas.flappy_bird.objects.score.ObstacleCounter;
import org.academiadecodigo.codezillas.flappy_bird.menu.GameOver;
import org.academiadecodigo.codezillas.flappy_bird.menu.Menu;
import org.academiadecodigo.codezillas.flappy_bird.position.GridPosition;

public class Game {

    private Background background;
    private RunBird runBird;
    private RunObstacle runObstacle;
    private GameOver gameOver;

    public void init() {
        GridPosition grid = new GridPosition(1280, 720);
        grid.init();

        Sound music = new Sound("/resources/sound/music/colhao_colhao80kbps.wav");
        //music.setLoop(5);

        Menu menu = new Menu();
        menu.initMenu();

        while (!menu.hasFinished()) {
            System.out.println(); //DO NOTHING
        }


        while (true) {

            background = new Background();
            background.initBackground();

            runBird = new RunBird();
            runBird.start();

            ObstacleCounter.restartCounter();
            ObstacleCounter.showCounter();

            runObstacle = new RunObstacle(runBird.birdHitbox());
            runObstacle.run();

            gameOver = new GameOver();
            Sound sound = new Sound("/resources/sound/effects/dieballs.wav");
            sound.play();
            gameOver.initGameOver();

            while (!gameOver.hasRestartGame()) {
                System.out.println(); //DO NOTHING
            }
            if(gameOver.hasRestartGame()){
                gameOver.changeRestart();
            }
        }
    }
}
