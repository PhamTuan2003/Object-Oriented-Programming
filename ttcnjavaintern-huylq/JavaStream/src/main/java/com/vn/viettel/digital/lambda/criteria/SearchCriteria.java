package com.vn.viettel.digital.lambda.criteria;

import com.vn.viettel.digital.lambda.model.Girl;

public interface SearchCriteria {
    boolean test(Girl girl);
}
