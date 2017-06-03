import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

// interface Comparable
// exige implementação do método comparaTo
public class Contato implements Comparable<Contato> {
    private String nome;
    private String sobrenome;
    private String telefone;
    private GregorianCalendar dataNasc;


    public Contato() {
        super ( );
    }

    public Contato(String nome, String sobrenome, String telefone, int dia, int mes, int ano) {
        super ( );
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        dataNasc = new GregorianCalendar ( ano, (mes - 1), dia );

    }

    public void setDataNasc(int dia, int mes, int ano) {
        dataNasc = new GregorianCalendar ( ano, (mes - 1), dia );
    }

    public String toString() {
        return nome;
    }

    public int compareTo(Contato c) {
        return this.nome.compareToIgnoreCase ( c.nome );
        // usando metodo compareToIgnoreCase da classe String
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascString() {
        SimpleDateFormat sdf = new SimpleDateFormat ( "dd.MM.yyyy" );
        String sDataNasc = sdf.format ( dataNasc.getTime ( ) );
        return sDataNasc;
    }

    public int getIdade() {
        int idade;
        GregorianCalendar hoje = new GregorianCalendar ( );
        GregorianCalendar aniversario = new GregorianCalendar ( hoje.get ( Calendar.YEAR ),
                dataNasc.get ( Calendar.MONTH ), dataNasc.get ( Calendar.DAY_OF_MONTH ) );
        idade = hoje.get ( Calendar.YEAR ) - dataNasc.get ( Calendar.YEAR );
        if (aniversario.after ( hoje )) {
            idade--;
        }
        return idade;
    }

    public String getDataNascStringDDMM() {
        SimpleDateFormat sdf = new SimpleDateFormat ( "MM.dd.yyyy" );
        String sDataNasc = sdf.format ( dataNasc.getTime ( ) );
        return sDataNasc;
    }


}





