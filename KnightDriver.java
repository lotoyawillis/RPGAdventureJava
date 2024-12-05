/**
 * Willis, Lotoya
 */

import java.util.*;

public class KnightDriver
{
    /**
     * My main method
     * @param args array of String arguments that may be included in the command-line arguments
     */
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        Random random = new Random();

        String cont = " ";
        int num = 0;
        int choiceInt = 0;


        System.out.println("Welcome to Knight Fight!");

        do
        {
            // asks for and gets knight's name
            System.out.print("Enter the name of your Knight: ");
            String name = s.nextLine();
            Knight knight = new Knight(name);


            System.out.println("\nNow select your weapon! (Choose number)");
            System.out.println("1) Long Sword");
            System.out.println("2) Battle Axe");
            System.out.println("3) Spear");
            System.out.println("4) Warhammer");
            System.out.print("Your choice my liege? : ");
            String choice = s.nextLine();

            try {
                choiceInt = Integer.parseInt(choice);
                knight.setWeapon(choiceInt);
            }
            catch (Exception e)
            {
                knight.setWeapon(0);
            }


            // select your armor and make a switch case for that
            System.out.println("Now select your armor! (Choose number)");
            System.out.println("1) Leather");
            System.out.println("2) Chainmail");
            System.out.println("3) Iron");
            System.out.println("4) None");
            System.out.print("Your choice my liege? : ");
            choice = s.nextLine();

            try {
                choiceInt = Integer.parseInt(choice);
                knight.setArmor(choiceInt);
            }
            catch (Exception e)
            {
                knight.setArmor(0);
            }

            // request how many enemies your knight sees

            System.out.println("How many enemies does your knight see?");
            choice = s.nextLine();

            try {
                choiceInt = Integer.parseInt(choice);
            }
            catch (Exception e)
            {
                choiceInt = 1;
            }


            for (int i = 0; i < choiceInt; i++)
            {
                // enemy gets a name, health, weapon, and armor
                Enemy enemy;
                enemy = Enemy.getRandomEnemy(random.nextInt(3));

                // takes a y/n answer to start or exit
                System.out.println("Would you like to begin the fight?");
                cont = s.nextLine();

                if (cont.startsWith("y") || cont.startsWith("Y"))
                {
                    num = random.nextInt(2); // randomly chooses which Knight shall begin combat
                    int knightHealth = 0;
                    int enemyHealth = 0;
                    int round = 1;

                    // if both the knight and the enemy's weapons are not
                    // strong enough to pierce the other's armor, it's a
                    // tie
                    if (knight.getArmor() >= -(enemy.getWeapon()) && enemy.getArmor() >= -(knight.getWeapon()))
                    {
                        num = -1;
                    }

                    if (num == 1) {
                        // user attacks first
                        while ((knight.getHealth() > 0 && enemy.getHealth() > 0)) {
                            // each round
                            if (round % 2 == 1)
                            {
                                if (enemy.getArmor() < -(knight.getWeapon())) // if the enemy's armor is not stronger than the knight's weapon, they take damage
                                {
                                    enemyHealth = enemy.getHealth() + knight.getWeapon();
                                    try
                                    {
                                        enemy.takeDamage(enemy, enemyHealth);
                                    }
                                    catch (Exception e)
                                    {
                                        enemy.setHealth(0);
                                    }
                                }
                            }
                            else
                            {
                                if (knight.getArmor() < -(enemy.getWeapon())) // if the knight's armor is not stronger than the enemy's
                                { // weapon, they take damage
                                    knightHealth = knight.getHealth() + enemy.getWeapon();
                                    if (knightHealth > 0) // if knight's health falls below 0, set to 0
                                    {
                                        knight.setHealth(knightHealth);
                                    }
                                    else
                                    {
                                        knight.setHealth(0);
                                    }
                                }

                                // spellcasters can change spells
                                if (enemy instanceof Sorcerer)
                                {
                                    enemy.setWeapon(random.nextInt(5));
                                }
                                else if (enemy instanceof Troll)
                                {
                                    enemy.setWeapon(random.nextInt(101));
                                }
                            }

                            System.out.printf("Round %d:\n", round);
                            System.out.println("\nName HP Weapon Armor");
                            System.out.println(knight);
                            System.out.println(enemy);
                            System.out.println("\n");
                            round++;
                        }
                    }
                    else if (num == 0)
                    {
                        // opponent attacks first
                        while ((knight.getHealth() > 0 && enemy.getHealth() > 0))
                        {
                            // each round
                            if (round % 2 == 1)
                            {
                                if (knight.getArmor() < -(enemy.getWeapon())) // if the knight's armor is not stronger than the enemy's
                                { // weapon, they take damage
                                    knightHealth = knight.getHealth() + enemy.getWeapon();
                                    if (knightHealth > 0) // if knight's health falls below 0, set to 0
                                    {
                                        knight.setHealth(knightHealth);
                                    }
                                    else
                                    {
                                        knight.setHealth(0);
                                    }
                                }

                                // spellcasters can change spells
                                if (enemy instanceof Sorcerer)
                                {
                                    enemy.setWeapon(random.nextInt(5));
                                }
                                else if (enemy instanceof Troll)
                                {
                                    enemy.setWeapon(random.nextInt(101));
                                }
                            }
                            else
                            {
                                if (enemy.getArmor() < -(knight.getWeapon())) // if the enemy's armor is not stronger than the knight's weapon, they take damage
                                {
                                    enemyHealth = enemy.getHealth() + knight.getWeapon();
                                    try
                                    {
                                        enemy.takeDamage(enemy, enemyHealth);
                                    }
                                    catch (Exception e)
                                    {
                                        enemy.setHealth(0);
                                    }
                                }
                            }


                            System.out.printf("Round %d:\n", round);
                            System.out.println("\nName HP Weapon Armor");
                            System.out.println(knight);
                            System.out.println(enemy);
                            System.out.println("\n");
                            round++;
                        }
                    }
                    else
                    {
                        System.out.println("\nName HP Weapon Armor");
                        System.out.println(knight);
                        System.out.println(enemy);
                        System.out.println("It's a tie!!!");
                    }

                    if (knight.getHealth() <= 0)
                    {
                        System.out.println("Your Opponent Won!!!");
                    }
                    else if (enemy.getHealth() <= 0)
                    {
                        System.out.println("Your Knight Won!!!");
                    }
                }
            }


            cont = "";
            System.out.println("Would you like to play again?");
            cont = s.nextLine();
        } while (!cont.startsWith("N") && !cont.startsWith("n"));
    }
}