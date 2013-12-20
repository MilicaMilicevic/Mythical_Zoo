package mythical_zoo.animals;

import mythical_zoo.properties.Greek;
import mythical_zoo.properties.HasHumanHead;
import mythical_zoo.properties.HasHorseBody;

public class Centaur extends MythicalAnimal implements Greek, HasHumanHead, HasHorseBody {
  private static int counter;

  public Centaur(){
    super("Centaur-"+(++counter));
  }

  @Override
  public String toString(){
    return super.toString()+"\nPROPERTIES: ["+Greek.description+"|"+HasHumanHead.description+"|"+HasHorseBody.description+"]";
  }
}