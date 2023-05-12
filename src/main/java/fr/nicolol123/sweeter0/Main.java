package fr.nicolol123.sweeter0;

import fr.nicolol123.sweeter0.commands.annonceCommand;
import fr.nicolol123.sweeter0.commands.profilCommand;
import fr.nicolol123.sweeter0.commands.sweeter0Command;
import fr.nicolol123.sweeter0.commands.testCommand;
import fr.nicolol123.sweeter0.tabCompleter.testTabCompleter;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        //On importe la config
        saveDefaultConfig();
        //On enregistre des commands, et ont dit au serv quoi executer quand une cmd est utilisée
        Objects.requireNonNull(getCommand("annonce")).setExecutor(new annonceCommand(this));
        Objects.requireNonNull(getCommand("profil")).setExecutor(new profilCommand(this));
        Objects.requireNonNull(getCommand("test")).setExecutor(new testCommand(this));
        Objects.requireNonNull(getCommand("test")).setTabCompleter((TabCompleter) new testTabCompleter());
        Objects.requireNonNull(getCommand("Sweeter0")).setExecutor(new sweeter0Command(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
