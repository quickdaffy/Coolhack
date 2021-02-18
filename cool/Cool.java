package cool;

import cool.module.ModuleManager;
import cool.module.Module;

public class Cool {
	
	
	public static String NAME = "Coolhack", VERSION = "1.0", AUTHOR = "quickdaffy";
	public static ModuleManager moduleManager = new ModuleManager();
	
	public Cool() {
		System.out.println("Starting " + NAME + " " + VERSION + " by " + AUTHOR);
		
		moduleManager.addMods();
	}
	
	public static void onUpdate() {
		for(Module m: moduleManager.modules) {
			m.onUpdate();
		}
	}
	
	public static void onRender() {
		for(Module m : moduleManager.modules) {
			m.onRender();
		}
	}
	
	public static void onKeypress(int k) {
		for(Module m : moduleManager.modules) {
			if(m.getKey() == k) {
				m.toggle();
			}
		}
	}

}