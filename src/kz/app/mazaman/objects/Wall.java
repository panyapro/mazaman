package kz.app.mazaman.objects;


import kz.app.mazaman.abstracts.AbstractGameObject;
import kz.app.mazaman.enums.GameObjectType;

/**
 * класс отвечает за работу объекта WALL
 */
public class Wall extends AbstractGameObject {

    public Wall(Coordinate coordinate) {
        super.setType(GameObjectType.WALL);
        super.setCoordinate(coordinate);

        super.setIcon(getImageIcon("/kz/app/mazaman/images/wall.png"));

    }
}
