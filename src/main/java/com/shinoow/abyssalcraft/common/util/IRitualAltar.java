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
package com.shinoow.abyssalcraft.common.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Internal interface for Ritual Altar TE's<br>
 * This shouldn't be used by other mods.
 * @author shinoow
 *
 */
public interface IRitualAltar extends ISingletonInventory {

	/**
	 * Attempts to perform a ritual
	 * @param world Current World
	 * @param x TE X-Coordinate
	 * @param y TE Y-Coordinate
	 * @param z TE Z-Coordinate
	 * @param player Player interacting with the altar
	 */
	public void performRitual(World world, int x, int y, int z, EntityPlayer player);

	/**
	 * Used to determine if a Ritual can be performed
	 */
	public boolean canPerform();

	/**
	 * Check the surroundings (to make sure there's Pedestals, and that they have items placed on them)
	 * @param world Current World
	 * @param x TE X-Coordinate
	 * @param y TE Y-Coordinate
	 * @param z TE Z-Coordinate
	 */
	public boolean checkSurroundings(World world, int x, int y, int z);

	/**
	 * Resets all the pedestals (removes any item placed on them)
	 * @param world Current World
	 * @param x TE X-Coordinate
	 * @param y TE Y-Coordinate
	 * @param z TE Z-Coordinate
	 */
	public void resetPedestals(World world, int x, int y, int z);

	/**
	 * Returns the cooldown until a new Ritual can be performed
	 */
	public int getRitualCooldown();

	/**
	 * Determines if a Ritual is currently being performed
	 */
	public boolean isPerformingRitual();


}
