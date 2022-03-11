import java.io.IOException;
import java.util.*;

public class Controller {

    public ArrayList<AbstractCharacter> characters = new ArrayList<>();
    public ArrayList<AbstractRace> races = new ArrayList<>();
    protected AbstractCharacter character;
    protected ConsoleView view;

    public Controller (ConsoleView newView){
        this.view = newView;
    }

    public int Menu(){
        return this.view.GetInt("""
                1. View Current Races
                2. View Current Characters
                3. Add New Character
                4. Add New Race
                5. Exit
                """);
    }
    public AbstractRace SelectRace(int prompt){

    }
    public void Selector(int prompt) throws IOException {

        switch (prompt){
            case 1:
                if(this.races.isEmpty()){
                    this.view.Show("No Race in database");
                }else{
                    this.view.Show("Races in the Database:");
                    for (AbstractRace i : this.races){
                        this.view.Show(i.raceName);
                    }
                }
                this.Selector(this.Menu());
                break;
            case 2:
                if (this.characters.isEmpty()){
                    this.view.Show("No Characters in database");
                }else{
                    this.view.Show("Characters in the Database:");
                    for (AbstractCharacter i : this.characters){
                    this.view.Show(i.name);
                    }
                }
                this.Selector(this.Menu());
                break;
            case 3:
                String tempCharName = this.view.GetString("Enter Character Name: ");
                String tempCharRace = this.view.GetString("Enter Character Race: ");

                AbstractCharacter newChar = new AbstractCharacter();
                newChar.Create(tempCharName, tempCharRace);
                int tempH = this.view.GetInt("Set Health: ");
                int tempS = this.view.GetInt("Set Stamina: ");
                int tempM = this.view.GetInt("Set Magicka: ");
                newChar.SetStats(tempH, tempS, tempM);
                this.characters.add(newChar);
                this.Selector(this.Menu());

                break;
            case 4:
                String tempRaceName = this.view.GetString("Enter Race Name: ");
                String tempRaceType = this.view.GetString("Enter Race type: ");
                String tempRaceSKill = this.view.GetString("Enter Race Skill: ");
                AbstractRace newRace = new AbstractRace(tempRaceName, tempRaceType, tempRaceSKill);
                this.races.add(newRace);
                this.Selector(this.Menu());
                break;
            case 5:
                this.view.Stop();
                break;
            default:
                this.view.Show("Welp");
        }
    }

    public void Go() throws IOException {
        this.characters.clear();
        this.view.Start("Hello, Welcome to the Character Creation Framework!");
        this.Selector(this.Menu());
    }
}
