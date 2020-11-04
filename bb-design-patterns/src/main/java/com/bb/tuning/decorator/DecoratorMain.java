package com.bb.tuning.decorator;

/**
 * @ClassName DecoratorMain
 * @Description: TODO
 * @Author zzy
 * @Date 2020/11/3
 **/
public class DecoratorMain {
    public static void main(String[] args) {
        //1.作为核心组件的PacketBodyCreator最先被构造，
        //2.PacketHTMLHeaderCreator
        //3.PacketHTTPHeaderCreator
        IPacketCreator pc = new PacketHTTPHeaderCreator(new PacketHTMLHeaderCreator(new PacketBodyCreator()));
        System.out.println(pc.handleContent());
    }
}
