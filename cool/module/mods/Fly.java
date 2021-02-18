package cool.module.mods;

import org.lwjgl.input.Keyboard;

import cool.module.Category;
import cool.module.Module;

public class Fly extends Module {

	public Fly() {
		super("Fly", Keyboard.KEY_P, Category.MOVEMENT);
	}
	
	@Override
	public void onUpdate() {
		if(this.isEnabled()) {
			mc.thePlayer.capabilities.isFlying = true;
		}
	}
	
	public void onDisable() {
		mc.thePlayer.capabilities.isFlying = false;
	}

}
