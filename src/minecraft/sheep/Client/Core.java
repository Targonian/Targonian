package sheep.Client;

import sheep.Client.Events.KeyboardEvent;
import sheep.Client.Events.RenderEvent;
import sheep.Client.Events.TickEvent;
import sheep.Client.Managers.ModuleManager;
import sheep.Client.Modules.Render.HUD;

public class Core {
	/** INSTANCE of the Core */
	public static Core INSTANCE = new Core();
	
	String CORE_NAME = "Sheep-client ";
	double CORE_VERSION = 2.0;
	
	/** Managers */
	public ModuleManager MODULE_MANAGER;
	
	/** Events */
	public KeyboardEvent E_Keyboard;
	public RenderEvent E_Render;
	public TickEvent E_Tick;
	
	public void Injection_Point() {
		print("Injected " + CORE_NAME + CORE_VERSION + "into Minecraft.exe");
		
		/**MODULE MANAGER*/
		MODULE_MANAGER = new ModuleManager();
		
		/**Events*/
		E_Keyboard = new KeyboardEvent();
		E_Render = new RenderEvent();
		E_Tick = new TickEvent();
		
		/**LOAD MODULES*/
		MODULE_MANAGER.register_modules();
	}
	
	public void print(String x) {
		System.out.println(x);
	}
	
}