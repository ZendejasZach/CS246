package prove02;

import java.awt.*;
import java.util.Random;

public class Zombie extends Creature implements Movable, Aggressor {

    Random _rand;

    // create a Zombie
    public Zombie(){
        _health = 10;
    }

    // attack any creature except plants, deals 10 damage
    @Override
    public void attack(Creature target) {
        boolean notPlant = target instanceof Plant;

        if (notPlant) {
            target.takeDamage(10);
        }
    }

    // Zombies are blue squares
    @Override
    Shape getShape() {
        return Shape.Square;
    }

    @Override
    Color getColor() {
        return new Color(0,0,255);
    }

    @Override
    Boolean isAlive() {
        return _health > 0;
    }

    // move from left to right
    @Override
    public void move() {
        _location.x++;
    }
}
