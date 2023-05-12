package fr.nicolol123.sweeter0.commands;

import fr.nicolol123.sweeter0.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class testCommand implements CommandExecutor {
    private final Main main;
    public testCommand(Main main) {this.main = main;}
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        // Si il n'y a pas d'argument, on recale le sender
        if(args.length == 0){
            String argumentManquant = main.getConfig().getString("argument-manquant");
            assert argumentManquant != null;
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', argumentManquant));
            return false;

        // On vérifie si l'argument est "joueurTotal" pour effectuer diverses opérations
        } else if(args[0].equalsIgnoreCase("joueurTotal")){
            @NotNull OfflinePlayer[] horsLigne = Bukkit.getServer().getOfflinePlayers();
            String enLigne = Bukkit.getServer().getOnlinePlayers().toString();
            sender.sendMessage(ChatColor.RED + Arrays.toString(horsLigne) + enLigne);
            return true;
        // On vérifie si l'argument est "playtime" pour effectuer diverses opérations
        } else if(args[0].equalsIgnoreCase("playtime")) {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            // On vérifie que le joueur existe ou est en ligne
            if(target == null){
                String joueurInvalide = main.getConfig().getString("joueur-invalide");
                assert joueurInvalide != null;
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', joueurInvalide));
                return false;
            } else {
                // Pour de futures maj
                sender.sendMessage("soon");
                return true;
            }
        }

        return false;
    }
}
