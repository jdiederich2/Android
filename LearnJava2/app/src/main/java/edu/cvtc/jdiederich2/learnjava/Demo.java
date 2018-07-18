package edu.cvtc.jdiederich2.learnjava;

public class Demo {
    public static void main(String[] args) {
//        Player jen = new Player();
//        System.out.println( jen.getHandleName() );
//        System.out.println( jen.getLives() );
//
//        jen.setNameAndLevel( "Jennifer", 5 );
//        System.out.println( jen.getHandleName() );
//        System.out.println( "Level: " + jen.getLevel() );
//        System.out.println( "Lives: " + jen.getLives() );
//
//        System.out.println( jen.getWeapon().getName() );
//        Weapon myAxe = new Weapon( "Goldshine Axe", 15, 50 );
//        jen.setWeapon( myAxe );
//        System.out.println( jen.getWeapon().getName() );
//
//        Loot redPotion = new Loot( "Red Potion", LootType.POTION, 7 );
//        jen.pickUpLoot( redPotion );
//
//        // Same as above 2 lines
//        jen.pickUpLoot( new Loot( "+3 Chest Armor", LootType.ARMOR, 80 ) );
//        jen.pickUpLoot( new Loot( "Ring of Protection +2", LootType.RING, 40 ) );
//        jen.pickUpLoot( new Loot( "Invisibility Potion", LootType.POTION, 35 ) );
//
//        jen.showInventory();

//        Loot bluePotion = new Loot("Blue Potion", LootType.POTION, 6);
//        boolean wasDeleted = jen.dropLoot( redPotion );
//        System.out.println( wasDeleted );
//        jen.showInventory();


//        Weapon jensWeapon = jen.getWeapon();
//        System.out.println(jensWeapon.getName());


//        Player louise = new Player("Louise");
//        System.out.println(louise.getHandleName());
//        louise.setLives(5);
//        System.out.println("Level: " + louise.getLevel());
//        System.out.println("Lives: " + louise.getLives());
//
//        Player gr8 = new Player("gr8", 9);
//        System.out.println(gr8.getHandleName());
//        System.out.println("Level: " + gr8.getLevel());
//        System.out.println("Lives: " + gr8.getLives());

//
//        Troll uglyTroll = new Troll( "Ugly Troll" );
//        uglyTroll.showInfo();
//        uglyTroll.takeDamage( 30 );
//
//        Vampire vlad = new Vampire( "Vlad" );
//        vlad.showInfo();
//        vlad.takeDamage( 8 );
//        vlad.showInfo();

//        for (int i = 0; i < 10; i++) {
//            VampireKing king = new VampireKing( "King" );
//            king.showInfo();
//
//            while (king.getLives() > 0) {
//                if (king.dodges()) {
//                    continue;
//                }
//
//                if (king.runAway()) {
//                    System.out.println( "King run away" );
//                    break;
//                } else {
//                    king.takeDamage( 80 );
//                    king.showInfo();
//                }
//            }
//            System.out.println("============================");
//
//        }

//        VampireKing king = new VampireKing( "King" );
//        king.showInfo();
//
//        king.setLives( 0 );
//        do {
//            if (king.dodges()) {
//                king.setLives( king.getLives() + 1 );
//                continue;
//            }
//
//            if (king.runAway()) {
//                System.out.println( "King run away" );
//                break;
//            } else {
//                king.takeDamage( 80 );
//                king.showInfo();
//            }
//        } while (king.getLives() > 0);
//
//        System.out.println( "============================" );


        Player conan = new Player("Conan");
        conan.pickUpLoot( new Loot("Invisibility", LootType.POTION, 4) );
        conan.pickUpLoot( new Loot("Mithril", LootType.ARMOR, 183) );
        conan.pickUpLoot( new Loot("Ring of Speed", LootType.RING, 25) );
        conan.pickUpLoot( new Loot("Red Potion", LootType.POTION, 2) );
        conan.pickUpLoot( new Loot("Cursed Shield", LootType.ARMOR, -8) );
        conan.pickUpLoot( new Loot("Brass Ring", LootType.RING, 1) );
        conan.pickUpLoot( new Loot("Chain Mail", LootType.ARMOR, 4) );
        conan.pickUpLoot( new Loot("Gold Ring", LootType.RING, 12) );
        conan.pickUpLoot( new Loot("Health Potion", LootType.POTION, 3) );
        conan.pickUpLoot( new Loot("Silver Ring", LootType.RING, 6) );
        conan.showInventory();


        System.out.println(conan.score());
        System.out.println("==============================");
        conan.dropLoot( "Cursed Shield" );
        System.out.println(conan.score());
    }
}
