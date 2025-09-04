package de.nicolas.baseclasses.scripts;

import de.nicolas.baseclasses.EntityBase;

public abstract class EntityScriptBase <T extends EntityBase> implements EntityScript<T> {

    // -- Attribute --
    private boolean finished;

    protected T entity;

    // -- öffentliche Methoden --
    @Override
    public void added(T entity) {
        this.entity = entity;
    }

    @Override
    public void removed(T entity) {
        this.entity = null;
    }

    @Override
    public boolean isFinished() {
        return finished;
    }

    protected void finished() {
        finished = true;
    }
}
