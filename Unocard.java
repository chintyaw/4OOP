public class Unocard
{
  // ATTRIBUT
    private int value;      // NILAI KARTU (0-9)
    private String color;   // WARNA (Merah, Kuning, Hijau, Biru)

  // KONSTRUKTOR
    public Unocard (int value, String color){
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
    public void setValue(int value){
      this.value = value;
    }
    public void setColor(String color){
      this.color = color;
    }
}
