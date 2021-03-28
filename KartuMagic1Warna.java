// SUBKELAS UTK KARTU Draw2, Reverse, Skip

public class KartuMagic1Warna extends Unocard {
    private String face; // FACE KARTU Draw2 atau Reverse atau Skip
    //KONSTRUKTOR
    public KartuMagic1Warna (String color, String face){
    super (String color);
    this.face = face;
    this.value = null;
    }
    //METHOD
    //Getter
    public String getValue(){
        return value;
    }
    public String getColor(){
        return color;
    )
    public String getFace(){
        return face;
    }
    //Setter
    public void setValue(String value){
        this.face = value;
    }
    public void setColor(String color){
        this.face = color;
    }
    public void setFace(String face){
        this.face = face;
    }
}
