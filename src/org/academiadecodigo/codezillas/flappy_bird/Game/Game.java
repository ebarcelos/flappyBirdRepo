 package org.academiadecodigo.codezillas.flappy_bird.Game;

import org.academiadecodigo.codezillas.flappy_bird.GameObject.Background;
import org.academiadecodigo.codezillas.flappy_bird.GameObject.Bird.*;
import org.academiadecodigo.codezillas.flappy_bird.GameObject.Obstacle.Obstacle;
import org.academiadecodigo.codezillas.flappy_bird.GameObject.Obstacle.RunObstacle;
import org.academiadecodigo.codezillas.flappy_bird.GameObject.PointCounter.ObstacleCounter;
import org.academiadecodigo.codezillas.flappy_bird.GameObject.Obstacle.ObstacleFactory;
import org.academiadecodigo.codezillas.flappy_bird.Menu.GameOver;
import org.academiadecodigo.codezillas.flappy_bird.Menu.Menu;
import org.academiadecodigo.codezillas.flappy_bird.Position.GridPosition;

 public class Game {

     private Background background;
     private RunBird runBird;
     private RunObstacle runObstacle;
     private GameOver gameOver;

     public void init() {
         GridPosition grid = new GridPosition(1280, 720);
         grid.init();

         Sound music = new Sound("/resources/sound/music/colhao_colhao80kbps.wav");
         music.setLoop(5);

         Menu menu = new Menu();
         menu.initMenu();

         while (!menu.hasFinished()) {
             System.out.println(menu.hasFinished());
         }


         while (true) {

             background = new Background();
             background.initBackground();

             runBird = new RunBird();
             runBird.start();

             ObstacleCounter.restartCounter();

             runObstacle = new RunObstacle(runBird.birdHitbox());
             runObstacle.run();

             gameOver = new GameOver();
             Sound sound = new Sound("/resources/sound/effects/dieballs.wav");
             sound.play();
             gameOver.initGameOver();

             while (!gameOver.hasRestartGame()) {
                 System.out.println(gameOver.hasRestartGame());
             }


         }
     }
}
