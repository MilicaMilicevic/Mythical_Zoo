package mythical_zoo.animals;

import mythical_zoo.properties.HasLionBody;
import mythical_zoo.properties.HasHumanHead;
import mythical_zoo.properties.Greek;

public class Mantikore extends MythicalAnimal implements HasLionBody, HasHumanHead,Greek {
  private static int counter;

  public Mantikore(){
    super("Mantikore-"+(++counter));
  }

  @Override
  public String toString(){
    return super.toString()+"\nPROPERTIES: ["+Greek.description+"|"+HasLionBody.description+"|"+HasHumanHead.description+"]";
  }
}