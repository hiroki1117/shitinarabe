package hiroki.cards;

public class Heart extends Card {
	static String mark = "H";


	public Heart(int num) {
		super(num, mark);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String toString() {return mark + num;}

}
