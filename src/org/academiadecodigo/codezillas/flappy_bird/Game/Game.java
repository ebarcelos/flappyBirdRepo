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

     boolean firstRun = false;
     private Background background;
     private RunBird runBird;
     private RunObstacle runObstacle;

     public void init() {

         GridPosition grid = new GridPosition(1280, 720);
         grid.init();

         Sound music = new Sound("/resources/sound/music/colhao_colhao80kbps.wav");
         music.setLoop(5);

         background = new Background();
         background.initBackground();

         Menu menu = new Menu();
         menu.initMenu();

         while(!menu.hasFinished()) {
             System.out.println(menu.hasFinished());
         }

         runBird = new RunBird();
         runBird.start();

         runObstacle = new RunObstacle(runBird.birdHitbox());
         runObstacle.run();

     }
//        gameplay();

//
//    private void gameplay () {
//        try {
//            runBird = new RunBird();
//            Obstacle obstacle = ObstacleFactory.getNewObstacle();
//            Obstacle obstacleTwo = null;
//            runBird.start();
//            obstacle.init();
//
//            ObstacleCounter.growSize();
//            ObstacleCounter.showCounter();
//
//
//            while (true) {
//
//                Thread.sleep(5);
//
//                background.scroll();
//                obstacle.moveObstacle();
//
//                if (obstacle.hasPassedMiddle() && !firstRun) {
//                    obstacleTwo = ObstacleFactory.getNewObstacle();
//                    obstacleTwo.init();
//                    firstRun = true;
//                }
//                if (firstRun) {
//                    obstacleTwo.moveObstacle();
//                }
//
//                if (obstacle.hasPassedBird()) {
//                    ObstacleCounter.addCounter();
//                    obstacle = ObstacleFactory.getNewObstacle();
//                    obstacle.init();
//                }
//
//                if (firstRun && obstacleTwo.hasPassedBird()) {
//                    ObstacleCounter.addCounter();
//                    obstacleTwo = ObstacleFactory.getNewObstacle();
//                    obstacleTwo.init();
//                }
//
//                ObstacleCounter.showCounter();
//
//                if (obstacle.checkCollision(runBird.birdHitbox())) {
//
//                    GameOver gameOver = new GameOver();
//                    Sound sound = new Sound("/resources/sound/effects/dieballs.wav");
//                    sound.play();
//
//                    while(true){
//                        gameOver.draw();
//                        return;
//
//                    }
//
//                }
//
//
//            }
//        } catch (InterruptedException e) {
//         System.out.println("deu merda");
//     }
//
//
// }
}
