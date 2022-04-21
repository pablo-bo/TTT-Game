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

private final int convertInput(int in){
  int result = -1;
  switch(in){
    case 7 : result = 0;
             break;
    case 8 : result = 1;
             break;
    case 9 : result = 2;
             break;
    case 4 : result = 3;
             break;
    case 5 : result = 4;
             break;
    case 6 : result = 5;
             break;
    case 1 : result = 6;
             break;
    case 2 : result = 7;
             break;
    case 3 : result = 8;
             break;
    default : break;
  }
  return result;
}
  
@Override  
public int getTurn(Board b){
  Scanner  in = new Scanner(System.in);
  System.out.print(this.info()+", enter you turn: ");
  int turn = in.nextInt();
  return convertInput(turn);
  }

}