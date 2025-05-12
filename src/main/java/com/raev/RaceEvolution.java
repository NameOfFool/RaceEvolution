package com.raev;

import com.raev.networking.payload.SelectRaceC2SPayload;
import com.raev.networking.payload.ShowSelectRaceScreenS2CPayload;
import com.raev.race.Race;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class RaceEvolution implements ModInitializer {
	public static final String MOD_ID = "race-evolution-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static List<Race> races = new ArrayList<Race>();

	@Override
	public void onInitialize() {
		races.add(new Race(1, "Human", Text.of("Only Human")));

		PayloadTypeRegistry.playS2C().register(ShowSelectRaceScreenS2CPayload.ID, ShowSelectRaceScreenS2CPayload.CODEC);
		PayloadTypeRegistry.playC2S().register(SelectRaceC2SPayload.ID, SelectRaceC2SPayload.CODEC);

		ServerPlayConnectionEvents.INIT.register((handler, server)->{
			Race race = handler.player.getAttached(ModAttachments.RACE);
			if(race == null){
				ShowSelectRaceScreenS2CPayload payload = new ShowSelectRaceScreenS2CPayload(races);
				ServerPlayNetworking.send(handler.player, payload);
			}
		});

		ServerPlayNetworking.registerGlobalReceiver(SelectRaceC2SPayload.ID, ((payload, context) -> {
			Race selectedRace = races.get(payload.raceId());
		}));
	}
}
