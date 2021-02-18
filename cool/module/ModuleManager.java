package cool.module;

import java.util.ArrayList;

import cool.module.mods.*;

public class ModuleManager {
	
	public static ArrayList<Module> modules = new ArrayList<Module>();
	
	public void addMods() {
		
		modules.add(new Sprint());
		modules.add(new Fly());
		
	}
	
	public static ArrayList<Module> getMods() {
		return modules;
	}

}
