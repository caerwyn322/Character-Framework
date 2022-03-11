public class AbstractCharacter {

    public int health;
    public int stamina;
    public int magicka;
    public String name;
    public AbstractRace race;

    public void Create(String newName, AbstractRace newRace){
        this.name = newName;
        this.race = newRace;
    }
    public void SetStats(int newHealth, int newStamina, int newMagicka){
        this.health = newHealth;
        this.stamina = newStamina;
        this.magicka = newMagicka;
    }
    public String Talk(){
        return "I am a Character";
    }
}
