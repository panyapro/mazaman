package kz.app.mazaman.interfaces.gamemap;

import kz.app.mazaman.abstracts.AbstractGameObject;
import kz.app.mazaman.abstracts.AbstractMovingObject;
import kz.app.mazaman.enums.ActionResult;
import kz.app.mazaman.enums.GameObjectType;
import kz.app.mazaman.enums.MovingDirection;
import kz.app.mazaman.interfaces.collections.GameCollection;
import kz.app.mazaman.objects.Coordinate;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

public class MapCollection implements GameCollection {// объекты для карты, которые умеют уведомлять всех слушателей о своих ходах

    private HashMap<Coordinate, AbstractGameObject> gameObjects = new HashMap<>();// хранит все объекты с доступом по координатам
    private EnumMap<GameObjectType, ArrayList<AbstractGameObject>> typeObjects = new EnumMap<>(GameObjectType.class); // хранит список объектов для каждого типа

    @Override
    public List<AbstractGameObject> getAllGameObjects() {
        return new ArrayList(gameObjects.values());// ! узкое место - каждый раз создается новая коллекция
    }

    @Override
    public List<AbstractGameObject> getGameObjects(GameObjectType type) {
        return typeObjects.get(type);
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(Coordinate coordinate) {
        return gameObjects.get(coordinate);
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(int x, int y) {
        return gameObjects.get(new Coordinate(x, y));
    }

    @Override
    public void addGameObject(AbstractGameObject gameObject) {

        ArrayList<AbstractGameObject> tmpList = typeObjects.get(gameObject.getType());

        if (tmpList == null) {
            tmpList = new ArrayList<>();
        }

        tmpList.add(gameObject);

        gameObjects.put(gameObject.getCoordinate(), gameObject);
        typeObjects.put(gameObject.getType(), tmpList);

    }

    @Override
    public void moveObject(MovingDirection direction, GameObjectType gameObjectType) {
        for (AbstractGameObject gameObject : this.getGameObjects(gameObjectType)) {
            if (gameObject instanceof AbstractMovingObject) {// дорогостоящая операция - instanceof
                AbstractMovingObject movingObject = (AbstractMovingObject) gameObject;

                Coordinate newCoordinate = getNewCoordinate(direction, movingObject);

                AbstractGameObject objectInNewCoordinate = getObjectByCoordinate(newCoordinate);

                ActionResult actionResult = movingObject.moveToObject(direction, objectInNewCoordinate);

                switch (actionResult) {
                    case MOVE: {
                        swapObjects(movingObject, objectInNewCoordinate);
                        break;
                    }
                }


            }
        }
    }

    private void swapObjects(AbstractGameObject obj1, AbstractGameObject obj2) {

        swapCoordinates(obj1, obj2);

        gameObjects.put(obj1.getCoordinate(), obj1);
        gameObjects.put(obj2.getCoordinate(), obj2);

    }

    private void swapCoordinates(AbstractGameObject obj1, AbstractGameObject obj2) {
        Coordinate tmpCoordinate = obj1.getCoordinate();
        obj1.setCoordinate(obj2.getCoordinate());
        obj2.setCoordinate(tmpCoordinate);
    }

    private Coordinate getNewCoordinate(MovingDirection direction, AbstractMovingObject movingObject) {

        // берем текущие координаты объекта, которые нужно передвинуть (индексы начинаются с нуля)
        int x = movingObject.getCoordinate().getX();
        int y = movingObject.getCoordinate().getY();


        Coordinate newCoordinate = new Coordinate(x, y);


        switch (direction) {// определяем, в каком направлении нужно двигаться
            case UP: {
                newCoordinate.setY(y - movingObject.getStep());
                break;
            }
            case DOWN: {
                newCoordinate.setY(y + movingObject.getStep());
                break;
            }
            case LEFT: {
                newCoordinate.setX(x - movingObject.getStep());
                break;
            }
            case RIGHT: {
                newCoordinate.setX(x + movingObject.getStep());
                break;
            }
        }

        return newCoordinate;
    }
}
