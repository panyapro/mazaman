package kz.app.mazaman.interfaces.collections;

import kz.app.mazaman.abstracts.AbstractGameObject;
import kz.app.mazaman.enums.GameObjectType;
import kz.app.mazaman.enums.MovingDirection;
import kz.app.mazaman.objects.Coordinate;

import java.util.List;

public interface GameCollection{

    AbstractGameObject getObjectByCoordinate(Coordinate coordinate);

    AbstractGameObject getObjectByCoordinate(int x, int y);

    void addGameObject(AbstractGameObject gameObject);

    List<AbstractGameObject> getAllGameObjects();

    List<AbstractGameObject> getGameObjects(GameObjectType type);

    void moveObject(MovingDirection direction, GameObjectType gameObjectType);

}
