package cool.module.mods;

import org.lwjgl.input.Keyboard;

import cool.module.Category;
import cool.module.Module;

public class Sprint extends Module {

	public Sprint() {
		super("Sprint", Keyboard.KEY_M, Category.MOVEMENT);
	}
	
	public void onUpdate() {
		mc.thePlayer.setSprinting(true);
	}
	
	public void onDisable() {
		mc.thePlayer.setSprinting(false);
	}

}
