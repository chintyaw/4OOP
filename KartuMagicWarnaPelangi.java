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
