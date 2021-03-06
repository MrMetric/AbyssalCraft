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
package com.shinoow.abyssalcraft.client.model.item;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHilt extends ModelBase {

	ModelRenderer handle;
	ModelRenderer tsuba;

	public ModelHilt()
	{
		textureWidth = 64;
		textureHeight = 32;

		handle = new ModelRenderer(this, 0, 0);
		handle.addBox(0F, 0F, 0F, 2, 2, 7);
		handle.setRotationPoint(-7F, 9F, -4F);
		handle.setTextureSize(64, 32);
		handle.mirror = true;
		setRotation(handle, 0F, 0F, 0F);
		tsuba = new ModelRenderer(this, 18, 0);
		tsuba.addBox(0F, 0F, 0F, 4, 4, 1);
		tsuba.setRotationPoint(-8F, 8F, -5F);
		tsuba.setTextureSize(64, 32);
		tsuba.mirror = true;
		setRotation(tsuba, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		handle.render(f5);
		tsuba.render(f5);
	}

	public void render(float f){

		handle.render(f);
		tsuba.render(f);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
