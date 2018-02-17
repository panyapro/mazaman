package kz.app.mazaman.objects;


import kz.app.mazaman.abstracts.AbstractMovingObject;
import kz.app.mazaman.enums.GameObjectType;
import kz.app.mazaman.enums.MovingDirection;
import kz.app.mazaman.objects.Coordinate;

/**
 * класс отвечает за работу объекта MONSTER
 */
public class Monster extends AbstractMovingObject {

    public Monster(Coordinate coordinate) {
        super.setType(GameObjectType.MONSTER);
        super.setCoordinate(coordinate);

        super.setIcon(getImageIcon("/kz/app/mazaman/images/monster_up.jpg"));// иконку по-умолчанию (можно сделать реализацию случайного выбора иконки)

    }

    @Override
    public void changeIcon(MovingDirection direction) {
        switch (direction) {
            case DOWN:
                super.setIcon(getImageIcon("/kz/app/mazaman/images/monster_down.jpg"));
                break;
            case LEFT:
                super.setIcon(getImageIcon("/kz/app/mazaman/images/monster_right.jpg"));
                break;
            case RIGHT:
                super.setIcon(getImageIcon("/kz/app/mazaman/images/monster_right.jpg"));
                break;
            case UP:
                super.setIcon(getImageIcon("/kz/app/mazaman/images/monster_up.jpg"));
                break;
        }
    }




}
