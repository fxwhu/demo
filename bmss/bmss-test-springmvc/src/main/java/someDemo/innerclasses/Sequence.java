package someDemo.innerclasses;

/**
 * Created by fengxuan1 on 2016/11/20.
 */
public class Sequence {

    private Object[] objects;


    private int next = 0;

    public Sequence(int size) {
        objects = new Object[size];
    }

    public void add(Object item){
        if(next < objects.length){
            objects[next++] = item;
        }
    }

    class Selector{
        int i;
        public Sequence sequence(){
            return Sequence.this;
        }

        public Object current(){
            return objects[i - 1];
        }

        public boolean hasNext(){
            if(i < objects.length){
                i++;
                return true;
            }return false;
        }
    }

    public Selector selector(){
        return new Selector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(i);
        }
        Selector selector = sequence.selector();
        while (selector.hasNext()){
            System.out.println(selector.current());
        }
    }
}
