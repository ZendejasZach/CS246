package teach03;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Player {

    // Properties
    private String name;
    private int health;
    private int mana;
    private int gold;
    private Map<String, Integer> equipment;

    /**
     * Constructor
     */
    public Player(String n, int h, int m, int g){
        this.name = n;
        this.health = h;
        this.mana = m;
        this.gold = g;
        this.equipment = new HashMap<>();
    }

    public void addEquipment(String name, int cost){
        equipment.put(name, cost);
    }

}
