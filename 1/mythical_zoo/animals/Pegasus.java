package mythical_zoo.animals;

import mythical_zoo.properties.Greek;
import mythical_zoo.properties.HasWings;
import mythical_zoo.properties.Horse;
import mythical_zoo.properties.HasHorseBody;

public class Pegasus extends MythicalAnimal implements Greek,HasWings,Horse, HasHorseBody {
  private static int counter;

  public Pegasus(){
    super("Pegasus-"+(++counter));
  }

  @Override
  public String toString(){
    return super.toString()+"\nPROPERTIES: ["+Greek.description+"|"+HasWings.description+"|"+Horse.description+"|"+HasHorseBody.description+"]";
  }
}