package org.academiadecodigo.codezillas.flappy_bird.game;

import org.academiadecodigo.codezillas.flappy_bird.GameConfig;
import org.academiadecodigo.codezillas.flappy_bird.objects.Background;
import org.academiadecodigo.codezillas.flappy_bird.objects.RunBackground;
import org.academiadecodigo.codezillas.flappy_bird.objects.bird.*;
import org.academiadecodigo.codezillas.flappy_bird.objects.obstacle.RunObstacle;
import org.academiadecodigo.codezillas.flappy_bird.objects.score.Score;
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

        GridPosition grid = new GridPosition(GameConfig.SCREEN_WIDTH, GameConfig.SCREEN_HEIGHT);

        Sound music = new Sound(GameConfig.BGM);
        music.play();

        Menu menu = new Menu();
        menu.initMenu();

        while (!menu.hasFinished()) {
            try {
                Thread.sleep(0); //DO NOTHING
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        while (true) {
//            runBackground.run();
            //background.initBackground();
            runBird = new RunBird();
            runBird.start();

            Score.restartCounter();
            Score.render();

            runObstacle = new RunObstacle(runBird.birdHitbox());
            runObstacle.run();

            gameOver = new GameOver();
            Sound sound = new Sound(GameConfig.LOSS_SOUND_EFFECT);
            sound.play();
            gameOver.initGameOver();

            //TODO: find better name for restart
            while (!gameOver.hasRestartedGame()) {
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(gameOver.hasRestartedGame()){
                //TODO: restart should hide ALL pipes, hitboxes, and birds
                //TODO: restart should CLEAR the obstacles linkedList
                gameOver.changeRestart();
            }
        }
    }
}
