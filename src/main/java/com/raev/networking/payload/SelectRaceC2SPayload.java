package com.raev.networking.payload;

import com.raev.RaceEvolution;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record SelectRaceC2SPayload(Integer raceId) implements CustomPayload {
    public static final Identifier SELECT_RACE_PAYLOAD_ID = Identifier.of(RaceEvolution.MOD_ID, "select_race");
    public static final Id<SelectRaceC2SPayload> ID = new Id<>(SELECT_RACE_PAYLOAD_ID);
    public static final PacketCodec<RegistryByteBuf, SelectRaceC2SPayload> CODEC =
            PacketCodec.tuple(PacketCodecs.INTEGER, SelectRaceC2SPayload::raceId, SelectRaceC2SPayload::new);

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
