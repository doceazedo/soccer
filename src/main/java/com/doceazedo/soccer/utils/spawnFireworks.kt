package com.doceazedo.soccer.utils

import org.bukkit.Color
import org.bukkit.FireworkEffect
import org.bukkit.Location
import org.bukkit.entity.EntityType
import org.bukkit.entity.Firework

fun spawnFireworks (loc: Location, color: Color) {
    val firework = loc.world!!.spawnEntity(loc, EntityType.FIREWORK) as Firework
    val fireworkData = firework.fireworkMeta
    fireworkData.power = 32
    fireworkData.addEffect(
        FireworkEffect
            .builder()
            .withColor(color)
            .flicker(true)
            .build()
    )
    firework.fireworkMeta = fireworkData
    firework.detonate()
}