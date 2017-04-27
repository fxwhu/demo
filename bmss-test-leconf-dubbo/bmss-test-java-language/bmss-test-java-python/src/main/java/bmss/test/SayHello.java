package bmss.test;

/**
 * Created by fengxuan1 on 2017/3/23.
 */
public class SayHello {
    private String userName;

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void say(int i) {
        System.out.println(i + ":Hello " + userName);
    }
}
