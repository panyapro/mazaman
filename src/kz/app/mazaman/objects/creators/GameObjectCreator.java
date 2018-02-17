package kz.app.mazaman.objects.creators;


import kz.app.mazaman.abstracts.AbstractGameObject;
import kz.app.mazaman.enums.GameObjectType;
import kz.app.mazaman.objects.*;

public class GameObjectCreator {

    private static GameObjectCreator instance;

    public static GameObjectCreator getInstance() {
        if (instance == null) {
            instance = new GameObjectCreator();
        }
        return instance;
    }

    private GameObjectCreator() {
    }

    public AbstractGameObject createObject(GameObjectType type, Coordinate coordinate) {
        AbstractGameObject obj = null;

        switch (type) {
            case NOTHING: {
                obj = new Nothing(coordinate);
                break;
            }
            case WALL: {
                obj = new Wall(coordinate);
                break;
            }
            case MONSTER: {
                obj = new Monster(coordinate);
                break;
            }
            case TREASURE: {
                obj = new Treasure(coordinate);
                break;
            }
            case EXIT: {
                obj = new Exit(coordinate);
                break;
            }

            case MAZAMAN: {
                obj = new MazaMan(coordinate);
                break;
            }

            default:
                throw new IllegalArgumentException("Can't create object type: " + type);

        }

        return obj;
    }
}
