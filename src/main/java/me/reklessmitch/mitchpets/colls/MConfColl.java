package me.reklessmitch.mitchpets.colls;

import com.massivecraft.massivecore.store.Coll;
import me.reklessmitch.mitchpets.entity.MConf;

public class MConfColl extends Coll<MConf> {
    private static final MConfColl i = new MConfColl();
    public static MConfColl get() { return i; }

    @Override
    public void setActive(boolean active) {
        super.setActive(active);
        if(!active){
            return;
        }
        MConf.i = this.get("insane", true);
    }

}
