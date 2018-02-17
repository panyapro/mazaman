package kz.app.mazaman.objects;


import kz.app.mazaman.abstracts.AbstractMovingObject;
import kz.app.mazaman.enums.GameObjectType;
import kz.app.mazaman.enums.MovingDirection;

/**
 * класс отвечает за работу объекта GOLDMAN - главный персонаж игры
 */
public class MazaMan extends AbstractMovingObject {

    private int totalScore = 0;// кол-во очков, собранных игроком
    private int turnsNumber = 0;// кол-во сделанных ходов

    public MazaMan(Coordinate coordinate) {
        super.setType(GameObjectType.MAZAMAN);
        super.setCoordinate(coordinate);
        super.setIcon(getImageIcon("/kz/app/mazaman/images/goldman_up.png"));
    }

    public void addSTotalcore(int score) {
        this.totalScore += score;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getTurnsNumber() {
        return turnsNumber;
    }

    public void setTurnsNumber(int turnsNumber) {
        this.turnsNumber = turnsNumber;
    }

    @Override
    public void changeIcon(MovingDirection direction) {
        switch (direction) {
            case DOWN:
                super.setIcon(getImageIcon("/kz/app/mazaman/images/goldman_down.png"));
                break;
            case LEFT:
                super.setIcon(getImageIcon("/kz/app/mazaman/images/goldman_left.png"));
                break;
            case RIGHT:
                super.setIcon(getImageIcon("/kz/app/mazaman/images/goldman_right.png"));
                break;
            case UP:
                super.setIcon(getImageIcon("/kz/app/mazaman/images/goldman_up.png"));
                break;
        }
    }


}
