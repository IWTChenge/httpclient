package com.changshi.httpclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class TestJackson {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    public static void test1() {
        //创建ObjMapper
        ObjectMapper objectMapper=new ObjectMapper();
        //Json—》bean
        String json="{\"student_id\":\"1\",\"name\":\"小明\",\"phone\":\"13821378270\",\"email\":\"xiaoming@mybatis.cn\",\"locked\":\"0\",\"gmt_created\":\"2019-07-02 15:39:43\",\"gmt_modified\":\"2019-07-02 15:39:43\"}";
        Student student = null;
        try {
            student = objectMapper.readValue(json, Student.class);
            System.out.println(student);
            String s = objectMapper.writeValueAsString(student);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    public static void test2() {
        //创建ObjMapper
        ObjectMapper objectMapper=new ObjectMapper();
        //Json—》bean
        String json="{\"resualt\":[{\"student_id\":\"1\",\"name\":\"小明\",\"phone\":\"13821378270\",\"email\":\"xiaoming@mybatis.cn\",\"locked\":\"0\",\"gmt_created\":\"2019-07-02 15:39:43\",\"gmt_modified\":\"2019-07-02 15:39:43\"},{\"student_id\":\"2\",\"name\":\"小丽\",\"phone\":\"13821378271\",\"email\":\"xiaoli@mybatis.cn\",\"locked\":\"0\",\"gmt_created\":\"2019-07-02 15:39:43\",\"gmt_modified\":\"2019-07-02 15:39:43\"},{\"student_id\":\"3\",\"name\":\"小刚\",\"phone\":\"13821378272\",\"email\":\"xiaogang@mybatis.cn\",\"locked\":\"0\",\"gmt_created\":\"2019-07-02 15:39:43\",\"gmt_modified\":\"2019-07-02 15:39:43\"},{\"student_id\":\"4\",\"name\":\"小花\",\"phone\":\"13821378273\",\"email\":\"xiaohua@mybatis.cn\",\"locked\":\"0\",\"gmt_created\":\"2019-07-02 15:39:43\",\"gmt_modified\":\"2019-07-02 15:39:43\"},{\"student_id\":\"5\",\"name\":\"小强\",\"phone\":\"13821378274\",\"email\":\"xiaoqiang@mybatis.cn\",\"locked\":\"0\",\"gmt_created\":\"2019-07-02 15:39:43\",\"gmt_modified\":\"2019-07-02 15:39:43\"},{\"student_id\":\"6\",\"name\":\"小红\",\"phone\":\"13821378275\",\"email\":\"xiaohong@mybatis.cn\",\"locked\":\"0\",\"gmt_created\":\"2019-07-02 15:39:43\",\"gmt_modified\":\"2019-07-02 15:39:43\"},{\"student_id\":\"9\",\"name\":\"s1\",\"phone\":null,\"email\":\"test\",\"locked\":null,\"gmt_created\":\"2019-08-28 00:20:20\",\"gmt_modified\":\"2019-08-28 00:20:20\"},{\"student_id\":\"10\",\"name\":\"s2\",\"phone\":null,\"email\":\"test\",\"locked\":null,\"gmt_created\":\"2019-08-28 00:20:20\",\"gmt_modified\":\"2019-08-28 00:20:20\"}]}";
        try {
//            Student student =objectMapper.readValue(json,Student.class);
//            System.out.println(student);
            JsonNode jsonNode = objectMapper.readTree(json);
            JsonNode result=jsonNode.findPath("resualt");
            System.out.println(result);

            JavaType javaType =objectMapper.getTypeFactory().constructParametricType(ArrayList.class,Student.class);
            //List<Student> ls=objectMapper.readValue( result.toString(),javaType);

            List<Student> ls=objectMapper.readValue(result.toString(), new TypeReference<List<Student>>() {
            });
            for (Student s:ls
            ) {
                System.out.println(s);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

   static class Student {
        private String student_id;
        private String name;
        private String phone;
        private String email;
        private String locked;
        private String gmt_created;
        private String gmt_modified;


        public String getStudent_id() {
            return student_id;
        }

        public void setStudent_id(String student_id) {
            this.student_id = student_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getLocked() {
            return locked;
        }

        public void setLocked(String locked) {
            this.locked = locked;
        }

        public String getGmt_created() {
            return gmt_created;
        }

        public void setGmt_created(String gmt_created) {
            this.gmt_created = gmt_created;
        }

        public String getGmt_modified() {
            return gmt_modified;
        }

        public void setGmt_modified(String gmt_modified) {
            this.gmt_modified = gmt_modified;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "student_id='" + student_id + '\'' +
                    ", name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    ", email='" + email + '\'' +
                    ", locked='" + locked + '\'' +
                    ", gmt_created='" + gmt_created + '\'' +
                    ", gmt_modified='" + gmt_modified + '\'' +
                    '}';
        }
    }
}

