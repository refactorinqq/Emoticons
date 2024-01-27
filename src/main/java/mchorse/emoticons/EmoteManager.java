package mchorse.emoticons;

import mchorse.emoticons.emoticons.Emote;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class EmoteManager {
   public static void sendEmote(String name, int i) {
      play(name, i);
   }

   public static void play(String name, int i) {
      if (Minecraft.getMinecraft().theWorld != null) {
         String s = PlayerModelManager.get().map.get(i);
         EntityPlayer entityPlayer = Minecraft.getMinecraft().theWorld.getPlayerEntityByName(name);
         if (entityPlayer != null && s != null) {
            Emote emote = PlayerModelManager.get().registry.get(s);
            if (EmoteControllerManager.controllers.get(entityPlayer) != null) {
               EmoteControllerManager.controllers.get(entityPlayer).setEmote(entityPlayer, emote);
            }
         }
      }
   }
}
