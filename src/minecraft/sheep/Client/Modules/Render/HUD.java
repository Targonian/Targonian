package sheep.Client.Modules.Render;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import sheep.Client.Core;
import sheep.Client.Modules.Module;
import sheep.Client.Modules.Render.HuD.Menu;

public class HUD extends Module{

	Gui gui2 = Minecraft.getMinecraft().ingameGUI;
	
	public HUD() {
		super("HUD", 54, "R_Shift", CATEGORY.Render);
	}
	Menu M_Render,M_Combat,M_World,M_Player;
	public void onEnable() {
		M_Render = new Menu(CATEGORY.Render);
		M_Combat = new Menu(CATEGORY.Combat);
		M_World = new Menu(CATEGORY.World);
		M_Player = new Menu(CATEGORY.Player);
		Minecraft.getMinecraft().mouseHelper.ungrabMouseCursor();
		setRENDER(true);
		super.onEnable();
	}

	public void onDisable() {
		setRENDER(false);
		Minecraft.getMinecraft().mouseHelper.grabMouseCursor();
		super.onDisable();
	}
	

	public void onRender() {
		if(isRENDER()) {
			Render_HUD();
		}
		super.onRender();
	}
	
	
	private void Render_HUD() {
		M_Render.render();
		M_Combat.render();
		M_World.render();
		M_Player.render();
	}
	
	private void draw_LOGO()
	{
		
	}
	
	
}
