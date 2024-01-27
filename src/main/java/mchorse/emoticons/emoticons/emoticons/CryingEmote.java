package mchorse.emoticons.emoticons.emoticons;

import mchorse.emoticons.bobj.BOBJArmature;
import mchorse.emoticons.emoticons.Emote;
import mchorse.emoticons.emoticons.accessor.IEmoteAccessor;
import mchorse.emoticons.emoticons.accessor.ParticleType;
import org.joml.Vector4f;

public class CryingEmote extends Emote {
   public CryingEmote(String s, String s1) {
      super(s, s1);
   }

   @Override
   public void progressAnimation(IEmoteAccessor iemoteaccessor, BOBJArmature bobjarmature, int i, float f) {
      if (i % 2 == 0) {
         Vector4f vector4f = this.position(iemoteaccessor, bobjarmature, "head", 0.0F, 0.5F, 0.15F, f);
         this.spawnParticle(iemoteaccessor, ParticleType.WATER_DROP, vector4f.x, vector4f.y, vector4f.z, 0.25F);
      }
   }
}
