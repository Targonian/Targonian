package sheep.Client.Events;

import org.lwjgl.input.Keyboard;

import sheep.Client.Core;
import sheep.Client.Modules.Module;

public class KeyboardEvent {
	public void KeyPressed() {
		for (Module m : Core.INSTANCE.MODULE_MANAGER.modules) {
			if (Keyboard.isKeyDown(m.getKEY_CODE())) {
				m.Toggle();
			}
		}
	}
}
