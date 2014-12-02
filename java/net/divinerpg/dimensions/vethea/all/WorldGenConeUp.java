package net.divinerpg.dimensions.vethea.all;

import java.util.Random;

import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenConeUp extends WorldGenerator
{
	private final Block block;
	private int height;

	public WorldGenConeUp(Block b) {
		block = b;
	}

	@Override
	public boolean generate(World par1, Random par2, int par3, int par4, int par5) {
		int var2 = par2.nextInt(4) + height;
		while(par1.isAirBlock(par3, par4, par5)){
			height--;
			for (int i = 0; i < var2; i++) {
				this.placeBlockCircle(par1, par3, par4 + i, par5, var2 - i);
			}
		}
		return true;
	}

	public boolean generate(World par1, Random par2, int par3, int par4, int par5, int h) {
		height = h;
		return generate(par1, par2, par3, par4, par5);
	}

	void placeBlockCircle (World par1World, int x, int y, int z, int radius) {
		for (float i = 0; i < radius; i += 0.5) {
			for (float j = 0; j < 2 * Math.PI * i; j += 0.5) {
				par1World.setBlock((int)Math.floor(x + Math.sin(j) * i), y, (int)Math.floor(z + Math.cos(j) * i), block);
			}
		}
	}
}