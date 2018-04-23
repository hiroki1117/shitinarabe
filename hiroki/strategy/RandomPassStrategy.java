package hiroki.strategy;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import hiroki.Action;
import hiroki.Player;
import hiroki.cards.Card;

public class RandomPassStrategy implements ShitinarabeStrategy {

	private double passRatio;
	private Random random;

	public RandomPassStrategy(double passRatio) {
		this.passRatio = passRatio;
		random = new Random();
	}

	@Override
	public Action decide(Player player, boolean[][] field) {
		List<Card> tehuda = player.getTehuda();


		if(cardOrPass(random, passRatio, player)) {
			//ランダムに
			Collections.shuffle(tehuda);
			for(Card card : player.getTehuda()){
				String mark = card.getMark();
				int num = card.getNum() - 1;
				int kind = 0;
				switch(mark){
                	case "C":
                		break;
                	case "H":
                		kind = 1;
                		break;
                	case "S":
                		kind = 2;
                		break;
                	case "D":
                		kind = 3;
                		break;
				}

				if(num < 6){
					if(field[kind][num+1]){
						return Action.pullOut(card);
					}
				}else{
					if(field[kind][num-1]){
						return Action.pullOut(card);
					}
				}
			}
		}else {
			return Action.pass(player);
		}


        return Action.pass(player);
	}

	private boolean cardOrPass(Random rm, double ratio, Player p) {
		//次パスしたらゲーム終了ならば、passはしない
		if(p.getPass() == 2) return true;

		//ratioの確率でパス優先
		//返り値trueでCard選択
		return ratio < rm.nextDouble();
	}

}
