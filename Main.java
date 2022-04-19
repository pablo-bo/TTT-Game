class Main {
  public static void main(String[] args) {
    System.out.println("Starting...");
         
    Player p1 = new PlayerBot("mr. First",  'X');
    Player p2 = new PlayerCleverBot("mr. Second", 'O');
    
    Board board = new Board();
    Game game = new Game(board, p1, p2);
    game.run();
    
    System.out.println("End.");
  }
}