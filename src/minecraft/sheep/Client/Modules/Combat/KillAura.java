package sheep.Client.Modules.Combat;

import java.util.Iterator;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import sheep.Client.Modules.Module;

public class KillAura extends Module {

	public KillAura() {
		super("Killaura", 19, "R", CATEGORY.Combat);
	}

	public void onEnable() {
		setTICK(true);
		super.onEnable();
	}

	public void onDisable() {
		setTICK(false);
		super.onDisable();
	}
	
	World mcw;
	int delay = 6;
	int range = 5;
	int time = 0;

	public void onTick() {
		if (isTICK()) {
			mcw =	getMc().player.world; 
			time++;
			for(Iterator<Entity> entities = mcw.loadedEntityList.iterator(); entities.hasNext();)
			{
				Entity t_E = entities.next();
				if(t_E instanceof EntityLivingBase)
				{
					if(t_E.getName().equalsIgnoreCase(getMc().player.getName()))
					{
						
					}else {
						if(getMc().player.getDistanceToEntity(t_E) <= range && time >= delay) {
						getMc().player.swingArm(EnumHand.MAIN_HAND);
						getMc().playerController.attackEntity(getMc().player, t_E);
						getMc().playerController.sendPacketDropItem(getMc().player.getHeldItemMainhand());
						time = 0;
						}
					}
				}
			}
		}
		super.onRender();
	}

	

}
