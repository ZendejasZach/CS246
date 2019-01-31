/* TODO: Create baby wolves feature */

package prove02;

import java.awt.*;
import java.util.Random;

public class Wolf extends Creature implements Spawner, Aware, Aggressor, Movable{

    /**
    * My variables
    * isStalking is if the wolf is stalking a target
    * canSpawn to show if wolf can spawn a new wolf
    * checkDirection direction to check based on last movement
    *      0 is right
    *      1 is left
    *      2 is up
    *      3 is down
    */
    Random _rand;
    boolean isStalking;
    int checkDirection;
    boolean canSpawn;

    // create the wolf
    public Wolf(){
        _rand = new Random();
        _health = 15;
        checkDirection = 0;
        isStalking = false;
        canSpawn = false;
    }

    /**
     * Attacks other animals but not zombies or plants
     * can spawn after eating animal
     * also stop stalking when animal is killed
     * @param target The {@link Creature} we've encounterd.
     */
    @Override
    public void attack(Creature target) {
       if(target instanceof Animal) {
           target.takeDamage(5);
           isStalking = false;
           canSpawn = true;
       }
    }

    @Override
    Shape getShape() {
        return Shape.Square;
    }

    @Override
    Color getColor() {
        return new Color(169,169,169);
    }

    @Override
    Boolean isAlive() {
        return _health > 0;
    }

    /**
     * Moves towards animals
     * does not move towards zombies or plants
     * otherwise, movement is random
     */
    @Override
    public void move() {

        //  find direction to move

        int m;

        // if it is stalking, move in that direction
        if(isStalking)
           m = checkDirection;

        // else move random
        else
            m = _rand.nextInt(4);

        // Move
        switch(m) {
            case 0:
                _location.x++;
                checkDirection = 0;
                break;
            case 1:
                _location.x--;
                checkDirection = 1;
                break;
            case 2:
                _location.y++;
                checkDirection = 2;
                break;
            case 3:
                _location.y--;
                checkDirection = 3;
                break;
            default:
                break;
        }
    }

    /**
     * check if creatures are nearby
     * First check in the direction you are moving then
     * clockwise from there.
     */
    @Override
    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {

        // check directions if not stalking another animal
        if (!isStalking) {
            for (int i = 0; i < 4; i++) {
                switch (checkDirection) {
                    case 0:
                        if (right instanceof Animal) {
                            isStalking = true;
                        } else
                            i++;
                        break;
                    case 1:
                        if (left instanceof Animal) {
                            isStalking = true;
                        } else
                            i++;
                        break;
                    case 2:
                        if (above instanceof Animal) {
                            isStalking = true;
                        } else
                            i++;
                        break;
                    case 3:
                        if (below instanceof Animal) {
                            isStalking = true;
                        } else
                            i++;
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * when the wolf eats something, they spawn a child wolf
     */
    @Override
    public Creature spawnNewCreature() {
        Wolf w = new Wolf();
        canSpawn = false;
        return w;
    }
}
