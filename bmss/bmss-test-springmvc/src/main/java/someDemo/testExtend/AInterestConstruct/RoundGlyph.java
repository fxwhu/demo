package someDemo.testExtend.AInterestConstruct;

import someDemo.testExtend.A;
import someDemo.testExtend.B;

/**
 * Created by fengxuan1 on 2016/11/20.
 */
public class RoundGlyph extends Glyph{
    private int radius;

    public RoundGlyph(int radius) {
        this.radius = radius;
        System.out.println("RoundGlyph begin.");
        System.out.println("RoundGlyph111 someting: " + radius);
    }

    @Override
    void draw() {
        System.out.println("RoundGlyph someting: " + radius);
    }

    @Override
    B getA() {
        return new B();
    }

    public static void main(String[] args) {
        Glyph test = new RoundGlyph(5);
        A a = test.getA();
    }
}
