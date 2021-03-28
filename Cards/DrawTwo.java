package Cards;

public class DrawTwo extends Card{
    public DrawTwo(String color) {
        super(color);
    }

    public String toString()
    {
        return "Draw 2 " + super.getColor();
    }
}
