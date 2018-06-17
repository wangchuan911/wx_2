package my.hehe.web.weChat.entity.msg.request;


public interface LocationMsg extends Msg{

    public String getLocation_X();

    public String getLocation_Y();

    public String getScale();

    public String getLabel();

    public void setLocation_X(String location_X);

    public void setLocation_Y(String location_Y);

    public void setScale(String scale);

    public void setLabel(String label);


}
