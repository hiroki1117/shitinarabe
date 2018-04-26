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
    	//初期処理
    	//手札にある七を出す
    	initialize();
        //最初の盤面表示
        field.display();

        while(!field.beFinish()) {
            play();
        }

        //最後に盤面と結果を表示
        field.display();
        field.displayResult();
    }

    private void play(){
    	field.display();

        int index = field.calcuIndex();

        Player p = players.get(index);
        Action action = p.play();

        while(!jugdeAction(p, action)) {
            action = p.play();
        }

        //pass3回でそのプレイヤーは終わり
        if(p.getPass() == passNum){
            p.setIsActive(false);
            field.addLoser(p);
        }

        //playerの手札が0になり、あがった場合の処理
        if(p.getTehudaSize() == 0) {
        	p.setIsActive(false);
        	field.addWinner(p);
        }


    }


    //playerの行動をみて、ルール的に正しいか判定
    //正しければtrue
    private boolean jugdeAction(Player player, Action action){
        //passだったら何もしない
        if(action.isPass()) return true;

        Card c = action.getCard();
        return field.tryPutCard(c) && player.deleteCard(c);
    }

    private void initialize() {
    	for(int i=0; i<4; i++){
			if(players.get(i).haveDiaSeven()) field.setIndex(i);
		}
    }
}
