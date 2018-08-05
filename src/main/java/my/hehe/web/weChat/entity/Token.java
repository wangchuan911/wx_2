package my.hehe.web.weChat.entity;

import java.util.Calendar;

public class Token {
    private String access_token;
    private int expires_in;
    private Calendar expires_date;

    public String getAccess_token() {
        return access_token;
    }

    public void setToken(Token tk){
        if(tk==null)return;
        setAccess_token(tk.access_token);
        setExpires_in(expires_in);
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
        expires_date =Calendar.getInstance();
        expires_date.add(Calendar.SECOND, expires_in);
    }
    public Calendar getExpires_date() {
        return expires_date;
    }

    @Override
    public String toString() {
        StringBuffer sb=new StringBuffer("{\"access_token\":\"").append(access_token).append("\",\"expires_in\":\"").append(expires_in).append("\"}");
        return sb.toString();
    }
}
