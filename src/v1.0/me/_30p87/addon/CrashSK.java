package me._30p87.addon;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
 
import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;

public class CrashSK extends JavaPlugin {

	CrashSK instance;
	SkriptAddon addon;

	public void onEnable() {
		instance = this;
		addon = Skript.registerAddon(this);
		try {
			addon.loadClasses("me._30p87.addon", "elements");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Bukkit.getLogger().info("[CrashSK] has been enabled!");
	}

	public CrashSK getInstance() {
		return instance;
	}

	public SkriptAddon getAddonInstance() {
		return addon;
	}
}
