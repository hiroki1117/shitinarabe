package hiroki;

import java.util.Collections;
import java.util.List;

import hiroki.cards.Card;
import hiroki.cards.Club;
import hiroki.cards.Dia;
import hiroki.cards.Heart;
import hiroki.cards.Spade;

public abstract class Player {
	protected String name;
	protected List<Card> tehuda;
	protected int pass = 0;
	protected boolean isActive = true;


	public Player(String name) {
		this.name = name;
	}

	public abstract Action play();

	public boolean deleteCard(Card card){
		return tehuda.remove(card);
	}


	public boolean haveDiaSeven() {
		boolean flg = tehuda.contains(new Dia(7));

		//ダイアのセブンを探すタイミングで７を手札から除去
		tehuda.remove(new Dia(7));
		tehuda.remove(new Spade(7));
		tehuda.remove(new Heart(7));
		tehuda.remove(new Club(7));

		return flg;
	}

	public void addPass(){pass ++;}

	public void setTehuda(List<Card> gived) {
		tehuda = gived;
		//ソートもする
		Collections.sort(tehuda);
	}

	public boolean getIsActive() {return isActive;}

	public void setIsActive(boolean flg) {
		isActive = flg;
	}

	public String getName() {return name;}

	public int getPass(){ return pass;}

	public int getTehudaSize(){
		return tehuda.size();
	}

	public List<Card> getTehuda(){return tehuda;}

	public void showTehud() {
		for(Card c : tehuda) {
			System.out.print(c.toString() + " ");
		}
		System.out.println();
	}
	
	

}
