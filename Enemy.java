import java.util.Random;

abstract class Enemy {

    private String name;
    public String getName()
    {
        return name;
    }

    // asks for and gets knight's health

    private int health;
    public int getHealth()
    {
        return health;
    }


    public void setHealth(int newHealth)
    {
        this.health = newHealth;
    }

    // asks for and gets knight's weapon

    private int weapon;
    public int getWeapon()
    {
        return weapon;
    }


    public void setWeapon(int newWeapon)
    {
        switch (newWeapon)
        {
            case 1:
                // "Long Sword"
                this.weapon = -4;
                break;
            case 2:
                // "Battle Axe"
                this.weapon = -5;
                break;
            case 3:
                // "Spear"
                this.weapon = -2;
                break;
            case 4:
                // "Warhammer"
                this.weapon = -6;
                break;
            default:
                // "None"
                this.weapon = -1;
                break;
        }
    }

    // asks for and gets knight's initial gold

    private int armor;
    public int getArmor()
    {
        return armor;
    }


    public void setArmor(int newArmor)
    {
        switch (newArmor)
        {
            case 1:
                // "Leather"
                this.armor = 2;
                break;
            case 2:
                // "Chainmail"
                this.armor = 3;
                break;
            case 3:
                // "Iron"
                this.armor = 4;
                break;
            case 4:
            default:
                // "None"
                this.armor = 0;
                break;
        }
    }

    // returns an int for the damage the enemy does
    // weapon changes per round for sorcerers and trolls?
    public abstract int fight();

    // modify enemy health?
    // enemy and enemyHealth
    public void takeDamage(Enemy enemy, int enemyHealth) throws Exception
    {
        if (enemyHealth < 0)
        {
            InvalidDamageException();
        }
        else
        {
            enemy.setHealth(enemyHealth);
        }
    }

    public static Enemy getRandomEnemy(int rand)
    {
        Enemy enemy;
        switch (rand)
        {
            case 1:
                enemy = new Ogre();
                break;
            case 2:
                enemy = new Sorcerer();
                break;
            case 3:
            default:
                enemy = new Troll();
                break;
        }

        return enemy;
    }

    private void InvalidDamageException() throws Exception
    {
        throw new Exception();
    }

}

class Ogre extends Enemy {

    private String name;
    public String getName()
    {
        return name;
    }

    // asks for and gets knight's health

    private int health;
    public int getHealth()
    {
        return health;
    }


    public void setHealth(int newHealth)
    {
        this.health = newHealth;
    }

    // asks for and gets knight's weapon

    private int weapon;
    private String weaponName;

    public int getWeapon()
    {
        return weapon;
    }


    public void setWeapon(int newWeapon)
    {
        switch (newWeapon)
        {
            case 1:
                // "Long Sword"
                this.weapon = -4;
                this.weaponName = "Long Sword";
                break;
            case 2:
                // "Battle Axe"
                this.weapon = -5;
                this.weaponName = "Battle Axe";
                break;
            case 3:
                // "Spear"
                this.weapon = -2;
                this.weaponName = "Spear";
                break;
            case 4:
                // "Warhammer"
                this.weapon = -6;
                this.weaponName = "Warhammer";
                break;
            default:
                // "None"
                this.weapon = -1;
                this.weaponName = "None";
                break;
        }
    }


    private int armor;
    private String armorName;
    public int getArmor()
    {
        return armor;
    }


    public void setArmor(int newArmor)
    {
        switch (newArmor)
        {
            case 1:
                // "Leather"
                this.armor = 2;
                this.armorName = "Leather";
                break;
            case 2:
                // "Chainmail"
                this.armor = 3;
                this.armorName = "Chainmail";
                break;
            case 3:
                // "Iron"
                this.armor = 4;
                this.armorName = "Iron";
                break;
            case 4:
            default:
                // "None"
                this.armor = 0;
                this.armorName = "None";
                break;
        }
    }

    public int fight()
    {
        return weapon;
    }

    public void setRandomName(int newName)
    {
        switch (newName)
        {
            case 1:
                this.name = "Turok";
                break;
            case 2:
                this.name = "Malevira";
                break;
            case 3:
                this.name = "Keret";
                break;
            case 4:
                this.name = "Bakrin";
                break;
            case 5:
                this.name = "Bakor";
                break;
            case 6:
                this.name = "Hamah";
                break;
            case 7:
                this.name = "Okur";
                break;
            case 8:
                this.name = "Kelgras";
                break;
            case 9:
                this.name = "Muruk";
                break;
            case 10:
                this.name = "Tolall";
                break;
            default:
                this.name = "Karn";
                break;
        }
    }

    Ogre()
    {
        Random random = new Random();

        this.setRandomName(random.nextInt(11));
        this.setHealth(random.nextInt((30 - 25) + 1) + 25);
        this.setWeapon(random.nextInt(5));
        this.setArmor(random.nextInt(5));
    }

    public String toString()
    {
        return name+" "+health+" "+weaponName+" "+armorName;
    }
}

class Sorcerer extends Enemy {
    // override weapon to magic

    private String name;
    public String getName()
    {
        return name;
    }

