package mchorse.emoticons.ui;

import mchorse.emoticons.EmoteManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.MathHelper;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;


public class ScreenEmoteWheel extends GuiScreen {
    int accept;
    protected boolean hovered;
    private final HashMap<String, Consumer<Boolean>> handlers = new HashMap<>();
    private String foc;
    private int page = 1;

    private void handleScroll() {
        int scroll = Mouse.getEventDWheel();
        if (scroll > 0 && this.page > 1) {
            --this.page;
        }

        if (scroll < 0 && this.page < 12) {
            ++this.page;
        }
    }

    @Override
    public void handleMouseInput() {
        super.handleMouseInput();
        this.handleScroll();
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        super.mouseReleased(mouseX, mouseY, state);
        if (this.foc != null) {
            this.mc.displayGuiScreen(null);
            this.handlers.get(this.foc).accept(true);
        }
    }

    @Override
    public void initGui() {
        this.handlers.clear();
        switch(this.page) {
            case 1:
                this.handlers.put("Best Mates", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 1));
                this.handlers.put("Boneless", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 2));
                this.handlers.put("Bow", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 3));
                this.handlers.put("Boyy", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 4));
                this.handlers.put("Calculated", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 5));
                break;
            case 2:
                this.handlers.put("Chicken", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 6));
                this.handlers.put("Clapping", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 7));
                this.handlers.put("Confused", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 8));
                this.handlers.put("Crying", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 9));
                this.handlers.put("Dab", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 10));
                break;
            case 3:
                this.handlers.put("Default", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 11));
                this.handlers.put("Disco Fever", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 12));
                this.handlers.put("Electro Shuffle", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 13));
                this.handlers.put("Facepalm", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 14));
                this.handlers.put("Fist", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 15));
                break;
            case 4:
                this.handlers.put("Floss", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 16));
                this.handlers.put("Free Flow", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 17));
                this.handlers.put("Fresh", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 18));
                this.handlers.put("Gangnam Style", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 19));
                this.handlers.put("Get Funky", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 20));
                break;
            case 5:
                this.handlers.put("Hype", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 21));
                this.handlers.put("Infinite Dab", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 22));
                this.handlers.put("Laughing", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 23));
                this.handlers.put("No", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 24));
                this.handlers.put("Orange Justice", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 25));
                break;
            case 6:
                this.handlers.put("Pointing", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 26));
                this.handlers.put("Salute", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 27));
                this.handlers.put("Shimmer", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 28));
                this.handlers.put("Shrug", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 29));
                this.handlers.put("Skibidi", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 30));
                break;
            case 7:
                this.handlers.put("Squat Kick", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 31));
                this.handlers.put("Star Power", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 32));
                this.handlers.put("T Pose", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 33));
                this.handlers.put("Take The L", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 34));
                this.handlers.put("Thinking", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 35));
                break;
            case 8:
                this.handlers.put("Tidy", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 36));
                this.handlers.put("Wave", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 37));
                this.handlers.put("Yes", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 38));
                this.handlers.put("Rising From Dead", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 39));
                this.handlers.put("Pumpkin", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 40));
                break;
            case 9:
                this.handlers.put("Trick or Treat", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 41));
                this.handlers.put("Blow kiss", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 42));
                this.handlers.put("Twerk", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 43));
                this.handlers.put("Club", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 44));
                this.handlers.put("Sneeze", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 45));
                break;
            case 10:
                this.handlers.put("Punch", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 46));
                this.handlers.put("Bongo Cat", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 47));
                this.handlers.put("Exhausted", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 48));
                this.handlers.put("Disgusted", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 49));
                this.handlers.put("Bitch Slap", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 50));
                break;
            case 11:
                this.handlers.put("Threatening", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 51));
                this.handlers.put("Woah!", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 52));
                this.handlers.put("Breathtaking", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 53));
                this.handlers.put("Bunny Hop", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 54));
                this.handlers.put("Chicken Dance", emote -> EmoteManager.sendEmote(this.mc.thePlayer.getGameProfile().getName(), 55));
                break;
            case 12:
                this.handlers.put("Broom", hello -> EmoteManager.sendEmote(Minecraft.getMinecraft().getSession().getUsername(), 56));
                this.handlers.put("Iceberg", hello -> EmoteManager.sendEmote(Minecraft.getMinecraft().getSession().getUsername(), 57));
                this.handlers.put("Present", hello -> EmoteManager.sendEmote(Minecraft.getMinecraft().getSession().getUsername(), 58));
                this.handlers.put("Champagne", hello -> EmoteManager.sendEmote(Minecraft.getMinecraft().getSession().getUsername(), 59));
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        ScaledResolution resolution = new ScaledResolution(this.mc);
        int centerY = resolution.getScaledHeight() / 2;
        int centerX = resolution.getScaledWidth() / 2;
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.foc = null;
        this.initGui();
        int count = this.handlers.size();
        float radius = (float)resolution.getScaledHeight() * 2.0F / 5.0F;
        float i = 0.0F;
        this.drawString(this.fontRendererObj, "Scroll to view more.", 1, 1, -1);

        for(String s : this.handlers.keySet()) {
            GL11.glPushMatrix();
            GL11.glEnable(3042);
            GL11.glDisable(3553);
            GL11.glBlendFunc(770, 771);
            GL11.glHint(3152, 4354);
            GL11.glBegin(6);
            GlStateManager.resetColor();
            float startTheta = (float)((double)(i / (float)count) * Math.PI * 2.0);
            float endTheta = (float)((double)((i + 1.0F) / (float)count) * Math.PI * 2.0);
            float diff = endTheta - startTheta;
            int mouseDeltaX = mouseX - centerX;
            int mouseDeltaY = mouseY - centerY;
            double sqrt = Math.sqrt(Math.pow((double)mouseDeltaX, 2.0) + Math.pow((double)mouseDeltaY, 2.0));
            boolean hovered = false;
            if (sqrt <= (double)radius) {
                double mouseTheta = MathHelper.atan2((double)mouseDeltaX, (double)mouseDeltaY);
                if (mouseTheta < 0.0) {
                    mouseTheta += Math.PI * 2;
                }

                if (mouseTheta > (double)startTheta && mouseTheta < (double)endTheta) {
                    this.foc = s;
                    hovered = true;
                }
            }

            Color tmp = new Color(12, 12, 12, hovered ? 40 : 20);
            GlStateManager.color((float)tmp.getRed() / 255.0F, (float)tmp.getGreen() / 255.0F, (float)tmp.getBlue() / 255.0F, (float)tmp.getAlpha() / 255.0F);
            GL11.glVertex3d((double)centerX, (double)centerY, 0.0);

            for(float j = 0.0F; j <= 50.0F; ++j) {
                float x = (float)centerX + radius * MathHelper.sin(startTheta + diff * j / 50.0F);
                float y = (float)centerY + radius * MathHelper.cos(startTheta + diff * j / 50.0F);
                GL11.glVertex2f(x, y);
            }

            GL11.glEnd();
            GL11.glEnable(3553);
            GL11.glDisable(3042);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            float middle = (startTheta + endTheta) / 2.0F;
            List<String> strings = this.fontRendererObj.listFormattedStringToWidth(s, 50);
            int textCenterX = (int)((float)centerX + radius * MathHelper.sin(middle) / 3.0F * 2.0F);
            int textCenterY = (int)((float)centerY + radius * MathHelper.cos(middle) / 3.0F * 2.0F);
            textCenterY -= strings.size() * 15;

            for(String string : strings) {
                textCenterY += 15;
                this.drawScaledText(string, textCenterX, textCenterY, Color.WHITE.getRGB());
            }

            GL11.glPopMatrix();
            ++i;
        }
    }

    protected void drawScaledText(String text, int trueX, int trueY, int color) {
        GlStateManager.pushMatrix();
        GlStateManager.scale(1.2, 1.2, 1.2);
        this.fontRendererObj
                .drawString(text, (float)((double)trueX / 1.2) - (float)this.fontRendererObj.getStringWidth(text) / 2.0F, (float)((double)trueY / 1.2), color, false);
        GlStateManager.popMatrix();
    }
}
