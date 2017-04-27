package someDemo.typeinof.pets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengxuan1 on 2016/11/24.
 */
public class ForNameCreator extends  PetCreator {

    private static List<Class<? extends Pet>> types = new ArrayList<>();

    private static String[] typeNames = {"typeinof.pets.Dog", "typeinof.pets.Cat", "typeinof.pets.Mouse"};

    private static void loader(){
        for(String name : typeNames){
            try {
                types.add((Class < ?extends Pet>)Class.forName(name));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
