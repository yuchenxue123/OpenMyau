package myau.module.modules;

import myau.module.Category;
import myau.module.Module;
import myau.util.ItemUtil;
import myau.util.TeamUtil;
import myau.property.properties.BooleanProperty;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class GhostHand extends Module {
    public final BooleanProperty teamsOnly = new BooleanProperty("team-only", true);
    public final BooleanProperty ignoreWeapons = new BooleanProperty("ignore-weapons", false);

    public GhostHand() {
        super("GhostHand", Category.MISC, false);
    }

    public boolean shouldSkip(Entity entity) {
        return entity instanceof EntityPlayer
                && !TeamUtil.isBot((EntityPlayer) entity)
                && (!this.teamsOnly.getValue() || TeamUtil.isSameTeam((EntityPlayer) entity))
                && (!this.ignoreWeapons.getValue() || !ItemUtil.hasRawUnbreakingEnchant());
    }
}
