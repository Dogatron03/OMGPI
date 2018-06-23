package tk.omgpi.forge.world;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;

public class OMGWorld {

    public static DimensionType type;
    public int id;

    public OMGWorld(int id) {
        this.id = id;
    }

    public WorldServer getWorld(){
        return DimensionManager.getWorld(id);
    }

    public void load(){
        DimensionManager.registerDimension(id, type);
    }

    public void unload(){
        DimensionManager.unloadWorld(id);
        DimensionManager.unregisterDimension(id);
    }

}
