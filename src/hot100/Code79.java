package hot100;

/**
 * @Author Verge
 * @Date 2022/3/27 21:46
 * @Version 1.0
 */
public class Code79 {
    public static void main(String[] args) {
        Code79 jzOffer12 = new Code79();
        char[][] map = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        //char[][] map = {{'A'}};
        System.out.println(jzOffer12.exist(map, "ABCESEEEFS"));
        //System.out.println(jzOffer12.exist(map, "A"));
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean res = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    res = res || d(board, visited, word, 0 ,j , i);
                }
            }
        }
        return res;
    }

    public boolean d(char[][] board, boolean[][] visited, String word, int index, int x, int y) {
        if (y < 0 || y > board.length - 1 ||
                x < 0 || x > board[0].length - 1 ||
                board[y][x] != word.charAt(index) || visited[y][x]) return false;
        if (index == word.length() - 1) return true;

        visited[y][x] = true;
        boolean res =  d(board, visited, word, index + 1, x + 1, y) ||
                d(board, visited, word, index + 1, x - 1, y) ||
                d(board, visited, word, index + 1, x, y + 1) ||
                d(board, visited, word, index + 1, x, y - 1);
        visited[y][x] = false;
        return res;
    }
}
