/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.jotero.mcio;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author wero
 */
public class MCIo extends JavaPlugin {
    
    public File arenas;
    public File messages;
    
    //Enable method
    @Override
    public void onEnable() {
        
        //Create arenas.yml file
        arenas = new File(getDataFolder(), "arenas.yml");
        
        //Generate arenas.yml file if it doesn't exists
        if(!arenas.exists()) {
            try {
                arenas.createNewFile();
                
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        
        //Load arenas.yml
        YamlConfiguration localYamlConfiguration1 = YamlConfiguration.loadConfiguration(arenas);
        
        //Create messages.yml file
        messages = new File(getDataFolder(), "messages.yml");
        
        //Generate messages.yml file if it doesn't exists
        if(!messages.exists()) {
            try {
                messages.createNewFile();
                
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        
        //Load arenas.yml
        YamlConfiguration localYamlConfiguration2 = YamlConfiguration.loadConfiguration(messages);
        
        //Generates messages of messages.yml
        localYamlConfiguration2.addDefault("messages.arenacreated", "&fYou've created the MCIo arena %arena%!");
        localYamlConfiguration2.addDefault("messages.removecrystal", "&fRemoved all endercrystals near around you!");
        localYamlConfiguration2.addDefault("messages.setpoint1", "&fYou've successfully set the first point for the arena!");
        localYamlConfiguration2.addDefault("messages.setpoint2", "&fYou've successfully set the second point for the arena!");
        localYamlConfiguration2.addDefault("messages.maxsize", "&fYou've successfully set the max size for the arena!");
        localYamlConfiguration2.addDefault("messages.leavepoint", "&fYou've set the leavepoint for the arena!");
        localYamlConfiguration2.addDefault("messages.listarenas", "&fList of all MCIo arenas:");
        localYamlConfiguration2.addDefault("messages.arenaremoved", "&fSuccessfully removed arena %arena%!");
        localYamlConfiguration2.addDefault("messages.arenadoesntexist", "&fThis arena doesn't exist!");
        localYamlConfiguration2.addDefault("messages.gamemode.freemode", "&fSelected the FreeMode for the arena!");
        localYamlConfiguration2.addDefault("messages.gamemode.lastmanstand", "&fSelected the LastManStand-Mode for the arena!");
        localYamlConfiguration2.addDefault("messages.editable", "&fArena editable:");
        localYamlConfiguration2.addDefault("messages.arenaprotected", "&fMCIoj arena protected!");
        localYamlConfiguration2.addDefault("messages.join", "&fYou joined the game!");
        localYamlConfiguration2.addDefault("messages.leave", "&fYou've left the arena!");
        localYamlConfiguration2.addDefault("messages.joinsigncreated", "&fYou've created an MCIo join sign!");
        localYamlConfiguration2.addDefault("messages.leavesigncreated", "&fYou've created an MCIo leave sign!");
        localYamlConfiguration2.addDefault("messages.ejectmass", "&fSorry you can't eject mass. Please get at least a mass of 20!");
        localYamlConfiguration2.addDefault("messages.eaten", "&fYou were eaten by %killer%! Try again.");
        localYamlConfiguration2.addDefault("messages.eat", "&fYou ate %target%!");
        localYamlConfiguration2.addDefault("items.activateparticles", "&fClick to activate particles to see your size!");
        localYamlConfiguration2.addDefault("items.ejectmass", "&fClick to eject some mass!");
        localYamlConfiguration2.addDefault("items.disableparticles", "&fClick to disable particles!");
        localYamlConfiguration2.addDefault("items.leave", "&fLeave the arena!");
        localYamlConfiguration2.addDefault("items.slimeenabled", "&fSee you as a slime!");
        localYamlConfiguration2.addDefault("items.slimedisabled", "&fDisable selfview as a slime!");
        localYamlConfiguration2.addDefault("scoreboard.headline", "&fMCIo - Top 15");
        localYamlConfiguration2.addDefault("actionbar", "&fMass %mass% - Range: %range% blocks");
        localYamlConfiguration2.options().copyDefaults(true);
        
        try {
            localYamlConfiguration2.save(messages);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        
        localYamlConfiguration2 = YamlConfiguration.loadConfiguration(messages);
    }
    
    @Override
    public void onDisable() {
    }
    
    
    
}
