package com.bb.tuning.decorator;

/**
 * @ClassName PacketDecorator
 * @Description: 核心组件
 * @Author zzy
 * @Date 2020/11/3
 **/
public abstract class PacketDecorator implements IPacketCreator {
    IPacketCreator component;

    public PacketDecorator(IPacketCreator c) {
        component = c;
    }

}
