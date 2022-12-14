/**
 * Representations for all the valid command words for the game
 * along with a string in a particular language.
 * 
 * @author  Eric Brown
 * @version 10-23-2022
 */
public enum CommandWord
{
    // A value for each command word along with its
    // corresponding user interface string.
    // Exercise 8.14(LOOK)
    // Exercise 8.15(EAT)
    GO("go"), QUIT("quit"), HELP("help"), LOOK("look"), EAT("eat"), TALK("talk"), UNKNOWN("?");
    
    // The command string.
    private String commandString;
    
    /**
     * Initialise with the corresponding command string.
     * @param commandString The command string.
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return commandString;
    }
}
