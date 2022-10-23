import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
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
    private ArrayList<Item> items;
    /**
     * Create a room described "description". Initially, it has
     * no exits or items. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<Item>();
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
     * Populate the room with an item. A description is something like
     * "a cursed puzzle box" or "an arcane scroll".
     * Exercise 8.20 - 8.22
     * @param description The description of the item.
     * @param weight The weight value of the item.
     */
    public void addItem(String description, int weight)
    {
        items.add(new Item(description, weight));
    }
    
    /**
     * Return the collection of items that the room contains.
     * Exercise 8.20 - 8.22
     * @return An ArrayList containing all of the items present in the room.
     */
    public ArrayList<Item> getItems()
    {
        return items;
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
     * Exercise 8.20 - 8.22
     * Return a formatted description of the room in the form:     
     *     You are in the kitchen.
     *     You see a 
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {   
        String baseString = "You are " + description + ".\n";
        String itemInfo = ""; // Exercise 8.20 - 8.21
        if (items.size() != 0){
            itemInfo += "You see ";
            
            for (int i = 0; i < items.size(); i++){
                if (i == items.size() - 1){
                    itemInfo += "and " 
                    + items.get(i).getDescription().toUpperCase() 
                    + ".\n";
                 
                }
                else {
                    itemInfo += items.get(i).getDescription().toUpperCase();
                    if (items.size() != 2) { 
                        itemInfo +=",";
                    }
                    itemInfo += " ";
                }
            }
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

