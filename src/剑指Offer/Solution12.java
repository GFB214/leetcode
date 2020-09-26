package 剑指Offer;

import java.util.HashMap;
import java.util.Map;

class Solution12 {

    public static char[][] boards;
    public static char[] words;
    public static boolean[][][] visited = new boolean[200][200][40000];

    public static void main(String[] args) {
//        String word = "ABCCED";
//        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ab";
        char[][] board = new char[][]{{'a', 'b'}};
        boolean exist = new Solution12().exist1(board, word);
        System.out.println(exist);
    }

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean flag = dfs(board, chars, 0, i, j);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist1(char[][] board, String word) {
        words = word.toCharArray();
        boards = board;
        for (int i = 0; i < boards.length; i++) {
            for (int j = 0; j < boards[i].length; j++) {
                boolean flag = dfs2(0, i, j);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    //对比dfs1稍微修改，刚好过
    public static boolean dfs(char[][] board, char[] words, int pos, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != words[pos]) return false;
        if (pos == words.length - 1) return true;
        char tmp = board[i][j];
        board[i][j] = '-';
        if (dfs(board, words, pos + 1, i - 1, j) || dfs(board, words, pos + 1, i + 1, j) || dfs(board, words, pos + 1, i, j - 1) || dfs(board, words, pos + 1, i, j + 1))
            return true;
        board[i][j] = tmp;
        return false;
    }

    //超时 创建对象消耗时间
    public static boolean dfs1(char[][] board, char[] words, int pos, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != words[pos]) return false;
        if (pos == words.length - 1) return true;
        char tmp = board[i][j];
        board[i][j] = '-';
        boolean a = dfs(board, words, pos + 1, i - 1, j);
        boolean b = dfs(board, words, pos + 1, i + 1, j);
        boolean c = dfs(board, words, pos + 1, i, j - 1);
        boolean d = dfs(board, words, pos + 1, i, j + 1);
        board[i][j] = tmp;
        return a || b || c || d;
    }

    //剪枝
    public static boolean dfs2(int pos, int i, int j) {
        if (i < 0 || i >= boards.length || j < 0 || j >= boards[i].length || visited[i][j][pos]) return false;
        if (boards[i][j] != words[pos]) {
            visited[i][j][pos] = true;
            return false;
        }
        if (pos == words.length - 1) return true;
        char tmp = boards[i][j];
        boards[i][j] = '-';
        if (dfs2(pos + 1, i - 1, j) || dfs2(pos + 1, i + 1, j) || dfs2(pos + 1, i, j - 1) || dfs2(pos + 1, i, j + 1)) {
            return true;
        }
        boards[i][j] = tmp;
        visited[i][j][pos] = true;
        return false;
    }

}