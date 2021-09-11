package ru.redguy.webinfo.sponge.utils;

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import ru.redguy.webinfo.common.structures.Location;
import ru.redguy.webinfo.common.structures.World;
import ru.redguy.webinfo.common.structures.WorldBorder;

import java.util.UUID;

public class TransformUtils {
    public static World transform(org.spongepowered.api.world.World world) {
        UUID[] entities = world.getEntities().stream().map(Entity::getUniqueId).toArray(UUID[]::new);
        String[] players = world.getPlayers().stream().map(Player::getName).toArray(String[]::new);
        String[] gamerules = world.getGameRules().keySet().toArray(new String[0]);
        return new World(world.getName(), entities, players, world.getUniqueId(), transform(world.getSpawnLocation()), world.getProperties().getWorldTime(), world.getProperties().getTotalTime(), world.getProperties().isRaining(), world.getProperties().getRainTime(), world.getProperties().isThundering(), world.getProperties().getThunderTime(), world.getProperties().getDimensionType().getId(), world.getProperties().getSeed(), world.getProperties().isPVPEnabled(), world.getDimension().getHeight(), world.getSeaLevel(), world.getProperties().doesKeepSpawnLoaded(), world.getDifficulty().getId(), world.getDimension().getGeneratorType().getName(), gamerules, transform(world.getWorldBorder()));
    }

    public static Location transform(org.spongepowered.api.world.Location<org.spongepowered.api.world.World> location) {
        return new Location(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    public static Location transform(Vector3d location) {
        return new Location(location.getX(), location.getY(), location.getZ());
    }

    public static WorldBorder transform(org.spongepowered.api.world.WorldBorder worldBorder) {
        return new WorldBorder(worldBorder.getDiameter(), transform(worldBorder.getCenter()), worldBorder.getDamageThreshold(), worldBorder.getDamageAmount(), worldBorder.getWarningTime(), worldBorder.getWarningDistance());
    }
}
