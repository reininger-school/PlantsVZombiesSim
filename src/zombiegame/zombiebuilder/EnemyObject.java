package zombiegame.zombiebuilder;

import java.util.LinkedList;
import java.util.List;

/*
Class representing enemy objects. Serves as Component of Composite pattern.
 */
public abstract class EnemyObject {
    private int health;
    protected List<EnemyObject> children;

    protected EnemyObject() {
        this.children = new LinkedList<EnemyObject>();
    }

    protected void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }

        this.health = health;
    }

    public int getHealth() {
        int totalHealth = this.health;

        for (EnemyObject accessory : this.children) {
            totalHealth += accessory.getHealth();
        }

        return totalHealth;
    }

    /*
    Take damage. Return leftover damage.
     */
    public int takeDamage(int d) {
        int leftover = 0;
        int newHealth = this.getHealth() - d;
        this.setHealth(newHealth);
        if (newHealth < 0) {
            leftover = -newHealth;
        }
        return leftover;
    }
    /*
    Return true if dead.
     */
    public boolean die() {
        return this.getHealth() <= 0;
    }

    /*
    Return ith child.
     */
    public EnemyObject getChild(int child) {
        return null;
    }

    /*
    Add child EnemyObject.
     */
    public void add(EnemyObject child) {
        // do nothing
    }

    /*
    Remove child.
     */
    public void remove(EnemyObject child) {
        // do nothing
    }
}
