package scripts.entityselector.finders.prefabs;

import org.tribot.api.types.generic.Filter;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.ext.Filters;
import org.tribot.api2007.types.RSItem;
import scripts.entityselector.finders.Finder;

/**
 * @author Laniax
 */
public class ItemEntity extends Finder<RSItem, ItemEntity> {

    /**
     * {@link Filters.Items#idEquals}
     */
    public ItemEntity idEquals(int... id) {
        filters.add(Filters.Items.idEquals(id));
        return this;
    }

    /**
     * {@link Filters.Items#idNotEquals}
     */
    public ItemEntity idNotEquals(int... id) {
        filters.add(Filters.Items.idNotEquals(id));
        return this;
    }

    /**
     * {@link Filters.Items#nameNotEquals}
     */
    public ItemEntity nameNotEquals(String... names) {
        filters.add(Filters.Items.nameNotEquals(names));
        return this;
    }

    /**
     * {@link Filters.Items#nameEquals}
     */
    public ItemEntity nameEquals(String... names) {
        filters.add(Filters.Items.nameEquals(names));
        return this;
    }

    /**
     * {@link Filters.Items#nameContains}
     */
    public ItemEntity nameContains(String... names) {
        filters.add(Filters.Items.nameContains(names));
        return this;
    }

    /**
     * {@link Filters.Items#nameNotContains}
     */
    public ItemEntity nameNotContains(String... names) {
        filters.add(Filters.Items.nameNotContains(names));
        return this;
    }

    /**
     * {@link Filters.Items#actionsContains}
     */
    public ItemEntity actionsContains(String... actions) {
        filters.add(Filters.Items.actionsContains(actions));
        return this;
    }

    /**
     * {@link Filters.Items#actionsNotContains}
     */
    public ItemEntity actionsNotContains(String... actions) {
        filters.add(Filters.Items.actionsNotContains(actions));
        return this;
    }

    /**
     * {@link Filters.Items#actionsEquals}
     */
    public ItemEntity actionsEquals(String... actions) {
        filters.add(Filters.Items.actionsEquals(actions));
        return this;
    }

    /**
     * {@link Filters.Items#actionsNotEquals}
     */
    public ItemEntity actionsNotEquals(String... actions) {
        filters.add(Filters.Items.actionsNotEquals(actions));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public RSItem[] getResults() {

        Filter<RSItem> filter = super.buildFilter();

        if (filter != null)
            return Inventory.find(filter); // Remarkably, the Inventory class is the only class without a #getAll(filter) method.

        return Inventory.getAll();
    }
}
