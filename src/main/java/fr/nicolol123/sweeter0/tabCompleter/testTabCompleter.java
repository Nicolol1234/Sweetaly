package fr.nicolol123.sweeter0.tabCompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testTabCompleter implements TabCompleter {
    // On dit quelles sont les arguments a afficher quand on appuie sur tab
    private static final List<String> COMMANDS = Arrays.asList("joueurTotal", "playtime");
    //On les appliques
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        return (args.length > 0) ? StringUtil.copyPartialMatches(args[0], COMMANDS, new ArrayList<>()) : null;
    }
}
