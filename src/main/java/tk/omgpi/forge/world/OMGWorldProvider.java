package tk.omgpi.forge.world;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.ChunkGeneratorFlat;
import net.minecraft.world.gen.IChunkGenerator;
import tk.omgpi.forge.OMGPI;

public class OMGWorldProvider extends WorldProvider {

    public DimensionType getDimensionType() {
        return OMGWorld.type;
    }

    public String getSaveFolder() {
        return "ingame";
    }

    public IChunkGenerator createChunkGenerator() {
        return new ChunkGeneratorFlat(world, 0, false, "2;0;1");
    }
}
