package com.raev;

import com.raev.networking.payload.SelectRaceC2SPayload;
import com.raev.networking.payload.ShowSelectRaceScreenS2CPayload;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;


public class RaceEvolutionClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {


        ClientPlayNetworking
                .registerGlobalReceiver(ShowSelectRaceScreenS2CPayload.ID,
                        (payload, context) -> {
                            SelectRaceC2SPayload response = new SelectRaceC2SPayload(payload.raceList().getFirst().getId());
			                ClientPlayNetworking.send(response);
                        });

    }
}