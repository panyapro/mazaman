package kz.app.mazaman.interfaces.gameobjects;

import kz.app.mazaman.abstracts.AbstractGameObject;
import kz.app.mazaman.enums.ActionResult;
import kz.app.mazaman.enums.MovingDirection;

/**
 *
 * поведение для всех движущихся объектов:
 */
public interface MovingObject extends StaticObject{

    ActionResult moveToObject(MovingDirection direction, AbstractGameObject gameObject);

    int getStep();

}
