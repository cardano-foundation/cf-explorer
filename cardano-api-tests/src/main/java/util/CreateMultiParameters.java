package util;

import groovy.lang.Tuple2;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CreateMultiParameters {
    public MultiMap getParamsMap() {
        return paramsMap;
    }

    private MultiMap paramsMap;

    public CreateMultiParameters() {
        paramsMap = new MultiValueMap();
    }

    public CreateMultiParameters withKeyword(String keyword) {
        paramsMap.put("keyword", keyword);
        paramsMap.put("keyWord", keyword);
        return this;
    }

    public CreateMultiParameters withPage(String page) {
        paramsMap.put("page", page);
        return this;
    }

    public CreateMultiParameters withPage(Object page) {
        paramsMap.put("page", page);
        return this;
    }

    public CreateMultiParameters withNameEvent(Object nameEvent) {
        paramsMap.put("eventName", nameEvent);
        return this;
    }

    public CreateMultiParameters withNameAttribute(Object nameAttribute) {
        paramsMap.put("attributeName", nameAttribute);
        return this;
    }

    public CreateMultiParameters withPage(Integer page) {
        paramsMap.put("page", page);
        return this;
    }

    public CreateMultiParameters withPageSize(Object pageSize) {
        paramsMap.put("size", pageSize);
        return this;
    }
    public CreateMultiParameters withSort(ArrayList<String> sort){
        paramsMap.put("sort", sort.get(0));
        paramsMap.put("sort", sort.get(1));
        return this;
    }
    public CreateMultiParameters withSort(Object sort) {
        paramsMap.put("sort", sort);
        return this;
    }

    public CreateMultiParameters withStartCount(Integer startCount) {
        paramsMap.put("startCount", startCount);
        return this;
    }

    public CreateMultiParameters withEndCount(Integer endCount) {
        paramsMap.put("endCount", endCount);
        return this;
    }

    public CreateMultiParameters withTopicName(String topicName) {
        paramsMap.put("topicName", topicName);
        return this;
    }

    public CreateMultiParameters withPerPage(String perPage) {
        paramsMap.put("perPage", perPage);
        return this;
    }

    public CreateMultiParameters withSortDate(String sortDate) {
        paramsMap.put("sortDate", sortDate);
        return this;
    }

    public CreateMultiParameters withSortType(String sortType) {
        paramsMap.put("sortType", sortType);
        return this;
    }

    public CreateMultiParameters withSortBy(String sortBy) {
        paramsMap.put("sortBy", sortBy);
        return this;
    }

    public CreateMultiParameters withSortField(String sortField) {
        paramsMap.put("sortField", sortField);
        return this;
    }

    public CreateMultiParameters withOrderBy(String orderBy) {
        paramsMap.put("orderBy", orderBy);
        return this;
    }

    public CreateMultiParameters withDiscountType(String discountType) {
        paramsMap.put("discountType", discountType);
        return this;
    }

    public CreateMultiParameters withShiftId(String ShiftId) {
        paramsMap.put("shiftId", ShiftId);
        return this;
    }

    public CreateMultiParameters withDrawerSession(String drawerSessionId) {
        paramsMap.put("drawerSessionId", drawerSessionId);
        return this;
    }

    public CreateMultiParameters withTenantId(String tenantId) {
        paramsMap.put("tenantId", tenantId);
        return this;
    }

}
