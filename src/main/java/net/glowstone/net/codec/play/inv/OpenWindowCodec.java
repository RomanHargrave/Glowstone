package net.glowstone.net.codec.play.inv;

import com.flowpowered.networking.Codec;
import com.flowpowered.networking.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;
import net.glowstone.net.message.play.inv.OpenWindowMessage;

import java.io.IOException;

public final class OpenWindowCodec implements Codec<OpenWindowMessage> {
    public OpenWindowMessage decode(ByteBuf buf) throws IOException {
        throw new DecoderException("Cannot decode OpenWindowMessage");
    }

    public ByteBuf encode(ByteBuf buf, OpenWindowMessage message) throws IOException {
        buf.writeByte(message.getId());
        buf.writeByte(message.getType());
        ByteBufUtils.writeUTF8(buf, message.getTitle());
        buf.writeByte(message.getSlots());
        buf.writeBoolean(message.getUseTitle());
        if (message.getEntityId() != 0) {
            // magic number 11 for AnimalChest type which Bukkit doesn't seem to know about
            buf.writeInt(message.getEntityId());
        }
        return buf;
    }
}
