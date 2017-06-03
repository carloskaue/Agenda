import java.util.Scanner;

public class Agenda {


    public static Interface terminal = new Interface ( );

    public static void main(String[] args) {

        Scanner teclado = new Scanner ( System.in );
        int tecladoint = -1;

        while (tecladoint != 0) {

            System.out.println ( terminal.ExebirMenu ( ) );
            tecladoint = teclado.nextInt ( );
            terminal.MenuLista ( tecladoint );
        }


    }

}