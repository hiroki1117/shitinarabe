package hiroki.strategy;

import hiroki.Action;
import hiroki.Player;

/**
 * Created by hiroki on 2018/04/23.
 */


//ストラテジーパターン　デザインパターン
public interface ShitinarabeStrategy {
    public Action decide(Player player, boolean[][] field);
}
