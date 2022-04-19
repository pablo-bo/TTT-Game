import java.util.Random; // for random player


class PlayerBot extends Player{

  public PlayerBot(){
    super();
  }
  
  public PlayerBot(String name){
    super(name);
  }

  public PlayerBot(String name,  char sym){
    super(name, sym);
  }

  @Override
  public int getTurn(Board b){
    //check my better turn
    for(int i : b.getFreeSquares()){
        //System.out.println("Test sq ="+i);
        Board testBoard = new Board(b);
        testBoard.set(i, this.getSymbol());
        if ( testBoard.isWinCondition() ){
          //good turn
          System.out.println("good sq ="+i);
          return i;
        }
      }
    //check opposite better turn and prevent it
    char oppoSym = (this.getSymbol()=='X')? 'O':'X'; // TODO refactor to method
    for(int i : b.getFreeSquares()){
        //System.out.println("Test sq ="+i);
        Board testBoard = new Board(b);
        testBoard.set(i, oppoSym);
        if ( testBoard.isWinCondition() ){
          //prevent turn
          System.out.println("prevent sq ="+i);
          return i;
        }
      }
    //...
    
    //last chance
    return getRandomTurn(b);
  }
  
  public int getRandomTurn(Board b){
    // just randon choice free squares
    Random rand = new Random();
    int m = b.getFreeSquares().get(rand.nextInt(b.getFreeSquares().size()));
    
    return m;
  }
}