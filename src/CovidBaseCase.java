import java.util.*;
public class CovidBaseCase {

    public static void main (String[] args){

        //System objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        //Game variables
        String[] enemies = {"Hospital 1", "Hospital 2", "Hospital 3", "Hospital 4"};
        int maxPatients = 75;
        int healthDamage = 25;

        //Player variables
        int health = 100;
        int attackDamage = 50;
        int numBoosts = 3;
        int boostAmount = 30;
        int boostDropChance = 20; //percentage
        int playerScore = 0;

        boolean running = true;

        System.out.println("  ____  ___  _______  ___ ______________  _  __  _________ _   _________ \n" +
                " / __ \\/ _ \\/ __/ _ \\/ _ /_  __/  _/ __ \\/ |/ / / ___/ __ \\ | / /  _/ _ \\\n" +
                "/ /_/ / ___/ _// , _/ __ |/ / _/ // /_/ /    / / /__/ /_/ / |/ // // // /\n" +
                "\\____/_/  /___/_/|_/_/ |_/_/ /___/\\____/_/|_/  \\___/\\____/|___/___/____/ \n" +
                "                                                                         ");
        System.out.println("");


        GAME:
        while(running){
            System.out.println("Objective: Save as many hospitals as you can without compromising your health");

            System.out.println("-------------------------------------------------");

            int enemyHealth = rand.nextInt(maxPatients);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has patients that need your help! #\n");
            // # hospital 1 has patients that need your help! #

            while(enemyHealth > 0){
                System.out.println("\tYour Health: " + health);
                System.out.println("\t" + enemy + "'s patients: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Administer vaccines");
                System.out.println("\t2. Boost immune system");
                System.out.println("\t3. Find another hospital in need of more help!");

                String input = in.nextLine();
                if(input.equals("1")){
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(healthDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> You help " + enemy + " by saving  " + damageDealt + " patients.");
                    System.out.println("\t> Your immune system was attacked for " + damageTaken + " health!");

                    if(health < 1){
                        System.out.println("\t> You have taken too much damage, you are too weak to go on!");
                        break;
                    }

                }
                else if(input.equals("2")){
                    if(numBoosts > 0){
                        health += boostAmount;
                        numBoosts--;
                        System.out.println("\t> You apply sanitizer, boosting your immune system for " + boostAmount + " health."
                                + "\n\t You now have " + numBoosts + " bottles of sanitizer left.\n" );
                    }
                    else{
                        System.out.println("\t> You have no sanitizer left! Save more hospitals to potentially get more!");
                    }
                }
                else if(input.equals("3")){
                    System.out.println("\tYou drove away from " + enemy + " to find another hospital!");
                    continue GAME;
                }
                else{
                    System.out.println("\t Invalid command!");
                }
            }

            if(health < 1){
                System.out.println("\tYour immune system is compromised, you are too weak to go on.");
                break;
            }

            System.out.println("-------------------------------------------------");
            System.out.println(" # " + enemy + " was saved! # ");
            System.out.println(" # Your immune system is now at " + health + " health!" + " #");
            playerScore++;

            if(rand.nextInt(100) < boostDropChance) {
                numBoosts++;
                System.out.println(" # The " + enemy + " found extra sanitizer! # ");
                System.out.println(" # You now have " + numBoosts + " bottles of sanitizer. #");
            }
            System.out.println("-------------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue saving patients");
            System.out.println("2. Quarantine yourself");

            String input = in.nextLine();

            while(!input.equals("1") && !input.equals("2")){
                System.out.println("Invalid command!");
                input = in.nextLine();
            }

            if(input.equals("1")){
                System.out.println("You continue saving hospitals!");
            }
            else if(input.equals("2")){
                System.out.println("You drive home, helping everyone you can for the day!");
                System.out.println("");
                break;
            }
        }
        System.out.println("\t####################");
        System.out.println("\t#THANKS FOR PLAYING#");
        System.out.println("\t####################");
        System.out.println("\t# HOSPITALS SAVED: " + playerScore + " #");
    }
}

