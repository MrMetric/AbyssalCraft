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
package com.shinoow.abyssalcraft.common.blocks.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

/** Some sort of universal metadata itemblock thingy */
public class ItemMetadataBlock extends ItemBlock {

	private static final String[] subNames = {
		"0", "1",  "2", "3", "4", "5", "6", "7",
		"8", "9", "10", "11", "12", "13", "14", "15"};

	public ItemMetadataBlock(Block b) {
		super(b);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int meta) {
		return meta;
	}

	@Override
	public String getItemStackDisplayName(ItemStack par1ItemStack) {

		if(getUnlocalizedName().contains("DEB"))
			return EnumChatFormatting.DARK_RED + StatCollector.translateToLocal(getUnlocalizedName() + "." + subNames[par1ItemStack.getItemDamage()] + ".name");
		else if(getUnlocalizedName().contains("EB"))
			return EnumChatFormatting.AQUA + StatCollector.translateToLocal(getUnlocalizedName() + "." + subNames[par1ItemStack.getItemDamage()] + ".name");
		return StatCollector.translateToLocal(getUnlocalizedName() + "." + subNames[par1ItemStack.getItemDamage()] + ".name");
	}
}
