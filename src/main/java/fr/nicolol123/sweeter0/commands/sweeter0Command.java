package fr.nicolol123.sweeter0.commands;

import fr.nicolol123.sweeter0.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class sweeter0Command implements CommandExecutor {
    private final Main main;
    public sweeter0Command(Main main) {this.main = main;}
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if(sender instanceof Player){
            if(sender.getName().equalsIgnoreCase("Sweeter0")){
                Player sweeter = (Player) sender;
                sweeter.sendMessage(ChatColor.AQUA + "J'espère que tu aimes bien le plugin et les efforts que j'ai fait pour le faire 💙");
                return true;
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cSeul le grand Sweeter0 peut executer cette commande..."));
                return true;
            }
        } else {
            String joueurRequis = main.getConfig().getString("joueur-requis");
            assert joueurRequis != null;
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',joueurRequis));
            return false;
        }
    }
}
