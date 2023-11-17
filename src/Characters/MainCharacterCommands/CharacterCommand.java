package Characters.MainCharacterCommands;

public interface CharacterCommand {
    public void execute(String[] args);
    public String getName();

    public String getDescription();
}
