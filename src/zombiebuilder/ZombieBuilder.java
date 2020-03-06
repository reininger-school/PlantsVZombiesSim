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
}
