package 剑指Offer;

class Solution13 {

    public static boolean[][] visit;

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
//        int res = solution13.movingCount(2, 3, 1);
        int res = solution13.movingCount(3, 1, 0);
        System.out.println(res);
    }

    public int movingCount(int m, int n, int k) {
        int res = 0;
        visit = new boolean[m][n];
        dfs(m,n,k,0,0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j]){
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(int m, int n, int k, int x, int y){
        if (x < 0 || x >= n || y < 0 || y >= m || visit[y][x]) return;
        if (getSum(x,y) > k) return;
        visit[y][x] = true;
        dfs(m,n,k,x+1,y);
        dfs(m,n,k,x-1,y);
        dfs(m,n,k,x,y+1);
        dfs(m,n,k,x,y-1);
    }

    public int getSum(int x, int y){
        int res = 0, tmp = 0;
        while (x != 0){
            res += x%10;
            x /= 10;
        }
        while (y != 0){
            res += y%10;
            y /= 10;
        }
        return res;
    }
}