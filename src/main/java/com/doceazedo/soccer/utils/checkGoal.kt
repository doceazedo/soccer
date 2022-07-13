package com.doceazedo.soccer.utils

import com.doceazedo.soccer.Soccer
import org.bukkit.Bukkit
import org.bukkit.Color
import org.bukkit.util.BoundingBox

val goals = Soccer.instance.config.getList("goals") as List<BoundingBox>
val worldName = Soccer.instance.config.getString("world")!!
val world = Bukkit.getWorld(worldName)

fun checkGoal () {
    if (world == null) return
    val ballLoc = Soccer.ball?.location ?: return
    for (goal in goals) {
        if (!goal.contains(ballLoc.x, ballLoc.y, ballLoc.z)) continue
        val fireworkLoc = goal.center.toLocation(world)
        spawnFireworks(fireworkLoc, Color.LIME)
        spawnFireworks(fireworkLoc, Color.YELLOW)
        spawnBall()
    }
}