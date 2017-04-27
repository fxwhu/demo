package someDemo.enumTest;

/**
 * Created by fengxuan1 on 2016/12/6.
 */
public class TrafficLight {
    Signal color = Signal.RED;
    public void change(){
        switch (color){
            case RED:
                color = Signal.RED;
                break;
            case YELLOW:
                color = Signal.YELLOW;
                break;
            case GREEN:
                color = Signal.GREEN;
                break;
        }
    }

    @Override
    public String toString() {
        return "TrafficLight{" +
                "color=" + color +
                '}';
    }

    public static void main(String[] args) {
        String s = "{\"name\": \"hello\", \"age\": 10}";
        TrafficLight trafficLight = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(trafficLight);
            trafficLight.change();

        }
    }
}
