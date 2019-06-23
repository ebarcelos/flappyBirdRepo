package org.academiadecodigo.codezillas.flappy_bird.GameObject.Obstacle;

import org.academiadecodigo.codezillas.flappy_bird.GameObject.GameObject;

public class RunObstacle extends Thread {

    private GameObject[] obstacles = new GameObject[2];

    @Override
    public void run() {
        obstacles[0] = ObstacleFactory.getNewObstacle();

        try {
            while (true) {
                Thread.sleep(5);

                for ( int i = 0; i < obstacles.length; i++) {

                    if (obstacles[i] != null) {
                        obstacles[i].moveObstacle();

                        if (obstacles[i].hasPassedBird()) {
                            obstacles[i] = ObstacleFactory.getNewObstacle();
                            obstacles[i].init();
                        }

                        if (obstacles[i].hasPassedMiddle()){
                            fillObstacles();
                        }
                    }
                }

            }
        } catch (InterruptedException e) {
            System.out.println("deu merda no obstacle");
        }
    }

    public void fillObstacles() {
        for (int i=0; i<obstacles.length; i++) {
            if (obstacles[i] == null) {
                obstacles[i] = ObstacleFactory.getNewObstacle();
            }
        }
    }

    public int getTopLowY(){
        //return obstacle.getTopObsLowestY();
        return 0;
    }


}
