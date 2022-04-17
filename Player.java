import java.io.IOException; // for keyboard player
import java.util.Scanner;

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

public int getTurn(Board b){
  
  Scanner  in = new Scanner(System.in);
  System.out.print(this.info()+", enter you turn: ");
  int turn = in.nextInt();
  return turn;

  }

}