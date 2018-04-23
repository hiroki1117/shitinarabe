package hiroki;

import java.util.List;

import hiroki.cards.Card;

/**
 * Created by hiroki on 2018/04/22.
 */
public class Dealer {
    private Field field;
    private List<Player> players;

    private int passNum = 3;

    public Dealer(Field field){
        this.field = field;
        players = field.getPlayers();
    }

    public void gameStart(){
        //最初の盤面表示
        field.display();

        while(!field.beFinish()) {
            foo();
        }
    }

    private void foo(){
        int index = field.calcuIndex();
        Player p = players.get(index);
        Action action = p.play();

        while(!jugdeAction(p, action)) {
            action = p.play();
        }

        if(p.getPass() == passNum){
            p.setIsActive(false);
        }

        field.display();
    }


    private boolean jugdeAction(Player player, Action action){
        //passだったら何もしない
        if(action.isPass()) return true;

        Card c = action.getCard();
        return field.tryPutCard(c) && player.deleteCard(c);
    }
}
