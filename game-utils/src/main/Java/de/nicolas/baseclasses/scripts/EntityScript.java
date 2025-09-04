package de.nicolas.baseclasses.scripts;

import de.nicolas.baseclasses.EntityBase;

public interface EntityScript <T extends EntityBase> {

    void added(T entity);

    void removed(T entity);

    void update(float delta);

    boolean isFinished();
}
