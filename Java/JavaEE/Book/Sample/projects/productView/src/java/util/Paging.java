package util;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class Paging implements Serializable {

    protected int max;							// データ件数
    protected int[] pos;						// 表示位置 pos[0]～pos[1]
    protected int dpp;							// １ページの表示件数

    @Inject
    protected transient Logger log;		// ロガー

    public Paging() {
        pos = new int[2];
    }

    public void setup(int max, int cnt) {
        this.max = max - 1;
        dpp = max < cnt ? max : cnt;
        this.pos[0] = 0;
        this.pos[1] = dpp - 1;

        log.log(Level.FINE, "◆*** max={0} ***", this.max);
        log.log(Level.FINE, "◆*** dsp={0} ***", dpp);
        log.log(Level.FINE, "◆*** {0}/{1}/{2}/{3} ***", new Object[]{max, dpp, pos[0], pos[1]});
    }

    public void next() {
        if (pos[0] <= max - dpp) {
            pos[0] += dpp;
            pos[1] = pos[1] + dpp < max ? pos[1] + dpp : max;
            log.log(Level.FINE, ">>>> P <<<{0}/{1}/{2}/{3}", new Object[]{max, dpp, pos[0], pos[1]});
        }
    }

    public void back() {
        if (pos[0] - dpp >= 0) {
            pos[0] -= dpp;
            pos[1] = pos[0] + dpp - 1 < max ? pos[0] + dpp - 1 : max;
            log.log(Level.FINE, ">>> M <<<{0}/{1}/{2}/{3}", new Object[]{max, dpp, pos[0], pos[1]});
        }
    }

    public void top() {
        pos[0] = 0;
        pos[1] = pos[0] + dpp - 1 < max ? pos[0] + dpp - 1 : max;
        log.log(Level.FINE, ">>> T <<<{0}/{1}/{2}/{3}", new Object[]{max, dpp, pos[0], pos[1]});
    }

    public void bottom() {
        pos[0] = dpp * (max / dpp);
        pos[1] = pos[0] + dpp < max ? pos[0] + dpp : max;
        log.log(Level.FINE, ">>> B <<<{0}/{1}/{2}/{3}", new Object[]{max, dpp, pos[0], pos[1]});
    }

    public int firstResult() {
        return pos[0];
    }

    public int maxResult() {
        return pos[1] - pos[0] + 1;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int[] getPos() {
        return pos;
    }

    public void setPos(int[] pos) {
        this.pos = pos;
    }

    public int getDpp() {
        return dpp;
    }

    public void setDpp(int dpp) {
        this.dpp = dpp;
    }

}
