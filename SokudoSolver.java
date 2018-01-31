import java.util.ArrayList;

class SokudoSolver {
    public void solveSudoku(char[][] board) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i=0; i<9; i++) 
            for (int j=0; j<9; j++)
             if (board[i][j] == '.') {
                 result.add(i*9 + j);
                 
             }
        dfs(board, result, 0, result.size());
         
    }
    public Boolean dfs(char[][] board, ArrayList<Integer> result, int pos, int len){
     if(pos == len) return true;
        int index = result.get(pos);
        int col = index%9;
        int row = index/9;
        for (int i=1; i <= 9; i++) {
            if (isValid(board, col, row, i)){
            board[row][col] = (char)(i +'0');
        if (dfs(board, result, pos + 1, len))
            return true;
            board[row][col] = '.';
        }
    }
        return false;
    }
 
    public Boolean isValid(char[][] board, int col, int row, int v ){
        for (int i = 0; i<9; i++) { 
            if (board[i][col] == (char)(v + '0') ) return false;
            if (board[row][i] == (char)(v + '0')) return false;
            int row_s = (row/3)*3 + i/3;
            int col_s = (col/3)*3 + i%3;
            if (board[row_s][col_s] == (char)(v+'0')) return false;
        }
        return true;
    }
    
}
