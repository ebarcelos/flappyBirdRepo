package org.academiadecodigo.codezillas.flappy_bird.Position;

public class Position extends GridPosition {

    public Position(int X, int Y) {
        setX(X);
        setY(Y);
    }

    public Position(int x1, int y1, int x2, int y2) {
        setObstacleX1(x1);
        setObstacleY1(y1);
        setObstacleX2(x2);
        setObstacleY2(y2);
    }
}
