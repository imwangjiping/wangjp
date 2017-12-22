package com.jwong.java8.Lambda;

/**
 * Created by jwong on 2017/10/26.
 */
public class FilterEmployeeByAge implements MyPredicate<LambdaTest.Employee> {

    @Override
    public boolean test(LambdaTest.Employee employee) {
        return employee.getAge() >= 35;
    }
}
