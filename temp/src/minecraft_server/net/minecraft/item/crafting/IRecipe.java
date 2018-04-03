package net.minecraft.item.crafting;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public interface IRecipe {
   boolean func_77569_a(InventoryCrafting var1, World var2);

   ItemStack func_77572_b(InventoryCrafting var1);

   ItemStack func_77571_b();

   NonNullList<ItemStack> func_179532_b(InventoryCrafting var1);

   default boolean func_192399_d() {
      return false;
   }
}
