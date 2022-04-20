import java.util.ArrayList;

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
  return this.board.isWinCondition();
}

public boolean isDraw(){
  return this.board.isDrawCondition();
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
  //draw start info
  this.draw();
  while(this.hasLegalMovies() & !this.isWin()){
    for(Player p:this.players){
      //get next turn and draw
      if(this.hasLegalMovies()){
        int m = p.getTurn(this.board);
        this.board.set(m, p.getSymbol());
        this.pause(500);
        this.draw();
        }
      if (isWin()){
        System.out.println(p.info()+" WIN!!!");
        break;
      }else{
        if(isDraw()){
          System.out.println("GAME DRAW!!!");
          break;
        }
      }
    }
  }
}
  
  
}