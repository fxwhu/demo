package someDemo.typeinof.pets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by fengxuan1 on 2016/11/24.
 */
public class LiteralPetCreator extends PetCreator {

    public static final List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(Arrays.asList(Mouse.class,
            Dog.class, Cat.class));

    @Override
    public List<Class<? extends Pet>> types() {
        return allTypes;
    }
}
