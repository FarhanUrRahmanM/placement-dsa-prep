class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == '.') {
                    continue;
                }

                // If there is a ship cell above or to the left,
                // this is not the first cell of the battleship.
                if (i > 0 && board[i - 1][j] == 'X') {
                    continue;
                }

                if (j > 0 && board[i][j - 1] == 'X') {
                    continue;
                }

                count++;
            }
        }

        return count;
    }
}