// SUBKELAS UTK KARTU Draw4 atau Wildcard

public class KartuMagicWarnaPelangi extends Unocard {
    private String face; //FACE KARTU : Draw4 ATAU Wildcard
    //KONSTRUKTOR
    public KartuMagicWarnaPelangi (String face){
    super();
    this.value = null;
    this.face = face;
    this.color = 'Pelangi';
    }
    //METHODS
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
