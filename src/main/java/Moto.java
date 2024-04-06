public class Moto{
  private String modelo;
  private String marca;
  private int cilindrada;
  private static int velmax = 250;

  public Moto(String modelo, String marca, int cilindrada){
    this.modelo = modelo;
    this.marca = marca;
    this.cilindrada = cilindrada;
  }

  public String getModelo(){
    return modelo;
  }

  public void setModelo(String modelo){
    this.modelo = modelo;
  }  

  public String getMarca(){
    return marca;
  }

  public void setMarca(String marca){
    this.marca = marca;
  }

  public int getCilindrada(){
    return cilindrada;
  }

  public void setCilindrada(int cilindrada){
    this.cilindrada = cilindrada;
  }

  public static int getVelmax(){
    return velmax;
  }

  public static void setVelmax(int velmax){
    Moto.velmax = velmax;
  }

}