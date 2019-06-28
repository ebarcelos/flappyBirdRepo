package org.academiadecodigo.codezillas.flappy_bird.objects.obstacle;

import org.academiadecodigo.codezillas.flappy_bird.GameConfig;
import org.academiadecodigo.codezillas.flappy_bird.objects.score.Score;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedList;
import java.util.ListIterator;

public class RunObstacle extends Thread {

    private LinkedList<Movable> movables = new LinkedList<Movable>();
    private Rectangle targetHitbox;
    private static final int MIN_DIFFICULTY = 1;
    private static final int MAX_DIFFICULTY = 4;
    private static final int OBSTACLE_INCREASE_DELTA = 5;
    private int difficultyLevel;

    public RunObstacle(Rectangle targetHitbox) {
        this.targetHitbox = targetHitbox;
        difficultyLevel = MIN_DIFFICULTY;
    }

    @Override
    public void run() {
        //TODO: Print value to see if it's the intended value
        int spawnThreshold = GameConfig.SCREEN_WIDTH - (GameConfig.SCREEN_WIDTH / difficultyLevel);

        setup();

        while (true) {

            //TODO: Reimplement Thread.sleep invocation if game loop is too fast
            //TODO: Use a while loop with iterator
            ListIterator<Movable> it = movables.listIterator();

            while (it.hasNext()) {
                Movable movable = it.next();

                if (movable == null) {
                    continue;
                }

                movable.move();

                if (obstacleCleared(movable)) {
                    Score.increase();
                    //TODO: implement hide otherwise you'll have a compile error
                    movable.hide();
                    it.remove();
                    continue;
                }

                //TODO: Clean this
                //TODO: We don't know in how many iterations this will be true before the pipe
                //leaves the screen
                if (movable instanceof DoubleMovable) {
                    //TODO: Maybe have a set X threshold instead of a valid interval
                    if (movable.getPosition().getX() == spawnThreshold) {
                        spawnPipe(it);
                    }
                } else {
                    if (movable.getPosition().getX() + movable.getWidth() == spawnThreshold) {
                        spawnPipe(it);
                    }
                }

                if (movable.checkCollision(targetHitbox)) {
                    return;
                }

                increaseDifficulty();

                Score.render();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void setup() {
        Movable obj = ObstacleFactory.getNewObstacle();
        movables.add(obj);
        obj.init();

        Score.render();
    }

    private boolean obstacleCleared(Movable movable) {
        return movable.getPosition().getX() + movable.getWidth() < 0;
    }

    private void spawnPipe(ListIterator<Movable> it) {
        if (movables.size() > MAX_DIFFICULTY) {
            return;
        }

        Movable obj = ObstacleFactory.getNewObstacle();
        it.add(obj);
        obj.init();
    }

    private void increaseDifficulty() {
        if (difficultyLevel >= MAX_DIFFICULTY) {
            return;
        }

        difficultyLevel = Score.getCounter() / OBSTACLE_INCREASE_DELTA + 1;
    }
}
