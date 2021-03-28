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
    public void setValue(int value){
        super.setValue(int value);
    }
    public void setColor(String color){
        super.setColor(String color);
    }
    public void setFace(String face){
        this.face = face;
    }
}
