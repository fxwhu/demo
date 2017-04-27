package com.bmss.test.validator.normal;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by fengxuan1 on 2017/3/28.
 */
public class CarTest {

    Validator validator;

    @Before
    public void init(){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    public void testNormal(){
        Car car = new Car("fute", "1234", 10);
        Person person = new Person();
        person.setName("fx");
        person.setEmail("1650209180@qq.com");
        person.setCardNumber("111");
        car.setPerson(person);
        Set<ConstraintViolation<Car>> validates = validator.validate(car);
        for (ConstraintViolation<Car> validate : validates) {
            System.out.println(validate.getPropertyPath() + ": " + validate.getMessage());
        }

    }

}