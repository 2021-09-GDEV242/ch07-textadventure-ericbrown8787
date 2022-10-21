
/**
 * Class Item - An item in an adventure game. 
 * 
 * An "Item" represents an object that can be picked up and stored by the 
 * player. The item consists of a text description, as well as a numerical 
 * weight value that may be used in determining the number of items a player
 * may carry at once. 
 * 
 * Exercise 3.18
 * @author Eric Brown
 * @version 10-21-2022
 */
public class Item
{
    private String description;
    private int weight;

    /**
     * Constructor for objects of class Item
     * @param itemDescription A text description of the item;
     * @param itemWeight The weight value of the item. 
     */
    public Item(String itemDescription,int itemWeight)
    {   
        description = itemDescription;
        weight = itemWeight;
    }

    /**
     * @return The text description of the item.
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * @return The weight value of the item.
     */
    public int getWeight()
    {
        return weight;
    }
    
}
