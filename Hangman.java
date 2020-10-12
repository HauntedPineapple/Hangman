//Audrey Main
//Period 6 Computer Science
//Avelino
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.text.*;
public class Hangman
{
    static String fruit[] = {"Pineapple","Orange","Grape","Cantelope","Grapefruit","Apple","Lemon","Mango","Avocado","Strawberry","Watermelon","Banana"};
    static String job[] = {"Teacher","Mailman","Athlete","Veterinarian","Librarian","Electrician","Lawyer","Janitor","Doctor","Police Officer","Actor","Waiter","Manager","Musician","Painter","Director","Scientist"};
    static String country[] = {"Croatia","Libya","Vietnam","Thailand","Lebanon","Ghana","Andorra","Ethiopia","Cyprus","Pakistan","Estonia","Saudi Arabia","Myanmar","Kosovo","Macedonia","Burundi","Venezuela","Uruguay","Switzerland","Netherlands","Kazakhstan","Lithuania","Malawi","Montenegro","Morocco","Belarus","Nicaragua","Rwanda","Kyrgyzstan"};
    static String capital[] = {"Quebec","Port Au Prince","Amsterdam","Bangkok","Baghdad","Buenos Aires","Damascus","Hanoi","Jerusalem","Kiev","Kingston","Khartoum","Seoul","Tashkent","Nairobi","Kabul","Valletta","Chisinau","Ulaanbaatar","Palikir","Rabat","Naypjdaw","Podgorica","Bamako","Dhaka","Vienna","Yerevan","Kuala Lumpur","Kathmandu","Bucharest"};
    static String movie[] = {"Jurassic Park","The Dark Knight Rises","Guardians of the Galaxy","The Hobbit","Lord of The Rings","Star Wars","Pulp Fiction","Forrest Gump","Citzen Kane","Casablanca","Back To The Future","Fight Club","The Breakfast Club", "The Matrix","Finding Nemo","The Lion King"};
    static String heroes[] = {"Robin","Batman","Deadpool","Captain America","Spiderman","Night Hawk","The Flash","Quicksilver","Iron Man","Superman","Hawkeye","Daredevil","Moon Knight","Sleepwalker"};
    static String book[] = {"Catcher In The Rye","Romeo and Juliet","Much Ado About Nothing","The Great Gatsby","Jane Eyre","Anna Karenina","The Scarlet Letter","Robinson Crusoe","The Adventures of Huckleberry Finn","The Little Prince","Lord of The Flies","Heart of Darkness","Pride and Prejudice","War and Peace","Moby Dick","A Tale Of Two Cities","The Giver","The Canterbury Tales","Of Mice And Men","The Grapes Of Wrath","Wuthering Heights","The Book Thief"};
    static String states[] = {"Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetss","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"};
    static String sCap[] = {"Montgomery","Juneau","Phoenix","Little Rock","Sacramento","Denver","Hartford","Dover","Tallahassee","Atlanta","Honolulu","Boise","Springfield","Indianapolis","Des Moines","Topeka","Frankfort","Baton Rouge","Augusta","Annapolis","Boston","Lansing","St Paul","Jackson","Jefferson City","Helena","Lincoln","Carson City","Concord","Trenton","Santa Fe","Albany","Raleigh","Bismarck","Columbus","Oklahoma City","Salem","Harrisburg","Providence","Columbia","Pierre","Nashville","Austin","Salt Lake City","Montpelier","Richmond","Olympia","Charleston","Madison","Cheyenne"};
    static String cartoon[] = {"Mickey Mouse","Elmer Fudd","Goofy","Daffy Duck","Donald Duck","Speedy Gonzales","Betty Boop","Tinker Bell","Charlie Brown","Popeye","Porky Pig","Bugs Bunny","Felix the Cat"};
    static String elements[] = {"Hydrogen","Helium","Lithium","Berylium","Boron","Carbon","Nitrogen","Oxygen","Fluorine","Neon","Sodium","Magnesium","Aluminum","Silicon","Phosphorus","Sulfur","Chlorine","Argon","Potassium","Calcium","Scandium","Titanium","Vanadium","Chromium","Manganese","Iron","Cobalt","Nickel","Copper","Zinc","Gallium","Germanium","Arsenic","Selenium","Bromine","Krypton","Rubidium","Strontium","Yttrium","Zirconium","Niobium","Molybdenum","Technetium","Ruthenium","Rhodium","Palladium","Silver","Cadmium","Indium","Tin","Antimony","Tellurium","Iodine","Xenon","Cesium","Barium","Lanthanum","Cerium","Praseodymium","Samarium","Europium","Gadolinium","Terbium","Dysprosium","Holmium","Erbium","Thulium","Ytterbier","Lutetium","Hafnium","Tantalum","Tungten","Rhenium","Osmium","Iridium","Platinum","Gold","Mercury","Thallium","Lead","Bismuth","Polonium","Astatine","Radon","Francium","Radium","Actinium","Thorium","Protactinium","Uranium","Neptunium","Plutonium","Americium","Curium","Berkelium","Californium","Einsteinium","Fermium","Mendelevium","Nobelium","Lawrencium","Rutherfordium","Dubnium","Seaborgium","Bohrium","Hassium","Meitnerium",};

