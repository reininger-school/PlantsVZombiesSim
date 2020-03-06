package zombiebuilder;

/*
Builds Zombies.
 */
public class ZombieBuilder {
    private Zombie zombie;

    /*
    Add zombie to composite.
     */
    public void buildZombie() {
        if (this.zombie == null) {
            this.zombie = new Zombie();
        }
        else {
            this.zombie.add(new Zombie());
        }
    }

    /*
    Add Cone to composite if Zombie already exists.
     */
    public void buildCone() {
        if (this.zombie != null) {
            this.zombie.add(new Cone());
        }
    }

    /*
    Add Bucket to composite if Zombie already exists.
     */
    public void buildBucket() {
        if (this.zombie != null) {
            this.zombie.add(new Bucket());
        }
    }

    /*
    Add Door to composite if Zombie already exists.
     */
    public void buildDoor() {
        if (this.zombie != null) {
            this.zombie.add(new Door());
        }
    }
}
