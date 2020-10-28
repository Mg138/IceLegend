package com.icelegend;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class IceLegend extends JavaPlugin implements Listener{
	// initialize the yaml files
	public File msg = new File(this.getDataFolder(), "Messages.yml");
	public File attr_gui = new File(this.getDataFolder(), "AttributeGUI.yml");
	public File attr_name = new File(this.getDataFolder(), "AttributeName.yml");
	public File class_yml = new File(this.getDataFolder(), "Class.yml");
	public File class_gui = new File(this.getDataFolder(), "ClassGUI.yml");
	public File components_yml = new File(this.getDataFolder(), "Components.yml");
	public File gem = new File(this.getDataFolder(), "Gem.yml");
	public File gem_com = new File(this.getDataFolder(), "GemCombineGUI.yml");
	public File item_com = new File(this.getDataFolder(), "ItemCombineGUI.yml");
	public File item_mat = new File(this.getDataFolder(), "ItemMaterial.yml");
	public File item_skin = new File(this.getDataFolder(), "ItemSkin.yml");
	public File item_skin_com = new File(this.getDataFolder(), "ItemSkinCombineGUI.yml");
	public File item_tem = new File(this.getDataFolder(), "ItemTemplate.yml");
	public File placeholder = new File(this.getDataFolder(), "Placeholder_List.yml");
	public File series_lore = new File(this.getDataFolder(), "SeriesLore.yml");
	// initialize the yaml configurations
	public FileConfiguration msg_config = YamlConfiguration.loadConfiguration(msg);
	public FileConfiguration attr_gui_config = YamlConfiguration.loadConfiguration(attr_gui);
	public FileConfiguration attr_name_config = YamlConfiguration.loadConfiguration(attr_name);
	public FileConfiguration class_yml_config = YamlConfiguration.loadConfiguration(class_yml);
	public FileConfiguration class_gui_config = YamlConfiguration.loadConfiguration(class_gui);
	public FileConfiguration components_yml_config = YamlConfiguration.loadConfiguration(components_yml);
	public FileConfiguration gem_config = YamlConfiguration.loadConfiguration(gem);
	public FileConfiguration gem_com_config = YamlConfiguration.loadConfiguration(gem_com);
	public FileConfiguration item_com_config = YamlConfiguration.loadConfiguration(item_com);
	public FileConfiguration item_mat_config = YamlConfiguration.loadConfiguration(item_mat);
	public FileConfiguration item_skin_config = YamlConfiguration.loadConfiguration(item_skin);
	public FileConfiguration item_skin_com_config = YamlConfiguration.loadConfiguration(item_skin_com);
	public FileConfiguration item_tem_config = YamlConfiguration.loadConfiguration(item_tem);
	public FileConfiguration placeholder_config = YamlConfiguration.loadConfiguration(placeholder);
	public FileConfiguration series_lore_config = YamlConfiguration.loadConfiguration(series_lore);

	@Override
	public void onEnable() {
		// if the YAML disappear, generate one.
		if (!msg.exists())
			saveResource("Messages.yml", false);
		if (!attr_gui.exists())
			saveResource("AttributeGUI.yml", false);
		if (!attr_name.exists())
			saveResource("AttributeName.yml", false);
		if (!class_yml.exists())
			saveResource("Class.yml", false);
		if (!class_gui.exists())
			saveResource("ClassGUI.yml", false);
		if (!components_yml.exists())
			saveResource("Components.yml", false);
		if (!gem.exists())
			saveResource("Gem.yml", false);
		if (!gem_com.exists())
			saveResource("GemCombine.yml", false);
		if (!item_com.exists())
			saveResource(".yml", false);
		if (!item_mat.exists())
			saveResource("ItemMaterial.yml", false);
		if (!item_skin.exists())
			saveResource("ItemSkin.yml", false);
		if (!item_skin_com.exists())
			saveResource("ItemSkinCombineGUI.yml", false);
		if (!item_tem.exists())
			saveResource("ItemTemplate.yml", false);
		if (!placeholder.exists())
			saveResource("Placeholder_List.yml", false);
		if (!series_lore.exists())
			saveResource("SeriesLore.yml", false);

		// initialize the command classes
		this.getCommand("icelegend").setExecutor(new CommandIceLegend(this));
		this.getCommand("skilltreegui").setExecutor(new CommandSkillTreeGUI(this));
		this.getCommand("attributegui").setExecutor(new CommandAttributeGUI(this));
		this.getCommand("skilltreegui").setExecutor(new CommandCombineSkillGUI(this)); 
		this.getCommand("classgui").setExecutor(new CommandClassGUI(this));
		this.getCommand("selectclassgui").setExecutor(new CommandSelectClassGUI(this));
		this.getCommand("itemcombinegui").setExecutor(new CommandItemCombineGUI(this)); 
		this.getCommand("bindskillgui").setExecutor(new CommandBindSkillGUI(this));
		this.getCommand("itemskincombinegui").setExecutor(new CommandItemSkinCombineGUI(this));
		this.getCommand("gemcombinegui").setExecutor(new CommandGemCombineGUI(this)); 
		this.getCommand("skillbar").setExecutor(new CommandSkillBar(this));
		// Register the clicker event to the plugin.
		Bukkit.getPluginManager().registerEvents(new ClickerEvent(), this);
		getLogger().info(format(msg_config.getString("Messages.loadplugin")));
	}

	// Fired when plugin is disabled
	@Override
	public void onDisable() {
		getLogger().info(format(msg_config.getString("Messages.disableplugin")));
	}

	// Format the string with color codes
	public String format(String str) {
		return ChatColor.translateAlternateColorCodes('&', str.replace("%prefix%", msg_config.getString("prefix")));
	}

}
