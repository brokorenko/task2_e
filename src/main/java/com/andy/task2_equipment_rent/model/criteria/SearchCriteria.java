package com.andy.task2_equipment_rent.model.criteria;

import java.util.Map;

public class SearchCriteria {

    private Map<Criteria, Object> criteria;
    private String category;

    public SearchCriteria(Map<Criteria, Object> criteria, String category) {
        this.criteria = criteria;
        this.category = category;
    }

    public Map<Criteria, Object> getCriteria() {
        return criteria;
    }

    public void setCriteria(Map<Criteria, Object> criteria) {
        this.criteria = criteria;
    }

    public Object getOneCriteria(Criteria c){
        return criteria.get(c);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
