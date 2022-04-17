import java.util.Random; // for random player

class PlayerRandom extends Player{

  public PlayerRandom(){
    super();
  }
  
  public PlayerRandom(String name){
    super(name);
  }

  public PlayerRandom(String name,  char sym){
    super(name, sym);
  }

  @Override
  public int getTurn(Board b){
    // just randon choice free squares
    Random rand = new Random();
    int m = b.getFreeSquares().get(rand.nextInt(b.getFreeSquares().size()));
    
    return m;
  }
}