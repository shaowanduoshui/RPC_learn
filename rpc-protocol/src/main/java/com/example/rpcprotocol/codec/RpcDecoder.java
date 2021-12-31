package com.example.rpcprotocol.codec;

import com.example.rpcprotocol.protocol.MsgHeader;
import com.example.rpcprotocol.protocol.MsgType;
import com.example.rpcprotocol.protocol.ProtocolConstants;
import com.example.rpcprotocol.protocol.RpcProtocol;
import com.example.rpcprotocol.serialization.RpcSerialization;
import com.example.rpcprotocol.serialization.SerializationFactory;
import com.learn.rpc.core.RpcRequest;
import com.learn.rpc.core.RpcResponse;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author Yancy.wu
 * @date 2021/10/25
 */
public class RpcDecoder extends ByteToMessageDecoder {
    /*
    +---------------------------------------------------------------+
    | 魔数 2byte | 协议版本号 1byte | 序列化算法 1byte | 报文类型 1byte  |
    +---------------------------------------------------------------+
    | 状态 1byte |        消息 ID 8byte     |      数据长度 4byte     |
    +---------------------------------------------------------------+
    |                   数据内容 （长度不定）                          |
    +---------------------------------------------------------------+
    */
    @Override
    public final void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < ProtocolConstants.HEADER_TOTAL_LEN) {
            //可读的数据小于请求头总的大小  直接丢弃
            return;
        }
        // 标记 ByteBuf 读指针的位置
        in.markReaderIndex();

        //魔数
        short magic = in.readShort();
        if (magic != ProtocolConstants.MAGIC) {
            throw new IllegalArgumentException("magic number is illegal, " + magic);
        }

        //版本
        byte version = in.readByte();
        byte serializeType = in.readByte();
        byte msgType = in.readByte();
        byte status = in.readByte();
        long requestId = in.readLong();
        //CharSequence requestId = in.readCharSequence(ProtocolConstens.HEADER_TOTAL_LEN, StandardCharsets.UTF_8);

        int dataLength = in.readInt();
        if (in.readableBytes() < dataLength) {
            // 可读的数据长度 小于 请求体擦和高难度 直接丢弃 并重置 读指针位置
            in.resetReaderIndex();
            return;
        }
        byte[] data = new byte[dataLength];
        in.readBytes(data);

        MsgType msgTypeEnum = MsgType.findByType(msgType);
        if (msgTypeEnum == null) {
            return;
        }

        MsgHeader header = new MsgHeader();
        header.setMagic(magic);
        header.setVersion(version);
        header.setSerialization(serializeType);
        header.setStatus(status);
        header.setRequestId(requestId);
        header.setMsgType(msgType);
        header.setMsgLen(dataLength);

        RpcSerialization rpcSerialization = SerializationFactory.getRpcSerialization(serializeType);
        switch (msgTypeEnum) {
            case REQUEST:
                RpcRequest request = rpcSerialization.deserialize(data, RpcRequest.class);
                if (request != null) {
                    RpcProtocol<RpcRequest> protocol = new RpcProtocol<>();
                    protocol.setHeader(header);
                    protocol.setBody(request);
                    out.add(protocol);
                }
                break;
            case RESPONSE:
                RpcResponse response = rpcSerialization.deserialize(data, RpcResponse.class);
                if (response != null) {
                    RpcProtocol<RpcResponse> protocol = new RpcProtocol<>();
                    protocol.setHeader(header);
                    protocol.setBody(response);
                    out.add(protocol);
                }
                break;
            case HEARTBEAT:
                // TODO
                break;
        }

    }
}
