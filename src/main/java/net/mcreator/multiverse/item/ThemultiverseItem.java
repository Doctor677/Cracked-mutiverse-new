
package net.mcreator.multiverse.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ActionResultType;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;

import net.mcreator.multiverse.world.dimension.ThemultiverseDimension;
import net.mcreator.multiverse.itemgroup.CrakedmultiverseItemGroup;

public class ThemultiverseItem extends Item {
	@ObjectHolder("multiverse:themultiverse")
	public static final Item block = null;

	public ThemultiverseItem() {
		super(new Item.Properties().group(CrakedmultiverseItemGroup.tab).maxDamage(64));
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity entity = context.getPlayer();
		BlockPos pos = context.getPos().offset(context.getFace());
		ItemStack itemstack = context.getItem();
		World world = context.getWorld();
		if (!entity.canPlayerEdit(pos, context.getFace(), itemstack)) {
			return ActionResultType.FAIL;
		} else {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			boolean success = false;
			if (world.isAirBlock(pos) && true) {
				ThemultiverseDimension.portal.portalSpawn(world, pos);
				itemstack.damageItem(1, entity, c -> c.sendBreakAnimation(context.getHand()));
				success = true;
			}
			return success ? ActionResultType.SUCCESS : ActionResultType.FAIL;
		}
	}
}