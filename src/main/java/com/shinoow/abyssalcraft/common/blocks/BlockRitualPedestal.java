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

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.google.common.collect.Maps;
import com.shinoow.abyssalcraft.AbyssalCraft;
import com.shinoow.abyssalcraft.common.blocks.tile.TileEntityRitualPedestal;

public class BlockRitualPedestal extends BlockContainer {

	private static HashMap<Integer, Block> blockMeta = Maps.newHashMap();

	public BlockRitualPedestal() {
		super(Material.rock);
		setHardness(6.0F);
		setResistance(12.0F);
		setStepSound(Block.soundTypeStone);
		setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 1.0F, 0.75F);
		setBlockTextureName("anvil_top_damaged_0");
		setCreativeTab(null);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
		par3List.add(new ItemStack(par1, 1, 2));
		par3List.add(new ItemStack(par1, 1, 3));
		par3List.add(new ItemStack(par1, 1, 4));
		par3List.add(new ItemStack(par1, 1, 5));
		par3List.add(new ItemStack(par1, 1, 6));
		par3List.add(new ItemStack(par1, 1, 7));
	}

	@Override
	public boolean isOpaqueCube(){
		return false;
	}

	@Override
	public boolean renderAsNormalBlock(){
		return false;
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {

		return new TileEntityRitualPedestal();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if(tile != null && tile instanceof TileEntityRitualPedestal)
			if(((TileEntityRitualPedestal)tile).getItem() != null){
				player.inventory.addItemStackToInventory(((TileEntityRitualPedestal)tile).getItem());
				((TileEntityRitualPedestal)tile).setItem(null);
				world.playSoundEffect(x + 0.5, y + 0.5, z + 0.5, "random.pop", 0.5F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1);
				return true;
			} else {
				ItemStack heldItem = player.getHeldItem();
				if(heldItem != null){
					ItemStack newItem = heldItem.copy();
					newItem.stackSize = 1;
					((TileEntityRitualPedestal)tile).setItem(newItem);
					player.inventory.decrStackSize(player.inventory.currentItem, 1);
					world.playSoundEffect(x + 0.5, y + 0.5, z + 0.5, "random.pop", 0.5F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1);
					return true;
				}
			}
		return false;
	}

	@Override
	public Item getItemDropped(int i, Random random, int j)
	{
		return Item.getItemFromBlock(blockMeta.get(i));
	}

	@Override
	public int getRenderType() {
		return -8;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta)
	{
		Random rand = new Random();
		TileEntityRitualPedestal pedestal = (TileEntityRitualPedestal) world.getTileEntity(x, y, z);

		if(pedestal != null)
			if(pedestal.getItem() != null){
				float f = rand.nextFloat() * 0.8F + 0.1F;
				float f1 = rand.nextFloat() * 0.8F + 0.1F;
				float f2 = rand.nextFloat() * 0.8F + 0.1F;

				EntityItem item = new EntityItem(world, x + f, y + f1, z + f2, pedestal.getItem());
				float f3 = 0.05F;
				item.motionX = (float)rand.nextGaussian() * f3;
				item.motionY = (float)rand.nextGaussian() * f3 + 0.2F;
				item.motionZ = (float)rand.nextGaussian() * f3;
				world.spawnEntityInWorld(item);
			}

		super.breakBlock(world, x, y, z, block, meta);
	}

	static {
		blockMeta.put(0, Blocks.cobblestone);
		blockMeta.put(1, AbyssalCraft.Darkstone_cobble);
		blockMeta.put(2, AbyssalCraft.abybrick);
		blockMeta.put(3, AbyssalCraft.cstonebrick);
		blockMeta.put(4, AbyssalCraft.dreadbrick);
		blockMeta.put(5, AbyssalCraft.abydreadbrick);
		blockMeta.put(6, AbyssalCraft.ethaxiumbrick);
		blockMeta.put(7, AbyssalCraft.darkethaxiumbrick);
	}
}
