package de.nicolas.shapes;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import de.nicolas.Validate;

public class RectangleUtils {

    // -- Konstruktor --
    private RectangleUtils(){}

    // -- öffentliche Methoden --
    public static Vector2 getBottomLeft(Rectangle rect){
        Validate.notNull(rect);
        return new Vector2(rect.x, rect.y);
    }

    public static Vector2 getBottomRight( Rectangle rect){
        Validate.notNull(rect);
        return new Vector2(rect.x + rect.width, rect.y);
    }

    public static Vector2 getTopLeft(Rectangle rect){
        Validate.notNull(rect);
        return new Vector2(rect.x, rect.y + rect.height);
    }

    public static Vector2 getTopRight(Rectangle rect){
        Validate.notNull(rect);
        return new Vector2(rect.x + rect.width, rect.y + rect.height);
    }
}
