package fr.nicolol123.sweeter0.commands;

import fr.nicolol123.sweeter0.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class profilCommand implements CommandExecutor {
    // On importe la classe principale pour avoir accès a la config du plugin
    private final Main main;
    public profilCommand(Main main) {this.main = main;}
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(args.length == 0){
            String argumentManquant = main.getConfig().getString("argument-manquant");
            assert argumentManquant != null;
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',argumentManquant));
        } else {
            Player target = sender.getServer().getPlayer(args[0]);
            if(target == null){
                String joueurInvalide = main.getConfig().getString("joueur-invalide");
                assert joueurInvalide != null;
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', joueurInvalide));
                return false;
            } else {
                sender.sendMessage(ChatColor.GRAY + "Voici les informations sur " + ChatColor.RED + target.getName());
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7&lInformations Utiles:\n"));
                sender.sendMessage(ChatColor.GRAY + "Nom du/de launcher/version: " + ChatColor.RED + target.getClientBrandName());
                sender.sendMessage(ChatColor.RED + "Notez que Fabric ou Forge PEUT coller avec un doute de cheat.");
                sender.sendMessage(ChatColor.GRAY + "Version: " + ChatColor.RED + target.getProtocolVersion());
                sender.sendMessage(ChatColor.GRAY + "IP: " + ChatColor.RED + target.getAddress());
                sender.sendMessage(ChatColor.GRAY + "Ping actuel: " + ChatColor.RED + target.getPing());
                sender.sendMessage(ChatColor.GRAY + "Effects de potions: " + ChatColor.RED + target.getActivePotionEffects());
                sender.sendMessage(ChatColor.GRAY + "Vie actuelle: " + ChatColor.RED + target.getHealth());
                sender.sendMessage(ChatColor.GRAY + "GameMode actuel: " + ChatColor.RED + target.getGameMode());
                sender.sendMessage(ChatColor.GRAY + "GameMode Précédent: " + ChatColor.RED + target.getPreviousGameMode());
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"\n&7&lAutres Informations:"));
                sender.sendMessage(ChatColor.GRAY + "Render Distance du client: " + ChatColor.RED + target.getClientViewDistance());
                sender.sendMessage(ChatColor.GRAY + "UUID: " + ChatColor.RED + target.getUniqueId());
                sender.sendMessage(ChatColor.GRAY + "XP: " + ChatColor.RED + target.getTotalExperience());
                sender.sendMessage(ChatColor.GRAY + "Niveau d'XP: " + ChatColor.RED + target.getLevel());
                sender.sendMessage(ChatColor.GRAY + "XP requise pour lvl up: " + ChatColor.RED + target.getExpToLevel());
                return true;
            }
        }
        return false;
    }
}

