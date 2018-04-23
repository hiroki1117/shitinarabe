package hiroki;

import hiroki.cards.Card;

/**
 * Created by hiroki on 2018/04/22.
 */
public class Action {

    private Card card;
    private boolean pass = false;

    private Action(boolean flg){
        this.pass = flg;
    }

    private Action(Card card){
        this.card = card;
    }

    public static Action pass(Player p){
        p.addPass();
        return new Action(true);
    }

    public static Action pullOut(Card card){
        return new Action(card);
    }

    public Card getCard() {
        return card;
    }

    public boolean isPass() {
        return pass;
    }
}
