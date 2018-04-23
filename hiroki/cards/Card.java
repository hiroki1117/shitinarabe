package hiroki.cards;

public class Card implements Comparable{
	protected String mark;
	protected int num;
	protected int wholeNumber;

	Card(int num, String mark){
		this.num = num;
		this.mark = mark;

		int markNum = 0;
		switch(mark){
			case "C":
				break;
			case "H":
				markNum += 13;
				break;
			case "S":
				markNum += 26;
				break;
			case "D":
				markNum += 39;
				break;
		}
		wholeNumber = markNum + num;
	}

	void displayCard() {
		System.out.println();
	};

	public static Card create(int num) {
		Card card = null;
		int kind = num / 13;
		int amari = num % 13 + 1;

		switch(kind) {
		case 0:
			card = new Spade(amari);
			break;
		case 1:
			card = new Heart(amari);
			break;
		case 2:
			card = new Dia(amari);
			break;
		case 3:
			card = new Club(amari);
			break;
		}

		return card;
	}

	public int getWholeNumber(){return wholeNumber;}

	public String toString() {return mark + num;}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Card) {
			return (this.mark == ((Card) obj).mark) && (this.num == ((Card) obj).num);
		}

		return false;
	}

	public String getMark() {
		return mark;
	}

	public int getNum() {
		return num;
	}

	@Override
	public int compareTo(Object o) {
		Card c = (Card)o;
		return this.wholeNumber - c.getWholeNumber();
	}
}
