package cool.ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import cool.Cool;
import cool.module.Module;
import cool.module.ModuleManager;
import cool.util.ColorUtil;

import java.awt.Event;
import java.util.Collections;
import java.util.Comparator;
import org.lwjgl.util.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiIngameHook extends GuiIngame {
	
	private final Minecraft mc = Minecraft.getMinecraft();

	public GuiIngameHook(Minecraft mcIn) {
		super(mcIn);
	}
	
	
	public void renderGameOverlay(float partialTicks) {
		
		ScaledResolution sr = new ScaledResolution(mc);
		FontRenderer fr = mc.fontRendererObj;
		
		
		ModuleManager.modules.sort(Comparator.comparingInt(m -> mc.fontRendererObj.getStringWidth(((Module)m).name)).reversed());
		
		super.renderGameOverlay(partialTicks);
        ScaledResolution scaledresolution = new ScaledResolution(this.mc);
        FontRenderer fontrenderer = this.getFontRenderer();
        
        GlStateManager.enableBlend();
        fr.drawStringWithShadow(Cool.NAME + " " + Cool.VERSION, 1, 1, ColorUtil.getRGB(4, 0.9f, 1, 100));
        
        int count = 0;
        
        for(Module m : ModuleManager.modules) {
			if(!m.enabled)
				continue;
			
			double offset = count * (fr.FONT_HEIGHT + 6);
			String modulesText = m.getName();
			
			Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m.name) - 8, + offset, sr.getScaledWidth(), 6 + fr.FONT_HEIGHT + offset, 0x90000000);
			fr.drawStringWithShadow(m.name.toLowerCase(), sr.getScaledWidth() - fr.getStringWidth(m.name) - 4, (float) (0.25 + offset) + 2.5f, ColorUtil.getRGB(4, 0.9f, 1, count * 100));
			count++;
		}
       
    }

}
