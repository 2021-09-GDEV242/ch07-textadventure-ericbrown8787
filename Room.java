import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Eric Brown
 * @version 10-22-2022
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private Item item;
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    
    /**
     * Populate the room with an item. 
     * Exercise 8.20 - 8.21
     * @param description The description of the item.
     * @param weight The weight value of the item.
     */
    public void setItem(String description, int weight)
    {
        item = new Item(description, weight);
    }
    
    /**
     * Return the item that the room contains, if it contains one.
     * Null otherwise. 
     * Exercise 8.20 - 8.21
     * @return The room's item value, if applicalble.
     */
    public Item getItem()
    {
        return item;
    }
    
    /**
     * Remove an item from the room.
     * Exercise 8.20 - 8.21
     */
    public void removeItem()
    {
        item = null;
    }
        
    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Exercise 8.20 - 8.21
     * Return a description of the room in the form:     
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {   
        String baseString = "You are " + description + ".\n";
        String itemInfo = ""; // Exercise 8.20 - 8.21
        if (item != null){
            itemInfo = "You see " +  item.getDescription().toUpperCase() 
            +".\n";
        }
        return "You are " + description + ".\n" + itemInfo +  getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

