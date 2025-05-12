package com.raev.networking.payload;

import com.raev.RaceEvolution;
import com.raev.race.Race;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public record ShowSelectRaceScreenS2CPayload(List<Race> raceList) implements CustomPayload {
    public static final Identifier SHOW_SELECT_RACE_SCREEN_ID = Identifier.of(RaceEvolution.MOD_ID, "show_select_race_screen");
    public static final CustomPayload.Id<ShowSelectRaceScreenS2CPayload> ID = new Id<>(SHOW_SELECT_RACE_SCREEN_ID);
    public static final PacketCodec<ByteBuf, ShowSelectRaceScreenS2CPayload> CODEC =
            PacketCodec.tuple(
                    PacketCodecs.collection(ArrayList::new, Race.PACKET_CODEC),
                    ShowSelectRaceScreenS2CPayload::raceList,
                    ShowSelectRaceScreenS2CPayload::new);
    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
