package hiroki;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hiroki.cards.Card;

public class Field {
	private boolean[][] field = new boolean[4][13];
	private List<Player> players = new ArrayList<>();
	private Map<Integer, String> rank = new HashMap<>();

	private Integer index = null;


	private Field(Player p1, Player p2, Player p3, Player p4) {
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);

		//七をおく
		field[0][6] = true;
		field[1][6] = true;
		field[2][6] = true;
		field[3][6] = true;
	}

	public static Field createField(Player p1, Player p2, Player p3, Player p4) {

		return new Field(p1,p2,p3,p4);
	}

	public boolean beFinish(){
		int winner = 0;

		for(Player p : players){
			if(!p.isActive) winner ++;
		}

		return winner >= 3;
	}

	public boolean tryPutCard(Card card){
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
				field[kind][num] = true;
				return true;
			}else return false;
		}else{
			if(field[kind][num-1]){
				field[kind][num] = true;
				return true;
			}else return false;
		}
	}

	public int calcuIndex(){
		if(index == null){
			for(int i=0; i<4; i++){
				if(players.get(i).haveDiaSeven()) index = i;
			}
			return index;
		}

		index = (index + 1) % 4;
		if(players.get(index).getIsActive()) return index;
		else return calcuIndex();
	}

	public void display(){
		displayCom();
		displayField();
		displayMyTehuda();
	}

	private void displayCom(){
		System.out.print("     ");

		int i = 0;
		for(; i<4; i++){
			if(players.get(i) instanceof Human) {
				i++;
				break;
			}
		}

		for(int j=0; j < 3; j++){
			Player p = players.get(i%4);
			String output = p.getName() + " 手札:" + p.getTehudaSize() + " パス:" + p.getPass();

			if(index != null && index == (i - 1)){
				String red = "\u001b[31m";
				String reset = "\u001b[0m";
				output = red + output + reset;
			}

			System.out.print(output);
			System.out.print("  ");
			i++;
		}

		System.out.println("\n");
	}

	private void displayMyTehuda(){
		Human h = null;
		for(Player p : players){
			if(p instanceof Human) h = (Human)p;
		}
		h.showTehud();
		System.out.println();
	}

	public void displayField() {

		System.out.print("　　　　  ");
		for(int i=0; i<13; i++) {
			if(i<10) {
				System.out.print((i+1) + " ");
			}else {
				switch(i) {
				case 10:
					System.out.print('J' + " ");
					break;
				case 11:
					System.out.print('Q' + " ");
					break;
				case 12:
					System.out.print('K' + " ");
					break;
				}
			}
		}
		System.out.println();

		for(int i=0; i<4; i++) {
			switch(i) {
			case 0:
				System.out.print("くろーば");
				break;
			case 1:
				System.out.print("　はーと");
				break;
			case 2:
				System.out.print("すぺーど");
				break;
			case 3:
				System.out.print("　だいあ");
				break;

			}

			System.out.print("  ");


			for(int j=0; j<13; j++) {
				if(field[i][j]) {
					System.out.print("* ");
				}else {
					System.out.print("o ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public List<Player> getPlayers(){ return players;}

	public boolean[][] getField(){return field;}

}
