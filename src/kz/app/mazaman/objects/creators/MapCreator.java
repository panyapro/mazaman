package kz.app.mazaman.objects.creators;


import kz.app.mazaman.abstracts.AbstractGameMap;
import kz.app.mazaman.enums.LocationType;
import kz.app.mazaman.interfaces.collections.GameCollection;
import kz.app.mazaman.objects.maps.FSGameMap;

public class MapCreator {

    private static MapCreator instance;

    public static MapCreator getInstance() {
        if (instance == null) {
            instance = new MapCreator();
        }
        return instance;
    }

    public AbstractGameMap createMap(LocationType type, GameCollection collection) {
        AbstractGameMap obj = null;

        switch (type) {
            case FS: {
                obj = new FSGameMap(collection);
                break;
            }
            case DB: {

                break;
            }
            default:
                throw new IllegalArgumentException("Can't create map type: " + type);

        }

        return obj;
    }
}
