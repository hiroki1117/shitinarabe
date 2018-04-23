package hiroki.cards;

public class Spade extends Card{

	static String mark = "S";

	public Spade(int num) {
		super(num, mark);
	}

	@Override
	void displayCard() {

	}

	public String toString() {return mark + num;}

}
