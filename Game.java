import java.util.ArrayList;
import java.util.Random;

class Game {
  private Board board;
  private ArrayList<Player> players = new ArrayList<>();

public Game(){
} 

public Game(Board board){
 this.board = board;
}

public Game(Board board, Player ... players){
  this.board = board;
  this.addPlayers(players);
}
  
public void addPlayer(Player player){
  this.players.add(player);
}

public void addPlayers(Player ... players){
  for(int i = 0; i < players.length; i++) {
        addPlayer(players[i]);
  }
}
  
public void pause(int ms){
  try
    {
      Thread.sleep(ms);
    }
    catch(InterruptedException ex)
    {
      Thread.currentThread().interrupt();
    }  
}
  
public boolean isWin(){
  if (this.board.chekLine(0,1,2) || 
      this.board.chekLine(3,4,5) || 
      this.board.chekLine(6,7,8) || 
      this.board.chekLine(0,3,6) || 
      this.board.chekLine(1,4,7) || 
      this.board.chekLine(2,5,8) || 
      this.board.chekLine(0,4,8) || 
      this.board.chekLine(6,4,2)  
     ){
      return true;
    }else{
      return false;
    }
}

public boolean hasLegalMovies(){
  if (this.board.getFreeSquares().size()==0){
    return false;
  }else{
    return true;
  }
  
}

public ArrayList<Integer> getLegalMovies(){
  return this.board.getFreeSquares();
}
  
public String info(){
  String info = "TTT Game\nPlayers: "+players.size();
  for (Player p:players){
    info+="\n "+p.info();
  }
  return info;
}

public void draw(){
  System.out.print("\033[H\033[J");//clear screen
  System.out.println(this.info());
  System.out.println("");
  this.board.draw();
  System.out.println("");
}

public void run(){
  Random rand = new Random();
  //draw start info
  this.draw();
  while(this.hasLegalMovies() & !this.isWin()){
    for(Player p:this.players){
      //get next turn and draw
      if(this.hasLegalMovies()){
        // for example random choice from free squares
        int m = this.getLegalMovies().get( rand.nextInt(this.getLegalMovies().size()));
        this.board.set(m, p.getSymbol());
        this.pause(500);
        this.draw();
        }
      if (isWin()){
        System.out.println(p.info()+" WIN!!!");
        break;
      }else{
        if(!this.hasLegalMovies()){
          System.out.println("GAME DRAW!!!");
          break;
        }
      }
    }
  }
}
  
  
}