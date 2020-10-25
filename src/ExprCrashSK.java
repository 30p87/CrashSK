package me._30p87.addon.elements.expressions;

import javax.annotation.Nullable;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
 
import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

public class ExprCrashSK extends SimpleExpression<String> {
 
   static {
       Skript.registerExpression(ExprCrashSK.class, String.class, ExpressionType.COMBINED, "[the] nickname of %player%");
   }
 
   private Expression<Player> player;
 
   @Override
   public Class<? extends String> getReturnType() {
       return String.class;
   }
 
   @Override
   public boolean isSingle() {
       return true;
   }
 
   @SuppressWarnings("unchecked")
   @Override
   public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
       player = (Expression<Player>) exprs[0];
       return true;
   }
 
   @Override
   public String toString(@Nullable Event event, boolean debug) {
       return "Example expression with expression player: " + player.toString(event, debug);
   }
 
   @Override
   @Nullable
   protected String[] get(Event event) {
       Player p = player.getSingle(event);
       if (p != null) {
           return new String[] {p.getDisplayName()};
       }
       return null;
   }
}
