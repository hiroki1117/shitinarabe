package hiroki;

import hiroki.strategy.ShitinarabeStrategy;

/**
 * Created by hiroki on 2018/04/22.
 */
public class Computer extends Player{

    private boolean[][] field;
    private ShitinarabeStrategy strategy;
    private String mode = "N";

    public Computer(String name, ShitinarabeStrategy strategy){
        super(name);
        this.strategy = strategy;
    }

    public void setField(Field field){
        this.field = field.getField();
    }

    @Override
    public Action play() {

    	switch(mode) {
    	case "N":
    		modeNormal();
    		break;
    	case "Q":
    		break;
    	default:
    		modeNormal();
    	}


        return strategy.decide(this, field);
    }

    private void modeNormal() {
    	try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void modeEnter() {
    }

    public void setMode(String mode) {
    	this.mode = mode;
    }


}
