package cool.module;

import net.minecraft.client.Minecraft;

public class Module {
	
	public String name;
	public boolean enabled;
	public int key;
	public Category category;
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public Module(String name, int k, Category c) {
		this.name = name;
		this.key = k;
		this.category = c;
	}
	
	public void toggle() {
		this.enabled = !enabled;
		if(enabled) {
			onEnable();
		} else if (!enabled) {
			onDisable();
		}
	}
	
	public void onEnable() {}
	public void onDisable() {}
	public void onUpdate() {}
	public void onRender() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isEnabled() {
		return enabled;
	}
	
}
