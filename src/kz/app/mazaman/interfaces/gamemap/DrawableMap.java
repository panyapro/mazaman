package kz.app.mazaman.interfaces.gamemap;

import java.awt.Component;
import kz.app.mazaman.abstracts.AbstractGameMap;

public interface DrawableMap {

    Component getMapComponent();

    AbstractGameMap getGameMap();

    boolean drawMap();

}
