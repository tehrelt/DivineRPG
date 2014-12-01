package net.divinerpg.utils.proxies;

import net.divinerpg.DivineRPG;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityDemonFurnace;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityDramixAltar;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityExtractor;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityGreenlightFurnace;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityMoltenFurnace;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityMoonlightFurnace;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityOceanfireFurnace;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityParasectaAltar;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityWhitefireFurnace;
import net.divinerpg.blocks.iceika.container.tile_entity.TileEntityCoalstoneFurnace;
import net.divinerpg.blocks.iceika.container.tile_entity.TileEntityFrostedChest;
import net.divinerpg.blocks.twilight.TileEntityTwilightFurnace;
import net.divinerpg.blocks.vanilla.container.tile_entity.TileEntityAltarOfCorruption;
import net.divinerpg.blocks.vanilla.container.tile_entity.TileEntityAyeracoBeam;
import net.divinerpg.blocks.vethea.container.tile_entity.TileEntityInfusionTable;
import net.divinerpg.client.render.block.TileEntityStatue;
import net.divinerpg.dimensions.vanilla.WorldGenOverworld;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.utils.DimensionHelper;
import net.divinerpg.utils.LogHelper;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.blocks.TwilightBlocks;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.entities.ArcanaEntityRegistry;
import net.divinerpg.utils.entities.IceikaEntityRegistry;
import net.divinerpg.utils.entities.MobSpawning;
import net.divinerpg.utils.entities.TwilightEntityRegistry;
import net.divinerpg.utils.entities.VanillaEntityRegistry;
import net.divinerpg.utils.entities.VetheaEntityRegistry;
import net.divinerpg.utils.events.ArcanaTickHandler;
import net.divinerpg.utils.events.DivineRPGCommands;
import net.divinerpg.utils.events.EntityConstructorEvent;
import net.divinerpg.utils.events.EventArmorFullSet;
import net.divinerpg.utils.events.EventArmorTick;
import net.divinerpg.utils.events.EventBonemeal;
import net.divinerpg.utils.events.EventBucketFill;
import net.divinerpg.utils.events.EventDeath;
import net.divinerpg.utils.events.EventHarvest;
import net.divinerpg.utils.events.EventLightningStrike;
import net.divinerpg.utils.items.ArcanaItems;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.items.ItemsFood;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.divinerpg.utils.recipes.TwilightRecipeHelper;
import net.divinerpg.utils.recipes.VanillaRecipeHelper;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.command.CommandHandler;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy{
	public void preInitClient(FMLPreInitializationEvent event){}

	public void renderThings(){}
	
	public void preInitServer(FMLPreInitializationEvent event){
		LogHelper.info("Adding events");
		Util.addEventBus(new EventBucketFill());
		Util.addEventBus(new EventBonemeal());
		Util.addEventBus(new EventArmorFullSet());
		Util.addSpecialEventBus(new EventArmorTick());
		Util.addEventBus(new EventLightningStrike());
		Util.addEventBus(new EventHarvest());
		Util.addEventBus(new EventDeath());
        Util.addSpecialEventBus(new ArcanaTickHandler());
        Util.addEventBus(new EntityConstructorEvent());
		LogHelper.info("Registering tile entities");
		ItemsFood.init();
		VanillaBlocks.init();
		TwilightBlocks.init();
		TwilightItemsOther.init();
		VanillaItemsOther.init();
		ArcanaBlocks.init();
		ArcanaItems.init();
		DivineRPGTabs.init();
		GameRegistry.registerTileEntity(TileEntityTwilightFurnace.class, "Twilight Furnace");
		GameRegistry.registerTileEntity(TileEntityInfusionTable.class, "Infusion Table");
		GameRegistry.registerTileEntity(TileEntityStatue.class, "Statue");
		GameRegistry.registerTileEntity(TileEntityFrostedChest.class, "Iceika Chest");
		GameRegistry.registerTileEntity(TileEntityAyeracoBeam.class, "Ayeraco Beam");
		GameRegistry.registerTileEntity(TileEntityExtractor.class, "Extractor");
		GameRegistry.registerTileEntity(TileEntityDramixAltar.class, "Dramix Altar");
		GameRegistry.registerTileEntity(TileEntityParasectaAltar.class, "Parasecta Altar");
		GameRegistry.registerTileEntity(TileEntityCoalstoneFurnace.class, "Coalstone Furnace");
		GameRegistry.registerTileEntity(TileEntityGreenlightFurnace.class, "Greenlight Furnace");
		GameRegistry.registerTileEntity(TileEntityMoltenFurnace.class, "Molten Furnace");
		GameRegistry.registerTileEntity(TileEntityMoonlightFurnace.class, "Moonlight Furnace");
		GameRegistry.registerTileEntity(TileEntityOceanfireFurnace.class, "Oceanfire Furnace");
		GameRegistry.registerTileEntity(TileEntityWhitefireFurnace.class, "Whitefire Furnace");
		GameRegistry.registerTileEntity(TileEntityDemonFurnace.class, "Demon Furnace");
		GameRegistry.registerTileEntity(TileEntityAltarOfCorruption.class, "Altar Of Corruption");
		LogHelper.info("Registering entities");
		VanillaEntityRegistry.init();
		TwilightEntityRegistry.init();
		IceikaEntityRegistry.init();
		VetheaEntityRegistry.init();
		ArcanaEntityRegistry.init();
		LogHelper.info("Adding crafting/smelting recipes");
		VanillaRecipeHelper.init();
		TwilightRecipeHelper.init();
		DimensionHelper.init();
	}

	public void init(FMLInitializationEvent event){
		LogHelper.info("Adding world generators");
		GameRegistry.registerWorldGenerator(new WorldGenOverworld(), 0);
		MobSpawning.addSpawns();
		DivineRPGAchievements.init();
	}

	public void postInit(FMLPostInitializationEvent event){
		Util.addBucket(DivineRPG.tarFluid, new ItemStack(VanillaItemsOther.tarBucket));
		Util.addBucket(DivineRPG.frozenLava, new ItemStack(IceikaItems.frozenLavaBucket));
	}

	public void serverStarting(FMLServerStartingEvent event){ 
		LogHelper.info("Setting up commands");
		if (MinecraftServer.getServer().getCommandManager() instanceof ServerCommandManager)
			((CommandHandler)MinecraftServer.getServer().getCommandManager()).registerCommand(new DivineRPGCommands());
	}
}
