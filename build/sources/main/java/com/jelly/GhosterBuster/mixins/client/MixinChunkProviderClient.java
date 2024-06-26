package com.jelly.GhosterBuster.mixins.client;

import com.jelly.GhosterBuster.GhosterBuster;
import com.jelly.GhosterBuster.events.ChunkLoadEvent;
import net.minecraft.client.multiplayer.ChunkProviderClient;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChunkProviderClient.class)
public class MixinChunkProviderClient {
    @Inject(method = { "loadChunk" }, at = { @At(value = "HEAD")})
    private void loadChunk(int chunkX, int chunkZ, CallbackInfoReturnable<Chunk> cir) {
        MinecraftForge.EVENT_BUS.post(new ChunkLoadEvent());
    }

}
