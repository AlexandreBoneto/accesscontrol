import java.io.IOException;
import java.util.Scanner;

public class Desafio {

  @SuppressWarnings("checkstyle:CommentsIndentation")
  public static void main(String[] args) throws IOException {
    Scanner leitor = new Scanner(System.in);
    int x = leitor.nextInt();
    int cont = 0;

//continue a solucao de acordo com o solicitado no enunciado

    while ( leitor.hasNext() ) {
      if ( x > 0) {  // Se o item for maior que zero
        cont++   ;
      }
      x = leitor.nextInt();
    }

    System.out.print(cont + " valores positivos");
  }

}