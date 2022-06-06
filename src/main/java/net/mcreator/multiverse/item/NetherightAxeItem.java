
package net.mcreator.multiverse.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.multiverse.itemgroup.CrakedmultiverseItemGroup;
import net.mcreator.multiverse.MultiverseModElements;

import java.util.List;

@MultiverseModElements.ModElement.Tag
public class NetherightAxeItem extends MultiverseModElements.ModElement {
	@ObjectHolder("multiverse:netheright_axe")
	public static final Item block = null;

	public NetherightAxeItem(MultiverseModElements instance) {
		super(instance, 21);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 600;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 7f;
			}

			public int getHarvestLevel() {
				return 6;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(NetherightAxeItem.block), new ItemStack(MultiverseingotItem.block));
			}
		}, 1, -3f, new Item.Properties().group(CrakedmultiverseItemGroup.tab).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("Made from the strange crystals this tool bares the power of the multiverse"));
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}
		}.setRegistryName("netheright_axe"));
	}
}
