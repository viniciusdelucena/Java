public class Test {
  
  public static void main(String[] args) {
    Moto h1 = new Moto("Fatboy", "Harley Davidson", 1900);


    System.out.println(h1.getModelo() + "\n" + h1.getMarca() + "\n" + h1.getCilindrada() + "\n" + Moto.getVelmax() + "\n");

    Moto.setVelmax(200);

    System.out.println(h1.getModelo() + "\n" + h1.getMarca() + "\n" + h1.getCilindrada() + "\n" + Moto.getVelmax() + "\n");

    
  }
}