package com.doceazedo.soccer

import com.doceazedo.soccer.commands.FutebolCmd
import com.doceazedo.soccer.events.EntityDamage
import com.doceazedo.soccer.events.PlayerMove
import com.doceazedo.soccer.utils.checkGoal
import org.bukkit.Bukkit
import org.bukkit.entity.Slime
import org.bukkit.plugin.java.JavaPlugin

class Soccer : JavaPlugin() {
    companion object {
        lateinit var instance: Soccer
        var ball: Slime? = null
    }

    override fun onEnable() {
        instance = this
        saveDefaultConfig()
        getCommand("futebol")!!.setExecutor(FutebolCmd)
        Bukkit.getPluginManager().registerEvents(PlayerMove, this)
        Bukkit.getPluginManager().registerEvents(EntityDamage, this)

        val scheduler = server.scheduler
        scheduler.scheduleSyncRepeatingTask(this, {
            checkGoal()
        }, 0L, 2L)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}