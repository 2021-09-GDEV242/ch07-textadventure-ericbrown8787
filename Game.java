/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Eric Brown
 * @version 10-22-2022
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {   
        Room downtown,hotelSquare,cityPark,aptComplex,trainStation,theLofts,
        francisStreet,church,hospital,collegeBlvd,corpPark,cemetery,
        industrialAve,residentialArea,schoolBuildings,home;
        
        // create the rooms
        downtown = new Room("on Main Street, outside the coffee shop at which you work");
        hotelSquare = new Room("in front of a large, brightly-lit, expensive-looking hotel");
        cityPark = new Room("at the city park. A large sign on the fence says \"Open dusk-dawn\"");
        aptComplex = new Room("in a dark, enclosed apartment complex."
        +"\nYou get the distinct sense that you're tresspassing." 
        + "\nThe only way out is the way you came");
        trainStation = new Room("at the city's train station. A covered bench provides temporary shelter from the rain");
        theLofts = new Room("in front of a trendy apartment building." 
        + "\nYou don't know what kind of person could afford to live here, but it sure isn't you");
        francisStreet = new Room("a well-lit street lined with various stores and restaurants."
        +"\nMost of them are closed this late");
        church = new Room("in front of a large, old church. Immediately to its north is a large cemetery");
        hospital = new Room("in front of the local hospital. Visiting hours are long over, and most of the lights are dimmed");
        collegeBlvd = new Room("on the corner of College Boulevard."
        + "\nIt's much less crowded than usual with the rain," 
        + "\nbut there are still a few brave souls bar-hopping and grabbing takeout");
        corpPark = new Room("in front of a large office complex. The lights are on, but the parking lot is empty");
        cemetery = new Room("in the cemetery next to the church. They leave the gates open here all night."+
        "\nIn better weather you might stop to appreciate some cool old tombstones");
        industrialAve = new Room("near some run-down warehouses and industrial buildings."
        + "\nSome of them look like they'll collapse any second now");
        residentialArea = new Room("in a quiet residential area." 
        + "\nMost of the streetlights don't work here. "
        +"\nYou're slightly creeped out");
        schoolBuildings = new Room("near some of the local college's academic buildings");
        home = new Room("in front of your apartment building");
        
        // initialise room exits
        downtown.setExit("east", trainStation);
        downtown.setExit("west", hotelSquare);
        downtown.addItem("a statue of the current sitting mayor, commissioned by the man himself", 999);
        downtown.addItem("a set of mall ninja shuriken", 1);
        downtown.addItem("an abandoned cool hat", 1);
        
        hotelSquare.setExit("north",church);
        hotelSquare.setExit("east",downtown);
        hotelSquare.setExit("west",cityPark);
        hotelSquare.addItem("some abandoned luggage",3);
        hotelSquare.addNPC("a small child in an expensive suit", 
        "Do I look like someone who knows where you live? I don't even know where I live.");
        
        cityPark.setExit("east",hotelSquare);
        cityPark.setExit("west",aptComplex);
        cityPark.setExit("north",francisStreet);
        cityPark.addItem("a fancy refillable lighter", 1);
        
        aptComplex.setExit("east",cityPark);
        aptComplex.addItem("an overflowing dumpster",999);
        aptComplex.addNPC("a turkey vulture","Hey there stranger. I've never seen you around these parts before." 
        + "\nIf I had to guess, I'd say you're about as far as you can possibly be from your house right now"
        + "\nSo whatever direction you've been going in, you should uh...go in the opposite one.");
        
        
        francisStreet.setExit("south",cityPark);
        francisStreet.setExit("east", church);
        francisStreet.addItem("some broken glass",1);

        church.setExit("north",cemetery);
        church.setExit("east",hospital);
        church.setExit("south",hotelSquare);
        church.setExit("west", francisStreet);
        church.addItem("a bowl of milk",1);
        church.addNPC("a stray cat","Meow.");
        
        cemetery.setExit("north",industrialAve);
        cemetery.setExit("south",church);
        cemetery.addItem("a shovel",3);
        cemetery.addItem("a tattered picnic blanket",2);
        cemetery.addNPC("a friendly skeleton", 
        "The skeleton's vocal cords have long since turned to dust,"
        + " but they point northwest with one outstretched finger.");
        
        industrialAve.setExit("east", residentialArea);
        industrialAve.setExit("south",cemetery);
        industrialAve.addNPC("a shadowy figure", 
        "You can't see their eyes, but you know they're staring right at you.\n"
        + "A bolt of lightning illuminates the area.\n You still can't make out their face.\n"
        + "You back away.");
        
        residentialArea.setExit("north",home);
        residentialArea.setExit("west",industrialAve);
        residentialArea.setExit("east",schoolBuildings);
        
        schoolBuildings.setExit("west",residentialArea);
        schoolBuildings.setExit("south",corpPark);
        
        corpPark.setExit("north",schoolBuildings);
        corpPark.setExit("south",theLofts);
        corpPark.setExit("west",collegeBlvd);
        corpPark.addItem("a trash can overflowing with discarded coffee cups.", 999);

        collegeBlvd.setExit("north",residentialArea);
        collegeBlvd.setExit("east",corpPark);
        collegeBlvd.setExit("south", trainStation);
        collegeBlvd.setExit("west", hospital);
        collegeBlvd.addNPC("a person who is clearly three raccoons in a trenchcoat", 
        "**Chitters enthusiastically while pointing north with three of their six paws**");
        
        hospital.setExit("east", collegeBlvd);
        hospital.setExit("west",church);
        hospital.addNPC("an off-duty nurse", "Sorry, I don't actually live around here. I have no idea.");
        
        trainStation.setExit("north",collegeBlvd);
        trainStation.setExit("west",downtown);
        
        theLofts.setExit("north",corpPark);
        theLofts.addItem("a soggy, trampled pizza box",2);
        theLofts.addNPC("a distraught pizza delivery guy", 
        "Sorry, can't talk right now. I've got a bit of a situation to deal with here.");
        
        
        
        currentRoom = downtown;  // start game downtown
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("You are a barista at a chain coffee shop in a small city.");
        System.out.println("Your workplace stays open inexplicably late. You're just closing up now.");
        System.out.println("It's a warm, rainy night in the early fall. There's no one around.");
        System.out.println("You're not looking forward to the walk home.");
        System.out.println("The labyrinthine streets seem to rearrange themselves when no one's around to see.\n");
        System.out.println("You get lost every time.");
        System.out.println("You also forgot your umbrella.");        
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;
            
            case LOOK: // Exercise 8.14
                look();
                break;
            
            case EAT: // Exercise 8.15
                eat();
                break;
                
            case TALK:
                talk();
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You just want to get home.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }
    
    /** 
     * Print a detailed description of the current room.
     * Exercise 8.14
     */
    private void look()
    {
        System.out.println(currentRoom.getLongDescription());
    }
    
    /**
     * Exercise 8.15
     */
    private void eat()
    {
        System.out.println("You have eaten now, and are not hungry any more.");
    }
    
    /**
     * Print the dialogue of the current room's NPC, if applicable.
     */
    private void talk()
    {
        System.out.println("\nYou ask " + currentRoom.getNPC().getName() + " for directions.");
        System.out.println("\n" + currentRoom.getNPC().getName() + ": " + currentRoom.getNPC().getDialogue());
    }
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
