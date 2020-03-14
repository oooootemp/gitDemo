package com.example.ddd.demo.demo;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class Dmeo {
    @RequestMapping("demo")
    public String demo(){
        return "SS";
    }



    @RequestMapping("jvm_gc")
    public String jvm_gc(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int k =0; k < 10; k++){
            executorService.execute(()-> {
                List<A01> list_a01 = new ArrayList();
                for(int i=0;i<1000000;i++){
                    A01 a01 = new A01();
                    a01.setA0000("1111"+"_"+i);
                    a01.setA0101("name"+"_"+i);
                    a01.setA0111("age"+"_"+i);
                    list_a01.add(a01);
                }


                List<B01> list_b02 = new ArrayList();
                for(int i=0;i<1000020;i++){
                    B01 b01 = new B01();
                    b01.setB01Ip("b01Ip"+"_"+i);
                    b01.setB0101("b0101"+"_"+i);
                    b01.setB0111("b0111"+"_"+i);
                    list_b02.add(b01);
                }


                List<A01> list_a01_1 = new ArrayList();
                for(int i=0;i<1000010;i++){
                    A01 a01_1 = new A01();
                    a01_1.setA0000("1111"+"_"+i);
                    a01_1.setA0101("name"+"_"+i);
                    a01_1.setA0111("age"+"_"+i);
                    list_a01_1.add(a01_1);
                }

                List<B01> list_b02_1 = new ArrayList();
                for(int i=0;i<1020000;i++){
                    B01 b01_1 = new B01();
                    b01_1.setB01Ip("b01Ip"+"_"+i);
                    b01_1.setB0101("b0101"+"_"+i);
                    b01_1.setB0111("b0111"+"_"+i);
                    list_b02_1.add(b01_1);
                }
            });

        }


        System.out.println("保存数据库！！！！！！！！！！！！！！！！！！！！");
        return "jvm-error";
    }



    @RequestMapping("jvm_error")
    public String jvm_error(){
        List<Map> list = new ArrayList<>();
        for(;;){
            Map<String,String> map = new HashMap<>();
            map.put(UUID.randomUUID().toString(),UUID.randomUUID().toString());
            list.add(map);
        }
       // return "gc";
    }


    @RequestMapping("jvm_add")
    public String jvm_add(){
        for(int i=0;i<10000;i++){
            Map<String,String> map = new HashMap<>();
            map.put(UUID.randomUUID().toString(),UUID.randomUUID().toString());
        }
        return "demo";
    }

    public static void main(String[] args) {
//        Map<String,String> map = new LinkedHashMap<>();
//        map.put("1","1");
//        map.put("2","2");
//        map.put("3","3");
//        map.put("4","4");
//
//        Set<Map.Entry<String, String>> set = map.entrySet();
//        for(Map.Entry<String, String> m:set){
//
//            System.out.println("key:"+m.getKey()+"----"+"value:"+m.getValue());
//        }


    }
    public static <T> List<List<T>> averageAssign(List<T> source,int n){
        List<List<T>> result=new ArrayList<List<T>>();
        int remaider=source.size()%n;  //(先计算出余数)
        int number=source.size()/n;  //然后是商
        int offset=0;//偏移量
        for(int i=0;i<n;i++){
            List<T> value=null;
            if(remaider>0){
                value=source.subList(i*number+offset, (i+1)*number+offset+1);
                remaider--;
                offset++;
            }else{
                value=source.subList(i*number+offset, (i+1)*number+offset);
            }
            result.add(value);
        }
        return result;
    }
}
