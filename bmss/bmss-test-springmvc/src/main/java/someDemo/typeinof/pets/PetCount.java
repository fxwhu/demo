package someDemo.typeinof.pets;

import java.util.HashMap;

/**
 * Created by fengxuan1 on 2016/11/24.
 */
public class PetCount {
    static class PetCounter extends HashMap<String, Integer>{
        void count(String type){
          Integer quanlity = get(type);
          if(quanlity == null)
              put(type, 1);
            else
              put(type, quanlity + 1);
        }
    }

    public static void countPets(PetCreator petCreator){
        PetCounter petCounter = new PetCounter();
        for(Pet pet: petCreator.createArray(10)){
            System.out.println(pet.getClass().getSimpleName());
            if(pet instanceof Pet){
                petCounter.count("pet");
            }
            if(pet instanceof Cat){
                petCounter.count("cat");
            }
            if(pet instanceof Dog){
                petCounter.count("dog");
            }
            if(pet instanceof Mouse){
                petCounter.count("mouse");
            }
        }
        System.out.println("======" + petCounter);
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator());
//        countPets(new LiteralPetCreator());
    }
}
