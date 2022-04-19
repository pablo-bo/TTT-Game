import java.util.ArrayList;
/*
Squares numbering:

 0 | 1 | 2 
-----------
 3 | 4 | 5 
-----------
 6 | 7 | 8 

*/

class Board {
  private int size = 9;
  private char[] squares = new char[size];

public Board(){
  for (int i=0;i<size;i++){
    squares[i] = ' ';
  }
}

public Board(Board anotherBoard){
  //Copy constructor
  this.size    = anotherBoard.size;
  this.squares = new char[this.size];
  for (int i=0;i<this.size;i++){
    this.squares[i] = anotherBoard.squares[i];
  }
}
  
public ArrayList<Integer> getFreeSquares(){
  ArrayList<Integer> free = new ArrayList<>();
  for (int i=0;i<size;i++){
    if (squares[i]==' '){
      free.add(i);
      }
  }
  return free;
}

public ArrayList<Integer> getPlayerSquares(char sym){
  ArrayList<Integer> free = new ArrayList<>();
  for (int i=0;i<size;i++){
    if (squares[i]==sym){
      free.add(i);
      }
  }
  return free;
}
  
public boolean chekLine(int s1, int s2, int s3){
  if(squares[s1]==squares[s2] & squares[s2]==squares[s3] & squares[s3]!=' ' ){
    return true;
    }else{
    return false;
    }
}

public boolean isWinCondition(){
  if (this.chekLine(0,1,2) || 
      this.chekLine(3,4,5) || 
      this.chekLine(6,7,8) || 
      this.chekLine(0,3,6) || 
      this.chekLine(1,4,7) || 
      this.chekLine(2,5,8) || 
      this.chekLine(0,4,8) || 
      this.chekLine(6,4,2)  
     ){
      return true;
    }else{
      return false;
    }
}

public boolean isDrawCondition(){
  if ( !isWinCondition() && this.getFreeSquares().size()==0){
    return true;
  }else{
    return false;
  }
}
  
public void set(int s, char c){
  squares[s] = c;
}
  
public void draw(){
  //System.out.print("\033[H\033[J");//clear screen
  System.out.println(" "+squares[0]+" | "+squares[1]+" | "+squares[2]+" ");
  System.out.println("-----------");
  System.out.println(" "+squares[3]+" | "+squares[4]+" | "+squares[5]+" ");
  System.out.println("-----------");
  System.out.println(" "+squares[6]+" | "+squares[7]+" | "+squares[8]+" ");
}
}