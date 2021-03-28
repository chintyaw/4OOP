package Cards;

public class Card {
    private String color = "";
    public Card (String color){
        this.color = color;
    }

    public Card(){}

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    // return -1 kalau tidak ada number
    public int getNumber() {
        return -1;
    }
}
