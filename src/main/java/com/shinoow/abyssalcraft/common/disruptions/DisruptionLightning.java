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
package com.shinoow.abyssalcraft.common.disruptions;

import java.util.List;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.shinoow.abyssalcraft.api.energy.disruption.DisruptionEntry;

public class DisruptionLightning extends DisruptionEntry {

	public DisruptionLightning() {
		super("lightning", null);

	}

	@Override
	public void disrupt(World world, int x, int y, int z,List<EntityPlayer> players) {
		if(!players.isEmpty())
			for(EntityPlayer player : players)
				if(world.rand.nextInt(10) == 0)
					world.addWeatherEffect(new EntityLightningBolt(world, player.posX, player.posY, player.posZ));
	}
}
