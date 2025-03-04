package ac.grim.grimac.utils.data.packetentity;

import ac.grim.grimac.player.GrimPlayer;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;

public class PacketEntityHorse extends PacketEntity {

    public boolean isRearing = false;
    public boolean hasSaddle = false;
    public boolean isTame = false;
    public boolean hasChest = false;
    public double jumpStrength = 0.7;
    public float movementSpeedAttribute = 0.1f;
    public int llamaStrength;

    // I give up with handling jump boost potions
    // I can't figure out which packet give a horse potion effects
    // Anyways, what's the chances of a plugin:
    // 1) Summoning a horse with packet without a real entity id
    // 2) Having the player ride this horse
    // 3) Giving the horse jump boost, somehow, not sure which packet it is
    //
    // If any one of the three scenarios is false, we are fine
    // If you do see a plugin doing this, please tell me which packet it is

    public PacketEntityHorse(GrimPlayer player, EntityType type, double x, double y, double z) {
        super(player, type, x, y, z);
    }
}
