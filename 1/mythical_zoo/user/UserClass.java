/**
 * @author: Milica Milicevic
 * @version: 1.1
 */

package mythical_zoo.user;

import mythical_zoo.animals.*;

import java.util.Random;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class UserClass {
  private Object[][] matrix;
  private Set<MythicalAnimal> animals;
  
  private volatile boolean isEnd;//obavezno - uvijek na vrijeme azuriran
  
  private static UserClass uniqueUserClass=new UserClass(); //singletone!
  
  private UserClass(){
    matrix=new Object[10][15];
    animals=new HashSet<MythicalAnimal>();//nije nam bitan redoslijed
  }
  
  public static void main(String[] args){
    uniqueUserClass.createAnimals();  
    System.out.println("MythicalAnimals are created.");
    uniqueUserClass.setAnimals();
    System.out.println("MythicalAnimals are setted.\n"+uniqueUserClass.matrixToString());
    System.out.println("Simulation begins.");
    Iterator iteratorAnimal1=uniqueUserClass.animals.iterator();
    while(iteratorAnimal1.hasNext())
      ((MythicalAnimal)iteratorAnimal1.next()).start();
    try{
      Iterator iteratorAnimal2=uniqueUserClass.animals.iterator();
      while(iteratorAnimal2.hasNext())
        ((MythicalAnimal)iteratorAnimal2.next()).join();
    }
    catch(InterruptedException e){
      e.printStackTrace();
    }
    System.out.println("Simulation ends."); 
  }
  
  public void createAnimals(){
    for(int i=0;i<2;i++)
    {
      animals.add(new Centaur());
      animals.add(new Mantikore());
      animals.add(new Pegasus());
      animals.add(new Sphinx());
    }
  }
  
  public void setAnimals(){
    Random generator=new Random();
    Iterator iteratorAnimal=animals.iterator();
    while(iteratorAnimal.hasNext()){
      MythicalAnimal animal=(MythicalAnimal)iteratorAnimal.next();
      while(!animal.isSetted()){ //sok nije setovana!
        int i=generator.nextInt(matrix.length);
        int j=generator.nextInt(matrix[0].length);
        if(!(matrix[i][j] instanceof MythicalAnimal)) {//ako vec nije postavljena zivotinja
          {
            matrix[i][j]=animal;
            animal.setPosition(i,j);
          }
        }
      }
    }
  }
  
  public String matrixToString(){
    String result="";
    for(int i=0;i<matrix.length;i++)
      for(int j=0;j<matrix[i].length;j++)
        if(matrix[i][j]!=null)
          result+=matrix[i][j]+"\n";
    return result;
  }
  
  public boolean isEnd(){
    return isEnd;
  }

  public Object[][] getMatrix(){
    return matrix;
  }
  
  public static UserClass getUUserClass(){ 
    return uniqueUserClass;
  }
  
  public void setEnd(){
    isEnd=true;
  } 
}