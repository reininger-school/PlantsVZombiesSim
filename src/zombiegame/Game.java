package zombiegame;

import zombiegame.zombiebuilder.*;

/*
Coordinates Zombie game.
 */
public class Game {
    private ZombieBuilder zombieBuilder;

    /*
    Create new instance of Game.
     */
    public Game() {
        this.zombieBuilder = new ZombieBuilder();
    }

    /*
    Return new Zombie.
     */
    private Zombie constructZombie() {
        this.zombieBuilder.buildZombie();
        return this.zombieBuilder.getZombie();
    }

    /*
    Return new cone zombie.
     */
    private Zombie constructConeZombie() {
        this.zombieBuilder.buildZombie();
        this.zombieBuilder.buildCone();
        return this.zombieBuilder.getZombie();
    }

    /*
    Return new bucket zombie.
     */
    private Zombie constructBucketZombie() {
       this.zombieBuilder.buildZombie();
       this.zombieBuilder.buildBucket();
       return this.zombieBuilder.getZombie();
    }

    /*
    Return new door zombie.
     */
    private Zombie constructDoorZombie() {
        this.zombieBuilder.buildZombie();
        this.zombieBuilder.buildDoor();
        return this.zombieBuilder.getZombie();
    }
}
