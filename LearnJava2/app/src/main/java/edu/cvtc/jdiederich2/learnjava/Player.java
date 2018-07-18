package edu.cvtc.jdiederich2.learnjava;

import java.util.ArrayList;

public class Player {
    private String handleName;
    private int lives;
    private int level;
    private int score;
    private Weapon weapon;
    private ArrayList<Loot> inventory; // Creates and array list allowing only types "Loot"

    public Player() {
        this("Unknown Player"); // This line is calling our second Player constructor.
    }

    public Player(String handle) {
        this(handle, 1);
//        this.handleName = handle;
//        lives = 3;
//        level = 1;
//        score = 0;
    }

    public Player(String handle, int startingLevel) {
//        this.handleName = handle;
//        this.lives = 3;
//        this.level = startingLevel;
//        this.score = 0;

        setHandleName( handle );
        setLives( 3 );
        setLevel( startingLevel );
        setScore( 0 );
        setDefaultWeapon();

        // Initialize empty array list. If not initialized, it would be null and cause and error.
        // Could do ArrayList<Loot>();, but that would be redundant as we already specified that inventory
        // can only contain Loot objects.
        inventory = new ArrayList<>(  );
    }

    public String getHandleName() {
        return handleName;
    }

    public void setHandleName(String handle) {
        if(handle.length() < 3) {
            System.out.println("The name " + handle + ", must be 3 characters or more.");
            return;
        }
        this.handleName = handle;
    }

    private void setDefaultWeapon() {
        this.weapon = new Weapon("Sword", 10, 20);
    }

    public void setNameAndLevel(String name, int level) {
//        this.handleName = name;
//        this.level = level;
        setHandleName( name );
        setLevel( level );
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public ArrayList<Loot> getInventory() {
        return inventory;
    }

//    public void setInventory(ArrayList<Loot> inventory) {
//        this.inventory = inventory;
//    }

    public void pickUpLoot(Loot newLoot) {
        inventory.add(newLoot);
    }

    public boolean dropLoot(Loot loot) {
        if(this.inventory.contains( loot )) {
            inventory.remove(loot);
            return true;
        }
        return false;
    }

    public boolean dropLoot(String lootName) {

        for(Loot currentLoot : inventory) {
            if(currentLoot.getName().equals( lootName )) {
                inventory.remove( currentLoot );
                return true;
            }
        }
        return false;
    }



    public void showInventory() {

        for(Loot item : inventory) {
            System.out.println(item.getName());
        }
        System.out.println("==================================");
    }

    public int score() {
        int total = 0;
//       for(int i = 0; i < inventory.size(); i++) {
//             Loot currentLoot = inventory.get(i);
         for(Loot currentLoot : inventory) {
            System.out.println(currentLoot.getName() + " is worth " + currentLoot.getValue());
            total += currentLoot.getValue();
        }
        return total;
    }
}
