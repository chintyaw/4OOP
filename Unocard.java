public class Unocard
{
  // ATTRIBUT
    private int value;      // NILAI KARTU (0-9)
    private String color;   // WARNA (Merah, Kuning, Hijau, Biru)

  // KONSTRUKTOR
    public Unocard (int value, String color, String face){
      this.value = value;
      this.color = color;
    }

  // METHODS
  //Getter
    public int getValue(){
      return value;
    }
    public String getColor(){
      return color;
    }
  //Setter
    public void setValue(int x){
      this.value = x;
    }
    public void setColor(int y){
      this.color = y;
    }
}