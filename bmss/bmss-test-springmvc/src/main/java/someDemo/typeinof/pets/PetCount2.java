package someDemo.typeinof.pets;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by fengxuan1 on 2016/11/24.
 */
public class PetCount2 {
    static class PetConuter extends LinkedHashMap<Class<? extends Pet>, Integer>{
        public void init(){
            for(Class<? extends Pet> item: LiteralPetCreator.allTypes){
                put(item, 0);
            }
        }
        public PetConuter(){
            init();
        }
        public void count(Pet pet){
            for(Map.Entry<Class<? extends Pet>, Integer> pair: entrySet()){
                if(pair.getKey().isInstance(pet)){
                    put(pair.getKey(), pair.getValue() + 1);
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder("{");
            for(Map.Entry<Class<? extends Pet>, Integer> item : entrySet()){
                result.append(item.getKey().getSimpleName());
                result.append("=");
                result.append(item.getValue());
                result.append(", ");
            }
            result.delete(result.length() - 2, result.length());
            result.append("}");
            return result.toString();
        }
    }

    public static void main(String[] args) {
        PetConuter petConuter = new PetConuter();
        for(Pet pet: Pets.arrayList(10)){
            petConuter.count(pet);
        }
        System.out.println(petConuter);
    }

}
