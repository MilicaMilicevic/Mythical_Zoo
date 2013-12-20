package mythical_zoo.animals;

import java.util.Random;

import mythical_zoo.user.UserClass;
import mythical_zoo.exception.StopException;

public abstract class MythicalAnimal extends Thread {
  private String name;
  private int strength;
  private int weight;
  
  private int[] position;
  private Control control;
  private int step;
  
  public MythicalAnimal(String arg1){
    super(arg1);
    strength=new Random().nextInt(10)+1;       //podaci nezavisni od tipa podklase
    weight=new Random().nextInt(650)+250;
  }

  @Override
  public void run(){
    step=new Random().nextInt(3)+1;
    try{
    //zivotinje se krecu samo ulijevo.Pp. da je potrebno vrijeme da se niti zaustave! 
      while((position[1]-step>0)&&(!(UserClass.getUUserClass()).isEnd())){
        synchronized(UserClass.getUUserClass()){
          System.out.print(this+" passed from "+positionToString()+" to ");
          position[1]-=step;
          System.out.println(positionToString());                 
          ((UserClass.getUUserClass()).getMatrix())[position[0]][position[1]+step]=null; //solobodi staru poziciju
          ((UserClass.getUUserClass()).getMatrix())[position[0]][position[1]]=this;
          decStrength();
        }
        sleep(1000);
        }
     if(position[1]==0)
       throw new StopException(getName()+" - Got to the end."); 
    }
    catch(StopException e){
      synchronized(UserClass.getUUserClass()){
        System.err.println(e.getMessage()+" Position: "+positionToString()); //da se naznaci bitan dio ispisa
        (UserClass.getUUserClass()).setEnd();
      }
    }
    catch(InterruptedException e){
      e.printStackTrace();
    }
   }
  
  @Override
  public String toString(){
    return getName()+" [Strength: "+strength+"|Weight: "+weight+"]";
  }
  
  public void setPosition(int arg1,int arg2){
    position=new int[2];
    position[0]=arg1;
    position[1]=arg2;
  }
  
  public boolean isSetted(){
    if(position!=null) 
      return true;
    return false;
  }
  
  //HELPER
  private Object positionToString(){
    if(position!=null)
      return "["+position[0]+","+position[1]+"]";
    else
      return "Not setted.";
  }
  
  public void decStrength() throws StopException {
    strength--;
    if(strength==0)
      throw new StopException(getName()+" - Stoped because strength is 0.");
  }  
}