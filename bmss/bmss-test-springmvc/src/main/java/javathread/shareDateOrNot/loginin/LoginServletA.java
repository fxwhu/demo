package javathread.shareDateOrNot.loginin;

/**
 * Created by fengxuan1 on 2016/12/21.
 */
public class LoginServletA {

    private static String nameRef;

    private static String passwordRef;

    synchronized public static void doPost(String name, String password){
        try {
            nameRef = name;
            if(name.equals("a")){
                Thread.sleep(500);
            }
            passwordRef = password;
            System.out.println("name: " + nameRef + " password: " + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
