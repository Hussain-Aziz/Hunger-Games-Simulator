package Characters.MainCharacterCommands;

public interface CharacterCommand {
    public void execute(String[] args);
    public String[] getAliases();
    public String getDescription();
}
