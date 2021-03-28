package Cards;

public class Skip extends Card{
    public Skip(String color){
        super(color);
    }

    public String toString()
    {
        return "Skip " + super.getColor();
    }
}
