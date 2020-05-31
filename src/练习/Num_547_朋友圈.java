package 练习;

/**
 * @author mufan
 * @date 2020/5/29
 */
public class Num_547_朋友圈 {

    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int res = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, visited, i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] m, boolean[] visited, int i) {
        for (int j = 0; j < m.length; j++) {
            if (m[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(m, visited, j);
            }
        }
    }

    public int findCircleNum1(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        //因为是看第一个人和其他人是不是朋友.所以这里遍历的时候是n-1
        for (int i = 0; i < n - 1; i++) {
            //和上面是同理
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }
}
