/*******************************************************************************
 * AbyssalCraft
 * Copyright (c) 2012 - 2016 Shinoow.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 * 
 * Contributors:
 *     Shinoow -  implementation
 ******************************************************************************/
package com.shinoow.abyssalcraft.common.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import com.shinoow.abyssalcraft.api.energy.EnergyEnum;
import com.shinoow.abyssalcraft.api.energy.EnergyEnum.AmplifierType;
import com.shinoow.abyssalcraft.api.energy.EnergyEnum.DeityType;
import com.shinoow.abyssalcraft.api.energy.IAmplifierCharm;
import com.shinoow.abyssalcraft.api.energy.IEnergyManipulator;

public class ItemCharm extends ItemMetadata implements IAmplifierCharm {

	private DeityType deity;

	public ItemCharm(String name, boolean moreIcons, DeityType deity) {
		super(name, moreIcons, "empty", "range", "duration", "power");
		this.deity = deity;
	}

	@Override
	public AmplifierType getAmplifier(ItemStack stack) {

		switch(stack.getItemDamage()){
		case 0:
			return null;
		case 1:
			return AmplifierType.RANGE;
		case 2:
			return AmplifierType.DURATION;
		case 3:
			return AmplifierType.POWER;
		default:
			return null;
		}
	}

	@Override
	public DeityType getDeity(ItemStack stack) {

		return deity;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack is, EntityPlayer player, List l, boolean B){
		l.add(StatCollector.translateToLocal("ac.text.amplifier") + ": " + EnergyEnum.getAmplifierName(getAmplifier(is)));
		l.add(StatCollector.translateToLocal("ac.text.deity") + ": " + EnergyEnum.getDeityName(getDeity(is)));
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int meta, float par7, float par8, float par9){
		TileEntity tile = world.getTileEntity(x, y, z);
		if(tile instanceof IEnergyManipulator && !((IEnergyManipulator) tile).isActive()){
			((IEnergyManipulator) tile).setActive(getAmplifier(stack), getDeity(stack));
			if(!world.isRemote)
				stack.stackSize--;
			world.playSoundEffect(x + 0.5, y + 0.5, z + 0.5, "random.pop", 0.5F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1);
			return true;
		}
		return false;
	}

	@Override
	public String getItemStackDisplayName(ItemStack par1ItemStack) {
		return StatCollector.translateToLocal(getUnlocalizedName() + ".name");
	}
}
