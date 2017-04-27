package someDemo.typeinof.pets;

import java.util.ArrayList;

/**
 * Created by fengxuan1 on 2016/11/24.
 */
public class Pets {
    public static final PetCreator CREATOR = new LiteralPetCreator();
    public static ArrayList<Pet> arrayList(int size){
        return CREATOR.arrayList(size);
    }
}
