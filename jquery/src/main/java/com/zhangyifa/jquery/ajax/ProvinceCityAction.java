package com.zhangyifa.jquery.ajax;

import com.opensymphony.xwork2.ActionSupport;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by zhangyifa on 6/24/17.
 */

public class ProvinceCityAction extends ActionSupport {

   private String province;

    private Set<String> setCity;

    public void setProvince(String province) {
        this.province = province;
    }

    public void setSetCity(Set<String> setCity) {
        this.setCity = setCity;
    }

    public String getProvince() {
        return province;
    }

    public Set<String> getSetCity() {
        return setCity;
    }

    public String findCity() throws Exception {
        System.out.println("findCity");
        setCity = new LinkedHashSet<String>();
        if("湖南".equals(province)){
            setCity.add("长沙");
            setCity.add("株洲");
        }else if("广东".equals(province)){
            setCity.add("广州");
            setCity.add("中山");
            setCity.add("佛山");
        }
        return SUCCESS;
    }
}
