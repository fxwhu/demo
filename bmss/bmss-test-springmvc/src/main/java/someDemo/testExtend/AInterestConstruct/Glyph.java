package someDemo.testExtend.AInterestConstruct;

import someDemo.testExtend.A;

/**
 * Created by fengxuan1 on 2016/11/20.
 */
public class Glyph {

    public Glyph() {
        System.out.println("Clypth something");
        draw();
    }

    void draw(){
        System.out.println("Clyph begin.");
    }

    A getA(){
        return new A();
    }

}
