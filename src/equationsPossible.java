// 990.等式方程的可满足性
public class equationsPossible {
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        for (String eq : equations) {
            char x = eq.charAt(0);
            char y = eq.charAt(3);
            if (eq.charAt(1) == '=') {
                uf.union(x - 'a', y - 'a');
            }
        }

        for (String eq : equations) {
            char x = eq.charAt(0);
            char y = eq.charAt(3);
            if (eq.charAt(1) == '!') {
                if (uf.connected(x - 'a', y - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }
}
