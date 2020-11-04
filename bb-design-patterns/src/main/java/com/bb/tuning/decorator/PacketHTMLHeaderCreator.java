package com.bb.tuning.decorator;

/**
 * @ClassName PacketHTMLHeaderCreator
 * @Description: HTML具体装饰器
 * @Author zzy
 * @Date 2020/11/3
 **/
public class PacketHTMLHeaderCreator extends PacketDecorator {

    public PacketHTMLHeaderCreator(IPacketCreator c) {
        super(c);
    }

    /**
     * 将制定的数据封装成HTML
     *
     * @return
     */
    @Override
    public String handleContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<body>");
        sb.append(component.handleContent());
        sb.append("</body>");
        sb.append("</html>\n");
        return sb.toString();
    }
}
