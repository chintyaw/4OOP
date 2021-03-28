// SUBKELAS UTK KARTU Draw4 atau Wildcard

public class KartuMagicWarnaPelangi extends Unocard {
    private String face; //FACE KARTU : Draw4 ATAU Wildcard
    //KONSTRUKTOR
    public KartuMagicWarnaPelangi (String face){
    super ();
    this.face = face;
    this.color = 'Pelangi';
    }
    //METHOD
    public String getFace(){
        return face;
    }
    public void setFace(String face){
        this.face = face;
    }
}
