package hiroki;

import hiroki.strategy.ShitinarabeStrategy;

/**
 * Created by hiroki on 2018/04/22.
 */
public class Computer extends Player{

    private boolean[][] field;
    private ShitinarabeStrategy strategy;

    public Computer(String name, ShitinarabeStrategy strategy){
        super(name);
        this.strategy = strategy;
    }

    public void setField(Field field){
        this.field = field.getField();
    }

    @Override
    public Action play() {

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return strategy.decide(this, field);
    }


}
