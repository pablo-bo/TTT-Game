import java.io.IOException; // for keyboard player
import java.util.Random; // for random player

class Player {
  private String name="Unknown";
  private char symbol;
 
public Player(){
  
}
  
public Player(String name){
  this.name = name;
}

public Player(String name,  char sym){
  this.name = name;
  this.symbol = sym;
}
  
public char getSymbol()  {
  return this.symbol;
}
  
public void setSymbol(char sym)  {
  this.symbol = sym;
}
public String info(){
  return this.name+" ("+this.getClass().getName()+") ["+this.symbol+"]";
}

public int getTurn(){
  //example for keyboard player
  int inChar=0;
  System.out.print(this.info()+", enter you turn: ");
  try {
        inChar = System.in.read();
        //System.out.print("You entered ");
        //System.out.println(inChar);
       }
       catch (IOException e){
       System.out.println("Error reading from user");
       }
  return (inChar-48);
  }
  
  public int getTurnRandom(Board b){
  //example for randon player
    Random rand = new Random();
    int m = b.getFreeSquares().get(rand.nextInt(b.getFreeSquares().size()));
    
    return m;
  }
}