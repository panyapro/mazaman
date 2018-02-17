package kz.app.mazaman.objects;


import kz.app.mazaman.abstracts.AbstractGameObject;
import kz.app.mazaman.enums.GameObjectType;
import kz.app.mazaman.objects.Coordinate;

/**
 * класс отвечает за работу объекта NOTHING (т.е. пустоту на карте)
 */
public class Nothing extends AbstractGameObject {

    public Nothing(Coordinate coordinate) {
        super.setType(GameObjectType.NOTHING);
        super.setCoordinate(coordinate);
        super.setIcon(null);

    }
}
