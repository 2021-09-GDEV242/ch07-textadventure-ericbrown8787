
/**
 * Class NonPlayerCharacter - An item in an adventure game. 
 * 
 * An "NonPlayerCharacter" represents an object that can be picked up and stored by the 
 * player. The item consists of a text description, as well as a numerical 
 * weight value that may be used in determining the number of items a player
 * may carry at once. 
 * 
 * Exercise 3.18
 * @author Eric Brown
 * @version 10-21-2022
 */
public class NonPlayerCharacter
{   
    private String name;
    private String dialogue;

    /**
     * Constructor for objects of class NonPlayerCharacter
     * @param characterName The name of the NPC.
     * @param characterDialogue The NPC's dialogue upon being spoken to. 
     */
    public NonPlayerCharacter(String characterName,String characterDialogue)
    {   
        name = characterName;
        dialogue = characterDialogue;
    }

    /**
     * @return The character's dialogue string.
     */
    public String getDialogue()
    {
        return dialogue;
    }
    
    /**
     * @return The name of the character.
     */
    public String getName()
    {
        return name;
    }
    
}
