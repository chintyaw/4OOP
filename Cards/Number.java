package Cards;

public class Number extends Card{
    private int number;

    public Number(int number, String color)
    {
        super(color);
        this.number = number;
    }

    public int getNumber()
    {
        return number;
    }

    public String toString()
    {
        return number + " " + super.getColor();
    }
}
