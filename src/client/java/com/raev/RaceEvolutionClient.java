package com.raev;

import com.raev.screen.CustomScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class RaceEvolutionClient implements ClientModInitializer {

	private boolean hasTriggered = false;
	@Override
	public void onInitializeClient() {
		ClientTickEvents.END_CLIENT_TICK.register(client ->{
			if (client.player != null && !hasTriggered) {
				client.setScreen(new CustomScreen(Text.empty()));
				hasTriggered = true;
			}
		});
	}
}