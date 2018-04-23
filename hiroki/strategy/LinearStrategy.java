package hiroki.strategy;

import java.util.List;

import hiroki.Action;
import hiroki.Player;
import hiroki.cards.Card;

/**
 * Created by hiroki on 2018/04/23.
 */
public class LinearStrategy implements ShitinarabeStrategy {
    @Override
    public Action decide(Player player, boolean[][] field) {
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
        return Action.pass(player);
    }
}
