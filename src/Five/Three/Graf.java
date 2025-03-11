import java.util.*;

class Graf {
    private int n; // liczba wierzchołków, V = {0,1,...,n-1}
    private LinkedList[] tab; // tablica wierzchołków połączo-
    // nych z danym wierzcholkiem

    public Graf(String lan) {
        StringTokenizer st = new StringTokenizer(lan, "() ,");
        n = Integer.parseInt(st.nextToken());
        tab = new LinkedList[n];
        for (int i = 0; i < n; ++i)
            tab[i] = new LinkedList();
        while (st.hasMoreTokens()) {
            tab[Integer.parseInt(st.nextToken())].add(
                    new Integer(st.nextToken()));
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        Iterator it;
        for (int i = 0; i < tab.length; i++) {
            sb.append(i + ":");
            it = tab[i].iterator();
            while (it.hasNext()) {
                sb.append(" " + it.next());
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
