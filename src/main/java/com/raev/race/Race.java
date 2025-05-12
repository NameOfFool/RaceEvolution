package com.raev.race;

import io.netty.buffer.ByteBuf;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.text.Text;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Race {

    /**
     * Codec format:
     * id:1
     * title:"Human"
     * description:"Only human"
     */
    public static final PacketCodec<ByteBuf, Race> PACKET_CODEC= new PacketCodec<ByteBuf, Race>() {
        @Override
        public Race decode(ByteBuf buf) {
            Integer id = PacketCodecs.INTEGER.decode(buf);
            String title = PacketCodecs.STRING.decode(buf);
            String description = PacketCodecs.STRING.decode(buf);
            return new Race(id, title, Text.of(description));
        }

        @Override
        public void encode(ByteBuf buf, Race value) {
            PacketCodecs.INTEGER.encode(buf, value.getId());
            PacketCodecs.STRING.encode(buf, value.getTitle());
            PacketCodecs.STRING.encode(buf, value.getDescription().getString());
        }
    };


    private Integer id;
    private String title;
    private Text description;


}
