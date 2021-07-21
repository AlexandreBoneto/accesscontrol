/**
 * No tag (ok).
 *
 * <p>Tag immediately before the text (ok).
 *
 * <p>No blank line before the tag (violation).
 *
 * <p>New line after tag (violation).
 *
 * <p>Whitespace after tag (violation).
 *
 */
public class Carro {
  private String marca;
  private String modelo;

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public int getQtdPessoas() {
    return qtdPessoas;
  }

  public void setQtdPessoas(int qtdPessoas) {
    this.qtdPessoas = qtdPessoas;
  }

  int qtdPessoas;

  public String getMarca() {
    return marca;
  }
}
