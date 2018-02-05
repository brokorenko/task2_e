package com.andy.task2_equipment_rent.dao.util;

import com.andy.task2_equipment_rent.model.SportEquipment;
import com.andy.task2_equipment_rent.model.criteria.Criteria;
import com.andy.task2_equipment_rent.model.criteria.SearchCriteria;

import java.util.Map;

public class CriteriaAndGoodsComparator {
    private static final CriteriaAndGoodsComparator criteriaAndGoodsComparator = new CriteriaAndGoodsComparator();
    private CriteriaAndGoodsComparator() {
    }
    public static CriteriaAndGoodsComparator getInstance(){
        return criteriaAndGoodsComparator;
    }
    public boolean compareCriteriaWithShopGoods(SearchCriteria criteria, Map.Entry<SportEquipment, Integer> shopGoodsEntry){

                if (!shopGoodsEntry.getKey().getCategory().toString().equals(criteria.getCategory())){
                    return false;
                }

                if (criteria.getOneCriteria(Criteria.PRICE) != null){
                    if ((Integer)criteria.getOneCriteria(Criteria.PRICE )!= shopGoodsEntry.getKey().getPrice()){
                        return false;
                    }
                }
                if (criteria.getOneCriteria(Criteria.TITLE) != null){
                    if (shopGoodsEntry.getKey().getTitle().equals(criteria.getOneCriteria(Criteria.TITLE))){
                        return false;
                    }
                }
                return true;
    }
}

