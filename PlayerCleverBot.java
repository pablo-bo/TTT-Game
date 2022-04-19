import java.util.Random; // for random player


class PlayerCleverBot extends Player{

  public PlayerCleverBot(){
    super();
  }
  
  public PlayerCleverBot(String name){
    super(name);
  }

  public PlayerCleverBot(String name,  char sym){
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
    char oppoSym = (this.getSymbol()=='X')? 'O':'X'; // TODO refactor to method opposite()
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
    //the best movies - center or corners
    int[] bestTurns = new int[] {4,0,2,6,8};
    for (int t : bestTurns){
      if (b.isEmpty(t)){
        return t;
      }
    }
    
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