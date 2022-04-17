import java.util.Scanner;

class PlayerKeyboard extends Player{
 
public PlayerKeyboard(){
  super();
}
  
public PlayerKeyboard(String name){
  super(name);
}

public PlayerKeyboard(String name,  char sym){
  super(name, sym);
}

@Override  
public int getTurn(Board b){
  Scanner  in = new Scanner(System.in);
  System.out.print(this.info()+", enter you turn: ");
  int turn = in.nextInt();
  return turn;
  }

}