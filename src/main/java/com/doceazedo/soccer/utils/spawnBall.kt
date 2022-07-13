package com.doceazedo.soccer.utils

import com.doceazedo.soccer.Soccer
import org.bukkit.Location
import org.bukkit.entity.EntityType
import org.bukkit.entity.Slime

val spawn = Soccer.instance.config.get("spawn") as Location

fun spawnBall () {
    Soccer.ball?.remove()
    Soccer.ball = spawn.world?.spawnEntity(spawn, EntityType.SLIME) as Slime
    Soccer.ball?.size = 1
    Soccer.ball?.isAware = false
}