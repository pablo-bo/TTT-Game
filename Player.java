import java.io.IOException;

class Player {
  private String name="Unknown";
  private char symbol;
 // private PlayerType type = PlayerType.BOT;

public Player(){
  
}
  
public Player(String name){
  this.name = name;
}
/*public Player(String name, PlayerType type){
  this.name = name;
  this.type = type;
}*/
public Player(String name,  char sym){
  this.name = name;
  this.symbol = sym;
}
/*public Player(String name, PlayerType type, char sym){
  this.name = name;
  this.type = type;
  this.symbol = sym;
}*/
  
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
  System.out.print("Enter you turn: ");
  try {
        inChar = System.in.read();
        //System.out.print("You entered ");
        System.out.println(inChar);
       }
       catch (IOException e){
       System.out.println("Error reading from user");
       }
  return (inChar-48);
  }
}