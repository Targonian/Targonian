package sheep.Client.Events;

import sheep.Client.Core;
import sheep.Client.Modules.Module;

public class RenderEvent {

	public void Render_Tick()
	{
		for(Module m : Core.INSTANCE.MODULE_MANAGER.modules)
		{
			if(m.isRENDER()) {
				m.onRender();
			}
		}
	}
}
