package hiroki;

import hiroki.strategy.LinearStrategy;
import hiroki.strategy.RandomPassStrategy;
import hiroki.strategy.RandomStrategy;

public class Main {
	public static void main(String[] args) {



		//playerを用意
		//CPには対戦アルゴリズムを渡す
		Player p1 = new Human("you");
		Player p2 = new Computer("com1", new LinearStrategy());
		Player p3 = new Computer("com2", new RandomStrategy());
		Player p4 = new Computer("com3", new RandomPassStrategy(0.5));

		//引数をチェック
		checkMode(args, (Computer)p2, (Computer)p3, (Computer)p4);

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

	public static void checkMode(String[] args, Computer... coms) {
		if(args.length != 0) {
			String mode = args[0];
			switch(mode) {
			case "-q":
				for(Computer c : coms) {
					c.setMode("Q");
				}
				break;
			}
		}
	}


	public static void readyComputer(Field field, Computer... coms){
		for(Computer c : coms){
			c.setField(field);
		}
	}
}
