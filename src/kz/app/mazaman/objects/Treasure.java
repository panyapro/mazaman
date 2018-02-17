package kz.app.mazaman.objects;


import kz.app.mazaman.abstracts.AbstractGameObject;
import kz.app.mazaman.enums.GameObjectType;

/**
 * класс отвечает за работу объекта TREASURE
 */
public class Treasure extends AbstractGameObject {

    public Treasure(Coordinate coordinate) {
        super.setType(GameObjectType.TREASURE);
        super.setCoordinate(coordinate);
        super.setIcon(getImageIcon("/kz/app/mazaman/images/gold.png"));
    }


    private int score = 5;// каждое сокровище будет давать 5 очков игроку

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
