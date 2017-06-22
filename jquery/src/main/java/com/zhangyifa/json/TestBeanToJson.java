package com.zhangyifa.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

/**
 * Created by zyf on 2017/6/22.
 */
public class TestBeanToJson {
    public static void main(String[] args) {

        test5();
    }

    public static void test1(){
        City city = new City(1,"广州");
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;
        try {
            jsonInString = mapper.writeValueAsString(city);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(jsonInString);
        //{"id":1,"name":"广州"}


        try {
            //设置输出好的阅读格式
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(city);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(jsonInString);
        /*
        {
          "id" : 1,
          "name" : "广州"
        }
        */
    }

    public static void test2() {
        List<City> cityList = new ArrayList<>();
        City city = new City(1,"广州");
        City city2 = new City(2,"深圳");
        cityList.add(city);
        cityList.add(city2);

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;

        try {
            //设置输出好的阅读格式
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cityList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(jsonInString);
        /*
            [
                 {
                  "id" : 1,
                  "name" : "广州"
                },
                {
                  "id" : 2,
                  "name" : "深圳"
                }
            ]

         */
    }

    public static void test3() {
        Set<City> citySet= new HashSet<>();
        City city = new City(1,"广州");
        City city2 = new City(2,"深圳");
        citySet.add(city);
        citySet.add(city2);

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;

        try {
            //设置输出好的阅读格式
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(citySet);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(jsonInString);
        /*
            [
                 {
                  "id" : 1,
                  "name" : "广州"
                },
                {
                  "id" : 2,
                  "name" : "深圳"
                }
            ]

         */
    }

    public static void test4() {
        List<City> cityList= new ArrayList<>();
        City city = new City(1,"广州");
        City city2 = new City(2,"深圳");
        cityList.add(city);
        cityList.add(city2);

        Province province = new Province(1,"广东",cityList);

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;

        try {
            //设置输出好的阅读格式
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(province);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(jsonInString);
        /*
            {
              "id" : 1,
              "name" : "广东",
              "cityList" : [
                  {
                    "id" : 1,
                    "name" : "广州"
                  },
                   {
                    "id" : 2,
                    "name" : "深圳"
                  }
              ]
            }

         */
    }


    public static void test5() {
        List<City> cityList = new ArrayList<City>();
        cityList.add(new City(1,"中山"));
        cityList.add(new City(2,"佛山"));

        Map<String,Object> map = new LinkedHashMap<String,Object>();
        map.put("total",cityList.size());//表示集合的长度
        map.put("rows",cityList);//rows表示集合

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;

        try {
            //设置输出好的阅读格式
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(jsonInString);
        /*
        {
          "total" : 2,
          "rows" : [
              {
                "id" : 1,
                "name" : "中山"
              },
               {
                "id" : 2,
                "name" : "佛山"
              }
           ]
        }

         */
    }

}
