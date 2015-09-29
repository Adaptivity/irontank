package com.indemnity83.irontank;

import com.indemnity83.irontank.block.TileIronTank;
import com.indemnity83.irontank.handler.ConfigurationHandler;
import com.indemnity83.irontank.init.ModBlocks;
import com.indemnity83.irontank.init.ModItems;
import com.indemnity83.irontank.init.ModRecipies;
import com.indemnity83.irontank.proxy.IProxy;
import com.indemnity83.irontank.reference.Reference;
import com.indemnity83.irontank.utility.LogHelper;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class IronTank {

	@Mod.Instance(Reference.MODID)
	public static IronTank instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;

	@Mod.EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		ModItems.init();
		ModBlocks.init();
		LogHelper.info("Pre Initialization Complete!");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		ModRecipies.init();
		LogHelper.info("Initialization Complete!");
	}

	@Mod.EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		LogHelper.info("Post Initialization Complete!");
	}

	@Mod.EventHandler
	public void load(FMLInitializationEvent evt) {
		GameRegistry.registerTileEntity(TileIronTank.class, "com.indemnity83.irontank.block.TileIronTank");
	}
}
