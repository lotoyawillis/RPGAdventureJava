import java.util.Random;

public class Knight
{
    // name, weapon, hit points (random), and armor

    // asks for and gets knight's name

    private String name;
    public String getName()
    {
        return name;
    }


    public void setName(String newName)
    {
        this.name = newName;
    }

    public void setRandomName(int newName)
    {
        switch (newName)
        {
            case 1:
                this.name = "Baret";
                break;
            case 2:
                this.name = "Griselda";
                break;
            case 3:
                this.name = "Cristole";
                break;
            case 4:
                this.name = "Maud";
                break;
            case 5:
                this.name = "Jed";
                break;
            case 6:
                this.name = "Merione";
                break;
            case 7:
                this.name = "Tobyn";
                break;
            case 8:
                this.name = "Iohane";
                break;
            case 9:
                this.name = "Ranulf";
                break;
            case 10:
                this.name = "Grishild";
                break;
            default:
                this.name = "Houdin";
                break;
        }
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


    Knight()
    {
        Random random = new Random();

        this.setRandomName(random.nextInt(11));
        this.setHealth(random.nextInt((40 - 25) + 1) + 25);
        this.setWeapon(random.nextInt(5));
        this.setArmor(random.nextInt(5));

    }

    Knight(String nm)
    {
        Random random = new Random();

        this.name = nm;
        this.setHealth(random.nextInt((40 - 25) + 1) + 25);
        this.weapon = 0;
        this.armor = 0;
    }


    void fight(Knight user, Knight opponent)
    {
        Random random = new Random();
        int num = random.nextInt(2);
        int userHealth = 0;
        int opponentHealth = 0;
        int round = 1;

        if (num == 1)
        {
            // user attacks first
            while (!(user.getHealth() <= 0 || opponent.getHealth() <= 0))
            {
                // each round
                if (round % 2 == 1) {
                    opponentHealth = opponent.getHealth() + user.getWeapon() + opponent.getArmor();
                    opponent.setHealth(opponentHealth);
                }
                else
                {
                    userHealth = user.getHealth() + opponent.getWeapon() + user.getArmor();
                    user.setHealth(userHealth);
                }

                System.out.printf("Round %d:\n", round);
                System.out.println(user);
                System.out.println(opponent);
                System.out.println("\n");
                round++;
            }

            if (user.getHealth() <= 0)
            {
                System.out.println("Your Opponent's Knight Won!!!");
            }
            else if (opponent.getHealth() <= 0)
            {
                System.out.println("Your Knight Won!!!");
            }

        }
        else
        {
            // opponent attacks first
            while (!(user.getHealth() <= 0 || opponent.getHealth() <= 0))
            {
                // each round
                if (round % 2 == 1)
                {
                    userHealth = user.getHealth() + opponent.getWeapon() + user.getArmor();
                    user.setHealth(userHealth);
                }
                else
                {
                    opponentHealth = opponent.getHealth() + user.getWeapon() + opponent.getArmor();
                    opponent.setHealth(opponentHealth);
                }

                System.out.printf("Round %d:\n", round);
                System.out.println(user);
                System.out.println(opponent);
                System.out.println("\n");
                round++;
            }

            if (user.getHealth() <= 0)
            {
                System.out.println("Your Opponent's Knight Won!!!");
            }
            else if (opponent.getHealth() <= 0)
            {
                System.out.println("Your Knight Won!!!");
            }
        }
    }

    public String toString()
    {
        return name+" "+health+" "+weaponName+" "+armorName;
    }
}