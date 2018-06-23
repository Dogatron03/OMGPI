package tk.omgpi.forge;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import tk.omgpi.forge.commands.IngameCommand;
import tk.omgpi.forge.config.MainConfig;
import tk.omgpi.forge.game.Game;
import tk.omgpi.forge.world.OMGWorld;
import tk.omgpi.forge.world.OMGWorldProvider;

import java.io.File;

import static tk.omgpi.forge.OMGPI.*;

@Mod.EventBusSubscriber
@Mod(modid = ID, name = NAME, version = VERSION, acceptedMinecraftVersions = MCVERSION, serverSideOnly = true, acceptableRemoteVersions = "*")
public class OMGPI {

    public static final String ID = "omgpi";
    public static final String NAME = "OMGPI";
    public static final String VERSION = "1.12.2@1";
    public static final String MCVERSION = "[1.12.2]";

    @Mod.Instance
    public static OMGPI i;

    public static Game game;
    public static MainConfig main;
    public static File dir;
    public static OMGWorld ingame;


    @Mod.EventHandler
    public static void onForgePreInit(FMLPreInitializationEvent e){
        MinecraftForge.EVENT_BUS.register(i);
        dir = new File(e.getModConfigurationDirectory() + File.separator + "OMGPI");
        main = new MainConfig();
        OMGWorld.type = DimensionType.register(ID, "ingame", 1811, OMGWorldProvider.class, false);

    }

    @Mod.EventHandler
    public static void onForgeServerStart(FMLServerStartingEvent e){
        e.registerServerCommand(new IngameCommand());
    }

}
