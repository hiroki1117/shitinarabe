package hiroki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hiroki.cards.Card;

public class RandomGenerator {

	private static final int TRANP = 52;

	public static void giveOutHand(Player p1, Player p2, Player p3, Player p4) {
		List<Integer> randomList = randomGenertor();


		p1.setTehuda(createTehuda(triming(randomList, 1)));
		p2.setTehuda(createTehuda(triming(randomList, 2)));
		p3.setTehuda(createTehuda(triming(randomList, 3)));
		p4.setTehuda(createTehuda(triming(randomList, 4)));
	}


	public static List<Integer> randomGenertor() {
		List<Integer> list = new ArrayList<>(52);

		for(int i=0; i<TRANP; i++) list.add(i);

		Collections.shuffle(list);

		return list;

		/*
		int[] array = new int[54];
		for(int i=0; i<TRANP; i++) array[i] += (i+1);
		*/


	}

	public static List<Card> createTehuda(List<Integer> list) {
		List<Card> result = new ArrayList<>(13);

		if(list.size() == result.size())
			System.exit(1);

		for(Integer i : list) {
			result.add(Card.create(i));
		}


		return result;
	}

	//numberには何人目かを入れる
	public static List<Integer> triming(List<Integer> list, int number){
		List<Integer> result = new ArrayList<>(13);

		int i = 13*(number-1);
		int z = i + 13;

		for(; i<z; i++) {
			result.add(list.get(i));
		}
		return result;

	}
}
