package Characters.MainCharacterCommands;

public interface CharacterCommand {
    void execute(String[] args);
    String[] getAliases();
    String getDescription();
}
