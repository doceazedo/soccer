package com.doceazedo.soccer.events

import com.doceazedo.soccer.Soccer
import org.bukkit.Sound
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent

object PlayerMove : Listener {
    @EventHandler
    fun onPlayerMove (e: PlayerMoveEvent) {
        if (Soccer.ball == null) return
        val entities = e.player.world.getNearbyEntities(e.player.location, 0.8, 0.8, 0.8)
        if (!entities.contains(Soccer.ball)) return

        e.player.playSound(e.player.location, Sound.ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR, 0.5f, 1f)

        // Embaixadinha
        if (e.player.isSneaking) {
            Soccer.ball!!.velocity = Soccer.ball!!.velocity.setY(0.6)
            return
        }

        // Chute
        var kickPower = 1.5
        if (e.player.isSprinting) kickPower = 2.0
        Soccer.ball!!.velocity = e.player.location.direction.multiply(kickPower).setY(0)
    }
}