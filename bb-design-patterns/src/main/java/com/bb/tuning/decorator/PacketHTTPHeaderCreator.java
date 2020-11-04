package com.bb.tuning.decorator;

/**
 * @ClassName PacketHTTPHeaderCreator
 * @Description: TODO
 * @Author zzy
 * @Date 2020/11/3
 **/
public class PacketHTTPHeaderCreator extends PacketDecorator {

    public PacketHTTPHeaderCreator(IPacketCreator c) {
        super(c);
    }

    /**
     * 对给定数据加上HTTP头信息
     *
     * @return
     */
    @Override
    public String handleContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cache-Control:no-cache\n");
        sb.append("Date:Mon,31Dec202017:40:40GMT\n");
        sb.append(component.handleContent());
        return sb.toString();
    }
}
