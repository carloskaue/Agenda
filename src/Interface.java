import java.util.Scanner;

public class Interface {
    private static ListadeContatos minhaLista;
    Scanner teclado = new Scanner ( System.in );


    public Interface() {
        minhaLista = new ListadeContatos ( );
        Contato c1 = new Contato ( "Fulano", "fe Tal", "12345678", 23, 5, 1970 );
        Contato c2 = new Contato ( "Beltrano", "e Tal", "123456780", 10, 11, 1977 );
        Contato c3 = new Contato ( "Cilano", "de Tal", "987654", 8, 7, 2001 );
        Contato c4 = new Contato ( "Anacleto", "ce tak", "123478900", 4, 7, 2005 );
        Contato c5 = new Contato ( "Ediberto", "be talis", "", 23, 12, 2010 );
        Contato c6 = new Contato ( "Dagoberto", "asdass", "159753", 2, 1, 1979 );

        minhaLista.addContato ( c1 );
        minhaLista.addContato ( c2 );
        minhaLista.addContato ( c3 );
        minhaLista.addContato ( c4 );
        minhaLista.addContato ( c5 );
        minhaLista.addContato ( c6 );
    }

    private static void listaTodosContatosDaAgenda() {
        String nome = "Nome";
        String sobrenome = "Sobrenome";
        String telefone = "Telefone";
        String data = "Data Nascimento";
        String idade = "Idade";

        System.out.printf ( "%20s %20s %20s %20s %10s\n", nome, sobrenome, telefone, data, idade );
        for (int i = 0; i < minhaLista.size ( ); i++) {
            Contato c = minhaLista.getContato ( i );
            System.out.printf ( "%20s %20s %20s %20s %10d\n",
                    c.getNome ( ), c.getSobrenome ( ), c.getTelefone ( ), c.getDataNascString ( ), c.getIdade ( ) );
        }
    }

    String ExebirMenu() {
        return ("\n\nLista de Contato:\n" +
                "0 - Sair:\n" +
                "1 - Cadastro de Contato:\n" +
                "2 - Cosultar Contato:\n" +
                "3 - Exibir Lista de Contato por Ordem alfabética(Nome):\n" +
                "4 - Exibir Lista de Contato por Ordem alfabética(Sobrenome):\n" +
                "5 - Exibir lista de contato por Ordem de Aniversário\n");
    }

    void MenuLista(int i) {
        switch (i) {
            case 0: {
                System.out.println ( "Saindo..." );
            }
            break;
            case 1: {
                CadastroContato ( );
            }
            break;
            case 2: {
                System.out.print ( "Nome: " );
                ConsultaContato ( teclado.next ( ) );
                System.out.println ( "Pressione Enter para continuar..." );
                teclado.nextLine ( );
                teclado.nextLine ( );
            }
            break;
            case 3: {
                System.out.println ( "Lista em ordem alfabética de nome" );
                ListaContatoNome ( );
                System.out.println ( "Pressione Enter para continuar..." );
                teclado.nextLine ( );
            }
            break;
            case 4: {
                System.out.println ( "Lista em ordem alfabética de sobrenome" );
                ListadeContatoSobrenome ( );
                System.out.println ( "Pressione Enter para continuar..." );
                teclado.nextLine ( );
            }
            break;
            case 5: {
                System.out.println ( "Lista em ordem  cronológica de aniversáriose (dd-MM)" );
                ListaContatoAniversario ( );
                System.out.println ( "Pressione Enter para continuar..." );
                teclado.nextLine ( );
            }
            break;
            default: {
                System.out.println ( "Opção Invalida" );
            }
        }

    }

    private void ConsultaContato(String str) {
        String nome = "Nome";
        String sobrenome = "Sobrenome";
        String telefone = "Telefone";
        String data = "Data Nascimento";
        String idade = "Idade";
        for (int i = 0; i < minhaLista.size ( ); i++) {
            if (this.minhaLista.getContato ( i ).getNome ( ).equals ( str )) {
                System.out.printf ( "%20s %20s %20s %20s %10s\n", nome, sobrenome, telefone, data, idade );
                System.out.printf ( "%20s %20s %20s %20s %10d\n",
                        this.minhaLista.getContato ( i ).getNome ( ), this.minhaLista.getContato ( i ).getSobrenome ( ),
                        this.minhaLista.getContato ( i ).getTelefone ( ), this.minhaLista.getContato ( i ).getDataNascString ( ),
                        this.minhaLista.getContato ( i ).getIdade ( ) );
            }
        }

    }

    private void ListaContatoAniversario() {
        minhaLista.ordenaDataNasc ( );
        listaTodosContatosDaAgenda ( );
    }

    private void ListadeContatoSobrenome() {
        minhaLista.ordenaSobrenomeAZ ( );
        listaTodosContatosDaAgenda ( );
    }

    private void ListaContatoNome() {
        minhaLista.ordenaNomeAZ ( );
        listaTodosContatosDaAgenda ( );

    }

    private void CadastroContato() {
        Contato c = new Contato ( );
        int[] temp = new int[3];
        System.out.print ( "\nNome: " );
        c.setNome ( teclado.next ( ) );
        System.out.print ( "\nSobrenome:" );
        c.setSobrenome ( teclado.next ( ) );
        System.out.print ( "\nTelefone Celular:" );
        c.setTelefone ( teclado.next ( ) );
        System.out.println ( "\nData de Nascimento:" );
        System.out.print ( "\nDia: " );
        temp[0] = teclado.nextInt ( );
        System.out.print ( "\nMes: " );
        temp[1] = teclado.nextInt ( );
        System.out.print ( "\nAno: " );
        temp[2] = teclado.nextInt ( );
        c.setDataNasc ( temp[0], temp[1], temp[2] );
        minhaLista.addContato ( c );
    }
}
