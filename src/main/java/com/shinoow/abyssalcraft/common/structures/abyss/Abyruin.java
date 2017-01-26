/*******************************************************************************
 * AbyssalCraft
 * Copyright (c) 2012 - 2017 Shinoow.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Contributors:
 *     Shinoow -  implementation
 ******************************************************************************/
package com.shinoow.abyssalcraft.common.structures.abyss;

import static net.minecraftforge.common.ChestGenHooks.DUNGEON_CHEST;
import static net.minecraftforge.common.ChestGenHooks.STRONGHOLD_CORRIDOR;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ChestGenHooks;

import com.shinoow.abyssalcraft.api.block.ACBlocks;
import com.shinoow.abyssalcraft.lib.ACLoot;

public class Abyruin extends WorldGenerator
{
	protected IBlockState[] GetValidSpawnBlocks() {
		return new IBlockState[] {
				ACBlocks.abyssal_stone.getDefaultState(),
				ACBlocks.fused_abyssal_sand.getDefaultState(),
				ACBlocks.abyssal_sand.getDefaultState()
		};
	}

	public boolean LocationIsValidSpawn(World world, BlockPos pos){
		int distanceToAir = 0;
		IBlockState checkID = world.getBlockState(pos);

		while (checkID != Blocks.air.getDefaultState()){
			distanceToAir++;
			checkID = world.getBlockState(pos.up(distanceToAir));
		}

		if (distanceToAir > 1)
			return false;
		pos.up(distanceToAir - 1);

		IBlockState blockID = world.getBlockState(pos);
		IBlockState blockIDAbove = world.getBlockState(pos.up(1));
		IBlockState blockIDBelow = world.getBlockState(pos.down(1));
		for (IBlockState x : GetValidSpawnBlocks()){
			if (blockIDAbove != Blocks.air.getDefaultState())
				return false;
			if (blockID == x)
				return true;
			else if (blockID == Blocks.snow.getDefaultState() && blockIDBelow == x)
				return true;
		}
		return false;
	}