    // asks for and gets knight's health

    private int health;
    public int getHealth()
    {
        return health;
    }


    public void setHealth(int newHealth)
    {
        this.health = newHealth;
    }

    // asks for and gets knight's weapon

    private int weapon;
    private String weaponName;
    public int getWeapon()
    {
        return weapon;
    }


    // asks for and gets knight's initial gold

    private int armor;
    private String armorName;
    public int getArmor()
    {
        return armor;
    }


    public void setArmor(int newArmor)
    {
        switch (newArmor)
        {
            case 1:
                // "Leather"
                this.armor = 2;
                this.armorName = "Leather";
                break;
            case 2:
                // "Chainmail"
                this.armor = 3;
                this.armorName = "Chainmail";
                break;
            case 3:
                // "Iron"
                this.armor = 4;
                this.armorName = "Iron";
                break;
            case 4:
            default:
                // "None"
                this.armor = 0;
                this.armorName = "None";
                break;
        }
    }

    public int fight()
    {
        return weapon;
    }

    public void setRandomName(int newName)
    {
        switch (newName)
        {
            case 1:
                this.name = "Morain";
                break;
            case 2:
                this.name = "Allura";
                break;
            case 3:
                this.name = "Ailios";
                break;
            case 4:
                this.name = "Kilyn";
                break;
            case 5:
                this.name = "Osran";
                break;
            case 6:
                this.name = "Wenda";
                break;
            case 7:
                this.name = "Ulster";
                break;
            case 8:
                this.name = "Aleesia";
                break;
            case 9:
                this.name = "Sorith";
                break;
            case 10:
                this.name = "Zenara";
                break;
            default:
                this.name = "Ludinus";
                break;
        }
    }

    public void setWeapon(int newWeapon)
    {
        switch (newWeapon)
        {
            case 1: // "Water"
                this.weapon = -5;
                this.weaponName = "Water";
                break;
            case 2: // "Earth"
                this.weapon = -5;
                this.weaponName = "Earth";
                break;
            case 3: // "Fire"
                this.weapon = -5;
                this.weaponName = "Fire";
                break;
            case 4: // "Air"
                this.weapon = -5;
                this.weaponName = "Air";
                break;
            default: // "Misses"
                this.weapon = 0;
                this.weaponName = "Misses";
                break;
        }
    }

    Sorcerer()
    {
        Random random = new Random();

        this.setRandomName(random.nextInt(11));
        this.setHealth(random.nextInt((25 - 10) + 1) + 10);
        this.setWeapon(random.nextInt(6));
        this.setArmor(random.nextInt(5));
    }

    public String toString()
    {
        return name+" "+health+" "+weaponName+" "+armorName;
    }
}

class Troll extends Enemy {
    // glass cannon

    private String name;
    public String getName()
    {
        return name;
    }

    // asks for and gets knight's health

    private int health;
    public int getHealth()
    {
        return health;
    }


    public void setHealth(int newHealth)
    {
        this.health = newHealth;
    }

    // asks for and gets knight's weapon

    private int weapon;
    private String weaponName;
    public int getWeapon()
    {
        return weapon;
    }


    // asks for and gets knight's initial gold

    private int armor;
    private String armorName;
    public int getArmor()
    {
        return armor;
    }


    public void setArmor(int newArmor)
    {
        switch (newArmor)
        {
            case 1:
                // "Leather"
                this.armor = 2;
                this.armorName = "Leather";
                break;
            case 2:
                // "Chainmail"
                this.armor = 3;
                this.armorName = "Chainmail";
                break;
            case 3:
                // "Iron"
                this.armor = 4;
                this.armorName = "Iron";
                break;
            case 4:
            default:
                // "None"
                this.armor = 0;
                this.armorName = "None";
                break;
        }
    }

    public int fight()
    {
        return weapon;
    }

    public void setRandomName(int newName)
    {
        switch (newName)
        {
            case 1:
                this.name = "Rahjin";
                break;
            case 2:
                this.name = "Keja";
                break;
            case 3:
                this.name = "Rakash";
                break;
            case 4:
                this.name = "Altoa";
                break;
            case 5:
                this.name = "Javyn";
                break;
            case 6:
                this.name = "Zesa";
                break;
            case 7:
                this.name = "Ttarmek";
                break;
            case 8:
                this.name = "Yishi";
                break;
            case 9:
                this.name = "Ayagi";
                break;
            case 10:
                this.name = "Teza";
                break;
            default:
                this.name = "Zulabar";
                break;
        }
    }

    public void setWeapon(int newWeapon)
    {
        if (newWeapon == 100)
        { // "Fairy magic"
            this.weapon = -50;
            this.weaponName = "Fairy magic";
        }
        else
        { // "None"
            this.weapon = -1;
            this.weaponName = "None";
        }
    }

    Troll()
    {
        Random random = new Random();

        this.setRandomName(random.nextInt(11));
        this.setHealth(random.nextInt((10 - 5) + 1) + 5);
        this.setWeapon(random.nextInt(101));
        this.setArmor(random.nextInt(5));
    }

    public String toString()
    {
        return name+" "+health+" "+weaponName+" "+armorName;
    }
}
