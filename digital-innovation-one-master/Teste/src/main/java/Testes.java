import java.time.Instant;
import java.util.Date;
/**
 * <p> Java DOC</p>.
 */

public class Testes {
  /**
    <p> Java DOC</p>.
   */

  public static void main(String[] args) {

    Date dataNoPassado = new Date(1513124807691L);

    Date dataNoFuturo = new Date(1613124807691L);

    Date mesmaDataFuturo = new Date(1613124807691L);


    System.out.println(dataNoPassado);
    System.out.println(dataNoFuturo);
    System.out.println(mesmaDataFuturo);

    boolean isEqueals = dataNoFuturo.equals(mesmaDataFuturo);

    System.out.println(isEqueals);
  }
}