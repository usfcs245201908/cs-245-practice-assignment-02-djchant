public class NQueens {
    private static int n;
    private static int[][] board;
    private int row = 0;

    public NQueens(int size) {
        n = size;
        board = new int[n][n];
    }

    public boolean placeNQueens() throws Exception{

         if(n < 1) {
         	throw new Exception();
         }

        if(row == n) {
            return true;
        }

        int col = 0;

        while(col < n) {
            if(canPlaceQueen(row, col, n)) {
                board[row][col] = 1;
                row++;
                if(placeNQueens()) {
                    return true;
                } else {
                    row--;
                    board[row][col] = 0;

                    if((row > 0) && col == n) {
                        return false;
                    } else {
                        col++;
                    }
                }
            } else {
                col++;
                if(col == n) {
                    return false;
                }
            }
        }

        return false;
    }

    public boolean canPlaceQueen(int row, int col, int n) {
        int x = row;
        int y = col;

        for(int i = 0; i < n; i++) {
            if(board[row][i] == 1) { //checks horizontal
                return false;
            }

            if(board[i][col] == 1) { //checks vertical
                return false;
            }
        }

        while(x >= 0 && y >= 0) {  //left top diagonal
            if(board[x][y] == 1) {
                return false;
            }

            x--;
            y--;
        }

        x = row;
        y = col;

        while(x < n && y < n) {  //right bottom diagonal
            if(board[x][y] == 1) {
                return false;
            }
            x++;
            y++;
        }

        x = row;
        y = col;

        while(x < n && y >= 0) {   //left bottom diagonal
            if(board[x][y] == 1) {
                return false;
            }
            x++;
            y--;
        }

        x = row;
        y = col;

        while(x >= 0 && y < n) {  //right top diagonal
            if(board[x][y] == 1) {
                return false;
            }
            x--;
            y++;
        }

        return true;
    }
}

