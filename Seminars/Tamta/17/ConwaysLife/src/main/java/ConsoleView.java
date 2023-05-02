public class ConsoleView {
    private boolean[][] grid;
    public ConsoleView(boolean[][] grid) {
        this.grid = grid;
    }
    public void updateView(){
        // სპეციალური ბაიტები კონსოლის გასასუფთავებლად
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("------------------------");
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j]){
                    System.out.print("x");
                }else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
