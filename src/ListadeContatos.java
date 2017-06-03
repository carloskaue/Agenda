import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListadeContatos {

    private ArrayList<Contato> lc;

    public ListadeContatos() {
        lc = new ArrayList<Contato> ( );
    }

    public void addContato(Contato contato) {
        lc.add ( contato );
    }

    public Contato getContato(int indice) {
        return lc.get ( indice );
    }

    public int size() {
        return lc.size ( );
    }

    public void ordenaNomeAZ() {
        Collections.sort ( lc );
    }

    public void ordenaSobrenomeAZ() {
        Collections.sort ( lc, new Comparator<Contato> ( ) {
            public int compare(Contato c1, Contato c2) {
                return c1.getSobrenome ( ).compareTo ( c2.getSobrenome ( ) );
            }
        } );
    }

    public void ordenaDataNasc() {
        Collections.sort ( lc, new Comparator<Contato> ( ) {
            public int compare(Contato c1, Contato c2) {
                return c1.getDataNascStringDDMM ( ).compareTo ( c2.getDataNascStringDDMM ( ) );
            }

        } );
    }

}












