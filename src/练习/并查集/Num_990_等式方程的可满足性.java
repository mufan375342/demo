package 练习.并查集;

/**
 * @author mufan
 * @date 2020/6/8
 */
public class Num_990_等式方程的可满足性 {
    public static boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                uf.union(index1, index2);
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                if (uf.isConnected(index1,index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] s = {"a==z", "a==b", "b==c", "c==d", "b==y", "c==x", "d==w", "g==h", "h==i", "i==j", "a==g", "j!=y"};
        boolean b = equationsPossible(s);
        System.out.println(b);
    }
}
