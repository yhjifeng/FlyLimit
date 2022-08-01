package me.xcmc.flylimit;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static me.xcmc.flylimit.FlyLimit.main;

public class Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if(args[0].equals("reload")){
            main.reloadConfig();
            sender.sendMessage("§a插件重载完毕！");
        }
        return false;
    }
}
