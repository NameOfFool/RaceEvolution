package com.raev;

import com.raev.race.Race;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.util.Identifier;

public class ModAttachments {
    public static final AttachmentType<Race> RACE =
            AttachmentRegistry.createPersistent(Identifier.of(RaceEvolution.MOD_ID, "race"), Race.CODEC);
}