    static String guessed[] = new String [26];
    static String used[] = new String[359];
    public static void main (String args[])
    {
        Scanner sc=new Scanner(System.in);
        int a,b,c,d,e,f,h,i,j,k,l,m,n,o,p,q,r,s,t,v,w,x,y,z;
        int g,u=0;
        int category,points,wrong,co;
        boolean correct = false;
        boolean won = false, valid = false;
        String guest = "Button"; // input
        int wins=0,losses=0;

        rules();
        int plays = sc.nextInt();
        for (f = 0; f < plays; f++){
            category = list1(); //player chooses category
            String word = chooseWord(category); //randomly selects word from category
            used[u] = word;
            u++;
            String guess[] = new String [word.length()]; //player's guesses put together; [A][_][d][_][_][_] [_][a][_][_]
            won = false;
            for (i=0; i<word.length(); i++){
                if (word.substring(i,i+1).equalsIgnoreCase(" "))
                    guess[i] = (" ");
                else
                    guess[i] = "_";
            } // initializes the blank spaces

            //System.out.println(word); //for debug purposes

            for (a = 0; a < word.length(); a++){
                String thread = word.substring(a,a+1);
                if (thread.equalsIgnoreCase(" "))
                    System.out.print(" ");
                else
                    System.out.print("["+guess[a]+"]");
            } //prints out the [_]s
            System.out.println();
            points = 10; g = 0;
            while (won == false){
                co=0;
                valid = false;
                for (i=0; i<guess.length; i++){
                    if (guess[i] == "_")
                        co++;
                } //if there co = 0, then no more blank spaces remain
                if (co == 0){
                    won=true;
                    wins++;
                    System.out.println("YOU WON!!!");
                    break;
                }
                if (points <= 0){
                    System.out.println("You LOST!");
                    System.out.println("The answer was "+word);
                    losses++;
                    break;
                }
                while(valid==false){
                    guest = sc.next();
                    if (guest.length()!=1){
                        JOptionPane.showMessageDialog(null,"Enter ONE letter!!!","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    if (guest.length()==1){
                        valid = true;
                        guessed[g] = guest;
                        g++;
                    }
                }      
                correct = turn(word,guest);
                if (correct == true){
                    System.out.println("Correct!");
                    for (a = 0; a < word.length(); a++){
                        if (word.substring(a,a+1).equalsIgnoreCase(" "))
                            guess[a] = (" ");
                        if (word.substring(a,a+1).equalsIgnoreCase(guest)){
                            boolean hasUpper = !word.substring(a,a+1).equals(word.substring(a,a+1).toLowerCase());
                            boolean hasLower = !word.substring(a,a+1).equals(word.substring(a,a+1).toUpperCase()); 
                            if (hasUpper)
                                guest = guest.toUpperCase();
                            if (hasLower)
                                guest = guest.toLowerCase();
                            guess[a] = guest;
                        }
                    }
                    for (a = 0; a < word.length(); a++){
                        String thread = word.substring(a,a+1);
                        if (thread.equalsIgnoreCase(" "))
                            System.out.print(" ");
                        else
                            System.out.print("["+guess[a]+"]");
                    }
                    System.out.println("\nYou have "+points+" guesses left");
                }
                if (correct == false) {
                    points--;
                    System.out.println("WRONG!!!");
                    for (a = 0; a < word.length(); a++){
                        String thread = word.substring(a,a+1);
                        if (thread.equalsIgnoreCase(" "))
                            System.out.print(" ");
                        else
                            System.out.print("["+guess[a]+"]");
                    }
                    System.out.println("You have "+points+" guesses left");
                }
            }
        }
    }

    public static boolean turn (String word, String guest){
        int count = 0;
        boolean correct = false;
        for (int a = 0; a < word.length(); a++){
            String thread = word.substring(a,a+1);
            if (guest.equalsIgnoreCase(thread)){
                count++;
            }
        }
        if (count == 0){
            correct = false;
        }
        else {
            correct = true;
        }
        return correct;
    }

    public static void rules (){
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to HANGMAN!");
        System.out.println("You will have a max of 10 wrong");
        System.out.println("guesses before game over.");
        System.out.println("The game is NOT case sensitive, so feel free to enter capital");
        System.out.println("letters whenever you want.");
        System.out.println("There are 9 categories, you will choose a category, and then PLAY!");
        System.out.println("Enter the number of rounds you want to play:");
    }

    public static int list1 (){
        String cat;
        int category;
        cat = JOptionPane.showInputDialog("Choose a category.\n"+"1 - fruits\n"+"2 - jobs\n"+"3 - countries (SUPER HARD)\n"+"4 - capitals (SUPER HARD)\n"+"5 - movies\n"+"6 - superheroes\n"+"7 - books\n"+"8 - U.S. states\n"+"9 - state capitals\n"+"10 - cartoon characters\n"+"11 - elements");
        category = Integer.parseInt(cat);
        return category;
    }

    public static String chooseWord (int category){
        String word = "Hangman";
        boolean match=true;
        int a,b,c=0;
        while (match){
            switch (category){
                case 1: b = fruit.length;
                a = (int) (Math.random()*b);
                word = fruit[a];
                break;
                case 2: b = job.length;
                a = (int) (Math.random()*b);
                word = job[a];
                break;
                case 3: b = country.length;
                a = (int) (Math.random()*b);
                word = country[a];
                break;
                case 4: b = capital.length;
                a = (int) (Math.random()*b);
                word = capital[a];
                break;
                case 5: b = movie.length;
                a = (int) (Math.random()*b);
                word = movie[a];
                break;            
                case 6: b = heroes.length;
                a = (int) (Math.random()*b);
                word = heroes[a];
                break;            
                case 7: b = book.length;
                a = (int) (Math.random()*b);
                word = book[a];
                break;
                case 8: b = states.length;
                a = (int) (Math.random()*b);
                word = states[a];
                break;
                case 9: b = sCap.length;
                a = (int) (Math.random()*b);
                word = sCap[a];
                break;
                case 10: b = cartoon.length;
                a = (int) (Math.random()*b);
                word = cartoon[a];
                break;
                case 11: b = elements.length;
                a = (int) (Math.random()*b);
                word = elements[a];
                break;
            }
            for (b=0;b<used.length;b++){
                if (used[b] == word){
                    c++;
                }
            }
            if (c == 0){
                match = false;
            }
        }
        return word;
    }
}