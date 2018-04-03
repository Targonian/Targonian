package net.minecraft.server.gui;

import java.util.Vector;
import javax.swing.JList;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ITickable;

public class PlayerListComponent extends JList implements ITickable {
   private final MinecraftServer field_120015_a;
   private int field_120014_b;

   public PlayerListComponent(MinecraftServer p_i2366_1_) {
      this.field_120015_a = p_i2366_1_;
      p_i2366_1_.func_82010_a(this);
   }

   public void func_73660_a() {
      if (this.field_120014_b++ % 20 == 0) {
         Vector<String> vector = new Vector<String>();

         for(int i = 0; i < this.field_120015_a.func_184103_al().func_181057_v().size(); ++i) {
            vector.add(((EntityPlayerMP)this.field_120015_a.func_184103_al().func_181057_v().get(i)).func_70005_c_());
         }

         this.setListData(vector);
      }

   }
}
