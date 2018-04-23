package hiroki.cards;

public class Club extends Card{
	static String mark = "C";

	public Club(int num) {
		super(num, mark);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String toString() {return mark + num;}

}
