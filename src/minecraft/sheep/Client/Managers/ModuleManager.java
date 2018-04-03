package sheep.Client.Managers;

import java.util.ArrayList;

import sheep.Client.Core;
import sheep.Client.Modules.Module;
import sheep.Client.Modules.Combat.KillAura;
import sheep.Client.Modules.Render.Fullbright;
import sheep.Client.Modules.Render.HUD;

public class ModuleManager {

	
	public ArrayList<Module> modules = new ArrayList<>();
	
	private void reg_Module(Module m) {
		modules.add(m);
		Core.INSTANCE.print("Registered Module > " + m.getMODULE_NAME());
	}
	
	private void unload_Module(Module m) {
		modules.remove(m);
		Core.INSTANCE.print("Unloaded Module > " + m.getMODULE_NAME());
	}
	
	public Module getModule(String name)
	{
		for(Module m : modules)
		{
			if(m.getMODULE_NAME().equalsIgnoreCase(name))
			{
				return m;
			}
		}
		return null;
	}
	
	public void register_modules() {
		reg_Module(new HUD());
		reg_Module(new Fullbright());
		reg_Module(new KillAura());
		
		
		Core.INSTANCE.print(modules.size()+" >> Modules Loaded");
	}
	
}
