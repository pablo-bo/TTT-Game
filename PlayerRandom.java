import java.util.Random; // for random player

class PlayerRandom extends Player{

  public int getTurn(Board b){
  //example for randon player
    Random rand = new Random();
    int m = b.getFreeSquares().get(rand.nextInt(b.getFreeSquares().size()));
    
    return m;
  }
}