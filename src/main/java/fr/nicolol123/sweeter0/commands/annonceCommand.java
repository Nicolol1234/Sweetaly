package fr.nicolol123.sweeter0.commands;

import fr.nicolol123.sweeter0.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class annonceCommand implements CommandExecutor {
    //On importe la classe principale pour avoir accès a la config du plugin
    private final Main main;
    public annonceCommand(Main main) {this.main = main;}
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        // Si il n'y a pas d'argument, on recale le sender
        if(args.length == 0){
            String argumentManquant = main.getConfig().getString("argument-manquant");
            assert argumentManquant != null;
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', argumentManquant));
            return false;
        // Si il y a des arguments, on les assemble pour faire un message
        } else {
            StringBuilder str = new StringBuilder();
            for(String part : args){
                str.append(part).append(" ");
            }
            String annonce = str.toString();
            // On envoie le message a tt le monde
            // Vu que "broadcastMessage" est deprecated, j'utilise cette merde.
            for(Player p : Bukkit.getOnlinePlayers()){
                p.sendMessage(ChatColor.translateAlternateColorCodes('&',annonce));
            }
            return true;
        }
    }
}
