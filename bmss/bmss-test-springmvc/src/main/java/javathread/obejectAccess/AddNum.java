package javathread.obejectAccess;

/**
 * Created by fengxuan1 on 2016/12/26.
 */
public class AddNum {

    private int num;

    synchronized public void add(String name){
        try {
            if(name.equals("a")){
                num = 100;
                System.out.println("a over!");
                Thread.sleep(1000);
            }else {
                num = 200;
                System.out.println("b over!");
            }
            System.out.println(name + ": " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
