package hiroki;

import java.util.Scanner;

import hiroki.cards.Card;

/**
 * Created by hiroki on 2018/04/22.
 */
public class Human extends Player {
    public Human(String name){
        super(name);
    }

    @Override
    public Action play() {
        String red = "\u001b[31m";
        String reset = "\u001b[0m";
        System.out.println(red + "カードの番号かpassを入力してください" + reset);
        System.out.print("->");

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if(input.equals("pass") || input.equals("p")) return Action.pass(this);

        int num = 0;
        Card c;
        try{
            num = Integer.parseInt(input);
            c = tehuda.get(num-1);
        }catch (NumberFormatException e){
            System.out.println("入力が不正");
            return play();
        }catch(NullPointerException e){
            System.out.println("入力が不正");
            return play();
        }catch(IndexOutOfBoundsException e){
            System.out.println("入力が不正");
            return play();
        }

        return Action.pullOut(c);
    }
}
