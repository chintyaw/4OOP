// SUBKELAS UTK KARTU Draw2, Reverse, Skip

public class KartuMagic1Warna extends Unocard {
    private String face; // FACE KARTU Draw2 atau Reverse atau Skip
    //KONSTRUKTOR
    public KartuMagic1Warna (String color, String face){
    super (String color);
    this.face = face;
    }
    //METHOD
    public String getFace(){
        return face;
    }
    public void setFace(String face){
        this.face = face;
    }
}
