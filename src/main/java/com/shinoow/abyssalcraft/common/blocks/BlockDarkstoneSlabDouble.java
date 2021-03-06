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
package com.shinoow.abyssalcraft.common.blocks;

import java.util.Random;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.shinoow.abyssalcraft.AbyssalCraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDarkstoneSlabDouble extends BlockSlab {

	@SideOnly(Side.CLIENT)
	private IIcon iconSlabTop;
	@SideOnly(Side.CLIENT)
	private IIcon iconSlabBottom;
	@SideOnly(Side.CLIENT)
	private static IIcon iconSlabSideOverlay;

	public BlockDarkstoneSlabDouble()
	{
		super(true, Material.rock);
		setCreativeTab(null);
		setLightOpacity(0);
	}

	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return AbyssalCraft.Darkstoneslab1.getItemDropped(par1, par2Random, par3);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World par1World, int par2, int par3, int par4)
	{
		return Item.getItemFromBlock(AbyssalCraft.Darkstoneslab1);
	}

	@Override
	public String func_150002_b(int var1)
	{
		return super.getUnlocalizedName();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2)
	{
		return par1 == 1 ? iconSlabTop : par1 == 0 ? iconSlabBottom : blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon(AbyssalCraft.modid + ":" + "DSsSides");
		iconSlabTop = par1IconRegister.registerIcon(AbyssalCraft.modid + ":" + "DSsTop");
		iconSlabBottom = par1IconRegister.registerIcon(AbyssalCraft.modid + ":" + "DSsTop");
		BlockDarkstoneSlabDouble.iconSlabSideOverlay = par1IconRegister.registerIcon(AbyssalCraft.modid + ":" + "DSsSides");
	}

	@SideOnly(Side.CLIENT)
	public static IIcon getIconSideOverlay()
	{
		return iconSlabSideOverlay;
	}
}
