package zombiebuilder;

import java.util.List;

/*
Class representing enemy objects. Serves as Component of Composite pattern.
 */
public abstract class EnemyObject {
    private int health;
    private List<EnemyObject> children;

    private void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }

        this.health = health;
    }

    public int getHealth() {
        return this.health;
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
    Return ith child.
     */
    public EnemyObject getChild(int child) {
        return this.children.get(child);
    }

    /*
    Actions to perform on death.
     */
    public void Die() {
    }

    /*
    Add child EnemyObject.
     */
    public void add(EnemyObject child) {
        this.children.add(child);
    }

    public void remove(EnemyObject child){}
}
