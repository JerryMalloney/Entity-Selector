package scripts.entityselector.finders;

import org.tribot.api.interfaces.Clickable07;
import org.tribot.api.interfaces.Positionable;
import org.tribot.api.util.Sorting;
import org.tribot.api2007.Player;

/**
 * @author Laniax
 */
public abstract class SortableFinder<T extends Clickable07, S> extends Finder<T, S> {

    private boolean sortAscending;
    private Positionable sortPositionable;

    /**
     * {@link Sorting#sortByDistance(Positionable[], Positionable, boolean)}
     *
     * Defaults to Player.getPosition() and true (ascending).
     */
    @SuppressWarnings("unchecked")
    public S sortByDistance() {
        sortByDistance(true);
        return (S)this;
    }

    /**
     * {@link Sorting#sortByDistance(Positionable[], Positionable, boolean)}
     *
     * Defaults to Player.getPosition().
     */
    @SuppressWarnings("unchecked")
    public S sortByDistance(boolean ascending) {
        setSortParameters(Player.getPosition(), ascending);
        return (S)this;
    }

    /**
     * {@link Sorting#sortByDistance(Positionable[], Positionable, boolean)}
     *
     * Defaults to true (ascending)
     */
    @SuppressWarnings("unchecked")
    public S sortByDistance(Positionable positionable) {
        setSortParameters(positionable, true);
        return (S)this;
    }

    /**
     * {@link Sorting#sortByDistance(Positionable[], Positionable, boolean)}
     */
    @SuppressWarnings("unchecked")
    public S sortByDistance(Positionable positionable, boolean ascending) {
        setSortParameters(positionable, ascending);
        return (S)this;
    }

    protected boolean shouldSortResults() {
        return this.sortPositionable != null;
    }

    private void setSortParameters(Positionable positionable, boolean ascending) {
        this.sortAscending = ascending;
        this.sortPositionable = positionable;
    }

    protected void sortByDistance(Positionable[] entities) {
        Sorting.sortByDistance(entities, this.sortPositionable, this.sortAscending);
        //return entities;
    }
}
