package sheep.Client.Modules.Render;

import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.BlockPos;
import sheep.Client.Modules.Module;

public class Fullbright extends Module {

	public Fullbright() {
		super("Fullbright", 47, "V", CATEGORY.Render);
	}

	public void onEnable() {
		setTICK(true);
		super.onEnable();
	}

	public void onDisable() {
		super.onDisable();
	}

	public void onTick() {
		if (isTICK()) {
			if (isTOGGLE())
				Gamma_Increase();
			if (!isTOGGLE())
				Gamma_Decrease();
		}
		super.onRender();
	}

	private void Gamma_Increase() {
		if (getMc().gameSettings.gammaSetting <= 15) {
			getMc().gameSettings.gammaSetting += 0.63F;
			getCore().print("" + getMc().gameSettings.gammaSetting);
		}
		getCore().print("" + getMc().gameSettings.gammaSetting);
	}

	private void Gamma_Decrease() {
		// TODO Auto-generated method stub
		getMc().gameSettings.gammaSetting = 0.80F;
		setTICK(false);
		getCore().print(""+getMc().gameSettings.gammaSetting);
		onDisable();
	}

}
