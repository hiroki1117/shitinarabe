package hiroki;

import hiroki.strategy.LinearStrategy;
import hiroki.strategy.RandomPassStrategy;
import hiroki.strategy.RandomStrategy;

public class Main {
	public static void main(String[] args) {
		//playerを用意
		Player p1 = new Human("hiroki");
		Player p2 = new Computer("com1", new LinearStrategy());
		Player p3 = new Computer("com2", new RandomStrategy());
		Player p4 = new Computer("com3", new RandomPassStrategy(0.5));

		//手札を配る
		RandomGenerator.giveOutHand(p1, p2, p3, p4);

		//フィールドを用意
		Field field = Field.createField(p1, p2, p3, p4);
		//コンピューター(敵)の準備
		readyComputer(field, (Computer)p2, (Computer)p3, (Computer)p4);

		//ディーラーを用意
		Dealer dealer = new Dealer(field);

		//ゲーム開始
		dealer.gameStart();
	}


	public static void readyComputer(Field field, Computer... coms){
		for(Computer c : coms){
			c.setField(field);
		}
	}
}
