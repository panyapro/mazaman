/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.app.mazaman.interfaces.gameobjects;

import kz.app.mazaman.objects.Coordinate;
import javax.swing.ImageIcon;
import kz.app.mazaman.enums.GameObjectType;

/**
 *
 * @author Tim
 */
public interface StaticObject {

    // объект должен иметь иконку
    ImageIcon getIcon();

    // координаты
    Coordinate getCoordinate();

    // тип объекта
    GameObjectType getType();


}
