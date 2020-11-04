package com.bb.tuning.decorator;

/**
 * @ClassName PacketBodyCreatir
 * @Description: 具体组件
 * @Author zzy
 * @Date 2020/11/3
 **/
public class PacketBodyCreator implements IPacketCreator {

    @Override
    public String handleContent() {
        //构造核心数据，但不包括格式
        return "Content of Packet";
    }
}
