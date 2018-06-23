package tk.omgpi.forge;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tk.omgpi.forge.commands.IngameCommand;
import tk.omgpi.forge.config.MainConfig;
import tk.omgpi.forge.game.Game;
import tk.omgpi.forge.world.OMGWorld;
import tk.omgpi.forge.world.OMGWorldProvider;

import java.io.File;
import java.util.List;
import java.util.Random;

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

    public static List<Game> games;


    @Mod.EventHandler
    public static void onForgePreInit(FMLPreInitializationEvent e){
        MinecraftForge.EVENT_BUS.register(i);
        dir = new File(e.getModConfigurationDirectory() + File.separator + "OMGPI");
        main = new MainConfig();
        OMGWorld.type = DimensionType.register(ID, "ingame", 1811, OMGWorldProvider.class, false);
        ingame = new OMGWorld(1811);
        main.loadSQL();
    }

    public static void onInit() {
        if(games.size() == 0) throw new RuntimeException("No games registered!");
        if(main.hasGame()) {
            String game = main.getGame();
            if(games.stream().filter(x -> x.getName().equalsIgnoreCase(game)).count() != 0) {
                loadGame(games.stream().filter(x -> x.getName().equalsIgnoreCase(game)).findFirst().orElse(null));
                return;
            }
        }
        loadGame(games.get(new Random().nextInt(games.size())));
    }

    public static void loadGame(Game game){
        OMGPI.game = game;
        MinecraftForge.EVENT_BUS.register(game);
        game.onEnable();
    }

    public static void reload(){
        MinecraftForge.EVENT_BUS.unregister(game);
    }

    @Mod.EventHandler
    public static void onForgeServerStart(FMLServerStartingEvent e){
        e.registerServerCommand(new IngameCommand());
    }

}