	public Abyruin() { }

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {

		if(!LocationIsValidSpawn(world, pos) || !LocationIsValidSpawn(world, pos.east(7)) || !LocationIsValidSpawn(world, pos.add(7, 0, 8)) || !LocationIsValidSpawn(world, pos.south(8)))
			return false;

		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();

		world.setBlockState(new BlockPos(i - 4, j, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j, k - 5), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j, k - 4), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 1, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 1, k - 5), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 1, k - 4), ACBlocks.abyssal_stone_brick_fence.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 1, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 1, k - 2), ACBlocks.abyssal_stone_brick_fence.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 1, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 1, k), ACBlocks.abyssal_stone_brick_fence.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 1, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 1, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 2, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 2, k - 5), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 2, k - 4), ACBlocks.abyssal_stone_brick_fence.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 2, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 2, k - 2), ACBlocks.abyssal_stone_brick_fence.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 2, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 2, k), ACBlocks.abyssal_stone_brick_fence.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 2, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 2, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 3, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 3, k - 5), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 3, k - 4), ACBlocks.abyssal_stone_brick_fence.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 3, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 3, k - 2), ACBlocks.abyssal_stone_brick_fence.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 3, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 3, k), ACBlocks.abyssal_stone_brick_fence.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 4, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 4, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 4, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 4, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 5, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 4, j + 5, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j, k - 5), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j, k - 4), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 1, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 1, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 2, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 2, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 3, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 3, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 4, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 5, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 5, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j - 7, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j - 7, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j - 7, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j - 7, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j - 6, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j - 6, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j - 6, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j - 6, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j - 5, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j - 5, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j - 5, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j - 5, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j, k - 5), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j, k - 4), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j, k - 2), ACBlocks.abyssal_stone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j, k - 1), ACBlocks.abyssal_stone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 1, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 1, k - 3), ACBlocks.abyssal_stone_brick_fence.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 1, k), ACBlocks.abyssal_stone_brick_fence.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 1, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 2, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 2, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 3, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 3, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 4, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 4, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 5, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 5, k - 5), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 5, k - 4), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 5, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 5, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 8, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 8, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 8, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 8, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 7, k - 4), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 7, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 6, k - 4), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 6, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 5, k - 4), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 5, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 4, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 4, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 4, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 4, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 4, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 3, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 3, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 3, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 2, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 2, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 2, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 1, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 1, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 1, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j, k - 5), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j, k - 4), ACBlocks.abyssal_stone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j, k - 3), ACBlocks.abyssal_stone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j, k - 1), ACBlocks.abyssal_stone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j, k), ACBlocks.abyssal_stone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j, k + 1), ACBlocks.abyssal_stone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 1, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 2, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 3, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 4, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 4, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 5, k - 5), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 5, k - 4), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 5, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 5, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 5, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 8, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 8, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 8, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 8, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 7, k - 4), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 7, k - 3), Blocks.chest.getStateFromMeta(3), 2); //TODO: 3
		TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(new BlockPos(i, j - 7, k - 3));
		if(tileentitychest != null)
			WeightedRandomChestContent.generateChestContents(rand, ACLoot.strongholdChestContents, tileentitychest, ChestGenHooks.getCount(STRONGHOLD_CORRIDOR, rand));
		world.setBlockState(new BlockPos(i, j - 7, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 6, k - 4), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 6, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 5, k - 4), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 5, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 4, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 4, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 4, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 4, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 3, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 3, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 2, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 2, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 1, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 1, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j, k - 5), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j, k - 4), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j, k - 3), ACBlocks.abyssal_stone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j, k - 2), ACBlocks.abyssal_stone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j, k - 1), ACBlocks.abyssal_stone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j, k), ACBlocks.coralium_stone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j, k + 1), ACBlocks.abyssal_stone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 1, k + 1), Blocks.chest.getStateFromMeta(2), 2); //TODO: 2
		TileEntityChest tileentitychest2 = (TileEntityChest)world.getTileEntity(new BlockPos(i, j + 1, k + 1));
		if(tileentitychest2 != null)
			WeightedRandomChestContent.generateChestContents(rand, ChestGenHooks.getItems(DUNGEON_CHEST, rand), tileentitychest2, ChestGenHooks.getCount(DUNGEON_CHEST, rand));
		world.setBlockState(new BlockPos(i, j + 1, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 2, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 3, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 4, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 4, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 5, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 5, k - 4), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 5, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 5, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 5, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 8, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 8, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 8, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 8, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 7, k - 4), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 7, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 6, k - 4), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 6, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 5, k - 4), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 5, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 4, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 4, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 4, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 4, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 4, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 3, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 3, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 3, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 2, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 2, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 2, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 1, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 1, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 1, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j, k - 5), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j, k - 4), ACBlocks.abyssal_stone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j, k - 3), ACBlocks.abyssal_stone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j, k - 1), ACBlocks.abyssal_stone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j, k), ACBlocks.abyssal_stone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j, k + 1), ACBlocks.abyssal_stone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 1, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 2, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 3, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 4, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 4, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 5, k - 5), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 5, k - 4), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 5, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 5, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 5, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 5, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j - 7, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j - 7, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j - 7, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j - 7, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j - 6, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j - 6, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j - 6, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j - 6, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j - 5, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j - 5, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j - 5, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j - 5, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j, k - 5), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j, k - 4), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j, k - 2), ACBlocks.abyssal_stone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j, k - 1), ACBlocks.abyssal_stone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 1, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 1, k - 3), ACBlocks.abyssal_stone_brick_fence.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 1, k), ACBlocks.abyssal_stone_brick_fence.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 2, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 3, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 4, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 4, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 5, k - 5), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 5, k - 4), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 5, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 5, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 5, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 5, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j, k - 5), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j, k - 4), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 1, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 2, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 3, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 4, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 4, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 5, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 5, k - 4), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 5, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 5, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 5, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j, k - 5), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j, k - 4), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j, k), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 1, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 1, k - 5), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 1, k - 4), ACBlocks.abyssal_stone_brick_fence.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 1, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 1, k - 2), ACBlocks.abyssal_stone_brick_fence.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 1, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 1, k), ACBlocks.abyssal_stone_brick_fence.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 2, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 2, k - 5), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 2, k - 4), ACBlocks.abyssal_stone_brick_fence.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 2, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 2, k - 2), ACBlocks.abyssal_stone_brick_fence.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 2, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 2, k), ACBlocks.abyssal_stone_brick_fence.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 3, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 3, k - 5), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 3, k - 4), ACBlocks.abyssal_stone_brick_fence.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 3, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 3, k - 2), ACBlocks.abyssal_stone_brick_fence.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 3, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 3, k), ACBlocks.abyssal_stone_brick_fence.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 4, k - 6), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 4, k - 5), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 4, k - 4), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 4, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 4, k - 2), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 4, k - 1), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 5, k - 5), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 5, k - 3), ACBlocks.abyssal_stone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 1, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 1, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 1, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 1, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 1, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 1, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 1, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 2, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 2, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 2, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 2, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 2, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 2, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 2, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 3, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 3, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 3, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 3, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 3, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 3, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 3, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 4, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 4, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 4, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 4, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 4, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 4, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 3, j + 4, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 1, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 1, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 1, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 1, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 1, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 2, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 2, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 2, k - 3), Blocks.torch.getStateFromMeta(5), 2); //TODO: 5
		world.setBlockState(new BlockPos(i - 2, j + 2, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 2, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 2, k), Blocks.torch.getStateFromMeta(5), 2); //TODO: 5
		world.setBlockState(new BlockPos(i - 2, j + 2, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 3, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 3, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 3, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 3, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 3, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 3, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 3, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 4, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 4, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 4, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 4, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 4, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 4, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 2, j + 4, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 7, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 7, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 7, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 7, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 6, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 6, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 6, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 6, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 5, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 5, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 5, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j - 5, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 1, k - 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 1, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 1, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 1, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 1, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 1, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 1, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 1, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 2, k - 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 2, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 2, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 2, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 2, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 2, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 2, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 2, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 3, k - 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 3, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 3, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 3, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 3, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 3, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 3, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 3, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 4, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 4, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 4, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 4, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 4, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 4, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i - 1, j + 4, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 7, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 7, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 7, k), Blocks.ladder.getStateFromMeta(2), 2); //TODO: 2
		world.setBlockState(new BlockPos(i, j - 6, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 6, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 6, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 6, k), Blocks.ladder.getStateFromMeta(2), 2); //TODO: 2
		world.setBlockState(new BlockPos(i, j - 5, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 5, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 5, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j - 5, k), Blocks.ladder.getStateFromMeta(2), 2); //TODO: 2
		world.setBlockState(new BlockPos(i, j - 4, k), Blocks.ladder.getStateFromMeta(2), 2); //TODO: 2
		world.setBlockState(new BlockPos(i, j - 3, k), Blocks.ladder.getStateFromMeta(2), 2); //TODO: 2
		world.setBlockState(new BlockPos(i, j - 2, k), Blocks.ladder.getStateFromMeta(2), 2); //TODO: 2
		world.setBlockState(new BlockPos(i, j - 1, k), Blocks.ladder.getStateFromMeta(2), 2); //TODO: 2
		world.setBlockState(new BlockPos(i, j + 1, k - 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 1, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 1, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 1, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 1, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 1, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 1, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 2, k - 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 2, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 2, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 2, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 2, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 2, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 2, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 2, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 3, k - 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 3, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 3, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 3, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 3, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 3, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 3, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 3, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 4, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 4, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 4, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 4, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 4, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 4, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i, j + 4, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 7, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 7, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 7, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 7, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 6, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 6, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 6, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 6, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 5, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 5, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 5, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j - 5, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 1, k - 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 1, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 1, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 1, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 1, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 1, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 1, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 1, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 2, k - 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 2, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 2, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 2, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 2, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 2, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 2, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 2, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 3, k - 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 3, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 3, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 3, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 3, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 3, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 3, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 3, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 4, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 4, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 4, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 4, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 4, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 4, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 4, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 1, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 1, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 1, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 1, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 2, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 2, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 2, k - 3), Blocks.torch.getStateFromMeta(5), 2); //TODO: 5
		world.setBlockState(new BlockPos(i + 2, j + 2, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 2, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 2, k), Blocks.torch.getStateFromMeta(5), 2); //TODO: 5
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 3, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 3, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 3, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 3, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 3, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 3, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 4, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 4, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 4, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 4, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 4, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 4, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 4, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 1, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 1, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 1, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 1, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 1, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 1, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 2, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 2, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 2, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 2, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 2, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 2, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 3, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 3, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 3, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 3, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 3, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 3, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 4, k - 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 4, k - 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 4, k - 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 4, k - 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 4, k - 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 4, k), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 4, k + 1), Blocks.air.getDefaultState(), 2);

		return true;
	}
}
