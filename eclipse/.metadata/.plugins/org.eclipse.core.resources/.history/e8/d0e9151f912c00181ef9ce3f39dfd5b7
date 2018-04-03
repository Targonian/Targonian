package sheep.Client.Modules.Render.HuD;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.ini4j.Wini;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import sheep.Client.Core;
import sheep.Client.Modules.Module;
import sheep.Client.Modules.Module.CATEGORY;
import sheep.Client.Utils.FontUtils;

public class Menu {
	
	//Array list to contain category specific modules
	ArrayList<Module> Menu_Mods = new ArrayList<>();

	//Category that the menu handles
	CATEGORY Category;
	
	//GUI bride
	GuiIngame GUI = Minecraft.getMinecraft().ingameGUI;
	
	/** Utilities **/
	
		//Fonts to be used in HUD
		FontUtils Font_Title = new FontUtils("Futura", Font.BOLD, 18);
		FontUtils Font_ = new FontUtils("Futura", Font.BOLD, 14);
	
		//Colors to be used in the HUD
		Color Color_Title_Bar = new Color(173, 62, 62, 200);
		Color Color_Background = new Color(0, 0, 0, 180);
		
	
	/** HUD Variables **/
		
		//Title string
		String Title;
		
		//Positions
		int X,Y;
		//Different Position for body part
		int Y_Body;
		
		//Dimensions
		int W, H;
		
		//Different dimension for title bar
		int H_Titlebar;
		
		//Spacing between the module info
		int module_spacing_X, module_spacing_Y;
		
		int Modular_Count = 0;

	
	/** Constructor **/
		public Menu(CATEGORY category) {
			Category = category;
			Title = category.toString().toUpperCase();
			count_Mods();
			try {
				load_Settings_File("Data/HUD_SETTINGS.ini");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	/** Functional Functions **/
		
		private void count_Mods() {
			for (Module m : Core.INSTANCE.MODULE_MANAGER.modules) {
				System.out.println(m.getCategory());
				if (m.getCategory() == Category) {
					Menu_Mods.add(m);
					Modular_Count++;
				}
			}
		}
		
		//Load settings from file
		void load_Settings_File(String filename) throws IOException {
			Wini ini = new Wini(new File(filename));
			
			X = ini.get(Title, "x", int.class);
			Y = ini.get(Title, "y", int.class);
			
			module_spacing_X = 5;
			module_spacing_Y = 10;
			
			
			W = 100;
			H = 14 * Modular_Count;
			
			H_Titlebar = 12;
			Y_Body = Y+H_Titlebar;
			
		}
		
	/** Render Functions **/
		
		//Render whole menu
		public void render()
		{
			render_Body();
			render_Title_Bar();
			render_Module_Info();
		}
		
		//Render top_part
		private void render_Title_Bar()
		{
			GUI.drawRect(X, Y, X+W, Y+H_Titlebar, Color_Title_Bar.getRGB());
			GUI.drawCenteredString(Font_Title, Title,
			X+(W/2),
			Y,0xffffff);
		}
		
		//Render body_part
		private void render_Body()
		{
			GUI.drawRect(X, Y_Body, X+W, Y_Body+H, Color_Background.getRGB());
		}
		
		//Render module information
		int c = 0;
		private void render_Module_Info()
		{
			for (Module mod : Menu_Mods) {
				if (mod.isTOGGLE()) {
					GUI.drawString(Font_, mod.getMODULE_NAME() + " : " + mod.getKEY_NAME(),
					X+module_spacing_X,
					Y_Body-9+((module_spacing_Y+1)*c),0xaaffaa);
				}
				else
				{
					GUI.drawString(Font_, mod.getMODULE_NAME() + " : " + mod.getKEY_NAME(),
					X+module_spacing_X,
					Y_Body-9+((module_spacing_Y+1)*c),0xffaaaa);
				}
				c++;
			}
			c = 1;
		}
		
	

}
