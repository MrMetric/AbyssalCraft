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

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.shinoow.abyssalcraft.common.blocks.tile.TileEntityAltar;

public class BlockAltar extends BlockContainer {

	public BlockAltar() {
		super(Material.rock);
		setHarvestLevel("pickaxe", 3);
		setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.7F, 0.9F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int var2) {

		return new TileEntityAltar();
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderType() {
		return -2;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
}
