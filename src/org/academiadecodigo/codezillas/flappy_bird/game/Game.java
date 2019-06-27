package org.academiadecodigo.codezillas.flappy_bird.game;

import org.academiadecodigo.codezillas.flappy_bird.objects.Background;
import org.academiadecodigo.codezillas.flappy_bird.objects.RunBackground;
import org.academiadecodigo.codezillas.flappy_bird.objects.bird.*;
import org.academiadecodigo.codezillas.flappy_bird.objects.obstacle.RunObstacle;
import org.academiadecodigo.codezillas.flappy_bird.objects.score.ObstacleCounter;
import org.academiadecodigo.codezillas.flappy_bird.menu.GameOver;
import org.academiadecodigo.codezillas.flappy_bird.menu.Menu;
import org.academiadecodigo.codezillas.flappy_bird.position.GridPosition;

public class Game {
    private Background background;
    private RunBackground runBackground = new RunBackground();
    private RunBird runBird;
    private RunObstacle runObstacle;
    private GameOver gameOver;

    public void init() {
//        background = new Background();
//        runBackground.run();

        GridPosition grid = new GridPosition(1280, 720);
        grid.init();

        Sound music = new Sound("/resources/sound/music/colhao_colhao80kbps.wav");

        Menu menu = new Menu();
        menu.initMenu();

        while (!menu.hasFinished()) {
            System.out.println(); //DO NOTHING
        }


        while (true) {
//            runBackground.run();
            //background.initBackground();
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

            while (!gameOver.hasRestartedGame()) {
                System.out.println(); //DO NOTHING
            }
            if(gameOver.hasRestartedGame()){
                gameOver.changeRestart();
            }
        }
    }
}
