package com.vn.viettel.digital.lambda.service;

import com.vn.viettel.digital.lambda.criteria.SearchCriteria;
import com.vn.viettel.digital.lambda.model.Girl;

import java.util.ArrayList;
import java.util.List;

public class SearchService {

    // Need different search methods (Search by size and hobbies,...)? Change Girl attributes (work, school...)?
    public static List<Girl> matchGirlsByAge (List<Girl> girls, int startAge, int endAge) {
        List<Girl> girlsByAge = new ArrayList<>(girls.size());
        for (Girl girl : girls) {
            if (startAge <= girl.getAge() && girl.getAge() <= endAge) {
                girlsByAge.add(girl);
            }
        }
        return girlsByAge;
    }

    public static List<Girl> matchGirlsByCriteria(List<Girl> girls, SearchCriteria criteria) {
        List<Girl> matchedGirls = new ArrayList<>(girls.size());
        for (Girl e : girls) {
            if(criteria.test(e)) {
                matchedGirls.add(e);
            }
        }
        return matchedGirls;
    }
}
