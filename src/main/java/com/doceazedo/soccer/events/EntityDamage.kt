package com.doceazedo.soccer.events

import com.doceazedo.soccer.Soccer
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent

object EntityDamage : Listener {
    @EventHandler
    fun onEntityDamage (e: EntityDamageEvent) {
        if (e.entity == Soccer.ball) e.isCancelled = true
    }
}