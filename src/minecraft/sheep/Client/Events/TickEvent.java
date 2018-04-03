package sheep.Client.Events;

import sheep.Client.Core;
import sheep.Client.Modules.Module;

public class TickEvent {

	public void Tick()
	{
		for(Module m : Core.INSTANCE.MODULE_MANAGER.modules)
		{
			if(m.isTICK()) {
				m.onTick();
			}
		}
	}
	
}
