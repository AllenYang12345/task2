package com.system.model;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Allen Yang
 * 2018/5/12 18:50
 */
public class User implements Serializable {

    private static final long serialVersionUID = -8696613205078899594L;
    private int id;
    private String name;
    private String qq;
    private String train_major;
    private Long admiss_time;
    private String graduate_school;
    private String online_number;
    private String daily_link;
    private String oath;
    private String coaching_senior;
    private String where_know;
    private Long create_at;
    private Long update_at;
    private List<User> user;

    private static String longToString(Long mysqlBigInt){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        /*  java.util.Date是毫秒单位 mysqlBigint是秒单位 */
        java.util.Date judt = new Date(mysqlBigInt * 1000);
        /*  返回格式化时间戳字符串 */
        return simpleDateFormat.format(judt);
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getTrain_major() {
        return train_major;
    }

    public void setTrain_major(String train_major) {
        this.train_major = train_major;
    }

    public Long getAdmiss_time() {
        return admiss_time;
    }

    public void setAdmiss_time(Long admiss_time) {
        this.admiss_time = admiss_time;
    }

    public String getGraduate_school() {
        return graduate_school;
    }

    public void setGraduate_school(String graduate_school) {
        this.graduate_school = graduate_school;
    }

    public String getOnline_number() {
        return online_number;
    }

    public void setOnline_number(String online_number) {
        this.online_number = online_number;
    }

    public String getDaily_link() {
        return daily_link;
    }

    public void setDaily_link(String daily_link) {
        this.daily_link = daily_link;
    }

    public String getOath() {
        return oath;
    }

    public void setOath(String oath) {
        this.oath = oath;
    }

    public String getCoaching_senior() {
        return coaching_senior;
    }

    public void setCoaching_senior(String coaching_senior) {
        this.coaching_senior = coaching_senior;
    }

    public String getWhere_know() {
        return where_know;
    }

    public void setWhere_know(String where_know) {
        this.where_know = where_know;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public Long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }

    public String toString(){
        return  "ID:"+id+"\n"+
                "姓名:"+name+"\n"+
                "qq:"+qq+"\n"+
                "修真类型:"+train_major+"\n"+
                "预计入学时间:"+admiss_time+"\n"+
                "毕业院校:"+graduate_school+"\n"+
                "线上学号:"+online_number+"\n"+
//                "日报链接:"+daily_link+"\n"+
                "立愿:"+oath+"\n"+
                "辅导师兄:"+coaching_senior+"\n"+
                "从何从了解到的修真院:"+where_know+"\n"+
                "创建时间:"+longToString(create_at)+"\n"+
                "更新时间:"+longToString(update_at)+"\n";
    }
}
