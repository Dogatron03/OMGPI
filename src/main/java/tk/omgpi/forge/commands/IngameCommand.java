package tk.omgpi.forge.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import tk.omgpi.forge.OMGPI;
import tk.omgpi.forge.world.OMGWorldProvider;

import static tk.omgpi.forge.utils.PlayerTeleporter.teleportToDimension;

public class IngameCommand extends CommandBase {

    public String getName() {
        return "ingame";
    }

    public String getUsage(ICommandSender sender) {
        return "ingame";
    }

    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if(sender instanceof EntityPlayerMP){
            EntityPlayerMP p = getCommandSenderAsPlayer(sender);
            teleportToDimension(p, 1811, 0, 128, 0);
        } else {
            throw new CommandException("Must be a player!");
        }
    }

    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }



}
