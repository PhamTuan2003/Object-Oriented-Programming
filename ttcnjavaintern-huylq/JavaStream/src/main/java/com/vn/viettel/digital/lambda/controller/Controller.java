package com.vn.viettel.digital.lambda.controller;

import com.vn.viettel.digital.lambda.criteria.SearchCriteria;
import com.vn.viettel.digital.lambda.model.Girl;
import com.vn.viettel.digital.lambda.service.SearchService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.Month.*;

public class Controller {
    private static List<Girl> girls;

    static {
        girls = new ArrayList<>();
        girls.add(new Girl("Loan", LocalDate.of(1998, OCTOBER, 2), 1.65F, 52.5F));
        girls.add(new Girl("Hien", LocalDate.of(2002, JANUARY, 15), 1.52F, 45F));
        girls.add(new Girl("Linh", LocalDate.of(2005, MARCH, 24), 1.72F, 58F));
        girls.add(new Girl("Mai", LocalDate.of(1999, DECEMBER, 7), 1.48F, 55F));
    }

    public static void main(String[] args) {
        List<Girl> girlsByAge = SearchService.matchGirlsByAge(girls, 18, 22);
        System.out.println("Search girls by age:");
        girlsByAge.forEach(System.out::println);

        // Using anonymous class
        List<Girl> matchedGirls = SearchService.matchGirlsByCriteria(girls, new SearchCriteria(){
            @Override
            public boolean test(Girl girl) {
                return girl.getAge() >= 18;
            }
        });
        System.out.print("\n==========\n");
        System.out.println("Search girls by age and height:");
        matchedGirls.forEach(System.out::println);

    }
}
