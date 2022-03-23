class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal = 0;
    int anti = 0;
    
    // win needs every single spot in that col/row/diagonal/antiDigonal to be taken
    int[] rowsTaken;
    int[] colsTaken;
    int diagonalTaken = 0;
    int antiTaken = 0;
    
    int n = 0;
    public TicTacToe(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
        this.rowsTaken = new int[n];
        this.colsTaken = new int[n];
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        int winCondition = player * n;
        if (row == col) {
            diagonal += player;
            diagonalTaken++;
        } 
        if (row + col == n - 1) {
            anti += player;
            antiTaken++;
        }
        rows[row] += player;
        rowsTaken[row]++;
        cols[col] += player;
        colsTaken[col]++;
        
        if ((diagonal == winCondition && diagonalTaken == n) || (anti == winCondition && antiTaken == n) || (rows[row] == winCondition && rowsTaken[row] == n) || (cols[col] == winCondition && colsTaken[col] == n)) {
            return player;
        }
        
        return 0;
    }
    
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */