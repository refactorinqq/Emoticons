package mchorse.emoticons;

import net.fabricmc.api.ModInitializer;
import net.legacyfabric.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

/**
 * @author refactoring
 */
public class EmoticonsMod implements ModInitializer {
    public KeyBinding keyBinding = new KeyBinding("Emote Wheel", Keyboard.KEY_R, "Emoticons");

    public static EmoticonsMod INSTANCE;

    @Override
    public void onInitialize() {
        INSTANCE = this;
        KeyBindingHelper.registerKeyBinding(keyBinding);
    }
}
