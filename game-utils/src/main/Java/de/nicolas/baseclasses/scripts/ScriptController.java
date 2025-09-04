package de.nicolas.baseclasses.scripts;

import com.badlogic.gdx.utils.Array;
import de.nicolas.baseclasses.EntityBase;

public class ScriptController {

    // -- Attribute --
    private final Array<EntityScript<EntityBase>> scripts = new Array<>();
    private final EntityBase entity;

    // -- Konstruktor --
    public ScriptController(EntityBase entity){
        this. entity = entity;
    }

    // -- öffentliche Methoden --
    public void update(float delta){
        for (int i = 0; i < scripts.size; i++){
            EntityScript script = scripts.get(i);

            if(script.isFinished()){
                scripts.removeIndex(i);
            }
            else {
                script.update(delta);
            }
        }
    }

    public void addScript(EntityScript<EntityBase> toAdd){
        scripts.add(toAdd);
        toAdd.added(entity);
    }

    public void removeScript(EntityScript<EntityBase> toRemove){
        scripts.removeValue(toRemove, true);
        toRemove.removed(entity);
    }
}
