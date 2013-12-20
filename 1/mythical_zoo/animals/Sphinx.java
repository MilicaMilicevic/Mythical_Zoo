package mythical_zoo.animals;

import mythical_zoo.properties.Egyptian;
import mythical_zoo.properties.HasLionBody;
import mythical_zoo.properties.HasWings;
import mythical_zoo.properties.HasHumanHead;

public class Sphinx extends MythicalAnimal implements Egyptian, HasLionBody, HasWings, HasHumanHead {
  private static int counter;
  
  public Sphinx(){
    super("Sphinx-"+(++counter));
  }

  @Override
  public String toString(){
    return super.toString()+"\nPROPERTIES: ["+Egyptian.description+"|"+HasLionBody.description+"|"+HasWings.description+"|"+HasHumanHead.description+"]";
  }
}