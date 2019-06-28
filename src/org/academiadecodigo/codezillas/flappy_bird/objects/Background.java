package org.academiadecodigo.codezillas.flappy_bird.objects;
import org.academiadecodigo.codezillas.flappy_bird.GameConfig;
import org.academiadecodigo.codezillas.flappy_bird.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {
    private GridPosition position;
    private Picture picture;

    public Background() {
        this.position = new GridPosition(0, 0);
        this.picture = new Picture(0, 0, GameConfig.BACKGROUND_IMAGE);
    }

    public void initBackground() {
        this.picture.draw();
    }

    public void scroll() {
        int xInit = this.position.getX();
        this.position.setX(xInit - 1);

        if (position.getX() <= -GameConfig.SCREEN_WIDTH) {
            this.position.setX(0);
            picture.translate(0,0);
        }

        picture.translate(this.position.getX() - xInit, 0);
    }
}

