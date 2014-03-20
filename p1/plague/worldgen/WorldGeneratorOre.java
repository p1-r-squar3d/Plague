package p1.plague.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import p1.plague.block.PlagueBlocks;
import p1.plague.block.ore.PlagueOres;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorOre implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
	
	switch(world.provider.dimensionId) {
		case 0 : generateSurface(world, random,chunkX*16,chunkZ*16);
		case 1 : generateNether(world, random,chunkX*16,chunkZ*16);
		}
	}
	
	private void generateSurface(World world, Random random, int BlockX, int BlockZ) {
	for(int i =0; i<10;i++){
		int Xcoord = BlockX + random.nextInt(16);
		int Zcoord = BlockZ + random.nextInt(16);
		int Ycoord = random.nextInt(16);
	(new WorldGenMinable(PlagueOres.oreAluminium.blockID, 4)).generate(world, random, Xcoord, Ycoord, Zcoord);
	(new WorldGenMinable(PlagueBlocks.blockAtrocious.blockID, 4)).generate(world, random, Xcoord, Ycoord, Zcoord);
		}
	}
	
	private void generateNether(World world, Random random, int BlockX, int BlockZ) {
		for(int i =0; i<10;i++){
			int Xcoord = BlockX + random.nextInt(16);
			int Zcoord = BlockZ + random.nextInt(16);
			int Ycoord = random.nextInt(16);
		(new WorldGenMinable(PlagueOres.oreAluminium.blockID, 4)).generate(world, random, Xcoord, Ycoord, Zcoord);
		(new WorldGenMinable(PlagueBlocks.blockAtrocious.blockID, 4)).generate(world, random, Xcoord, Ycoord, Zcoord);
		}
	}
}
