package tk.omgpi.forge.events;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import tk.omgpi.forge.OMGPI;
import tk.omgpi.forge.game.Game;

public class OMGInitEvent extends Event {

    public OMGInitEvent() {
        MinecraftForge.EVENT_BUS.post(this);
    }

    public OMGPI getOMGPI(){
        return OMGPI.i;
    }

    public void registerGame(Game game){
        OMGPI.games.add(game);
    }

}
