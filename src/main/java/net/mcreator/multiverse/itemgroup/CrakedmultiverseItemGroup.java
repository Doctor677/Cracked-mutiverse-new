
package net.mcreator.multiverse.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.multiverse.block.MultiverseblockBlock;
import net.mcreator.multiverse.MultiverseModElements;

@MultiverseModElements.ModElement.Tag
public class CrakedmultiverseItemGroup extends MultiverseModElements.ModElement {
	public CrakedmultiverseItemGroup(MultiverseModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabcrakedmultiverse") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MultiverseblockBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;
}
