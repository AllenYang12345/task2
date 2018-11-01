import com.system.model.User;
import com.system.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.logging.Logger;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Allen Yang
 * 2018/5/12 18:50
 */
/*让测试在Spring容器环境下执行*/
/*@RunWith：用于指定junit运行环境，是junit提供给其他框架测试环境接口扩展，
为了便于使用spring的依赖注入，
spring提供了org.springframework.test.context.junit4.SpringJUnit4ClassRunner作为Junit测试环境*/
@RunWith(SpringJUnit4ClassRunner.class)
/*从类路径下加载applicationContext.xml*/
@ContextConfiguration({"classpath:/spring-mybatis.xml"})

public class UserController {
    @Autowired
    private UserService UserService;

    private static Logger log =Logger.getLogger(UserController.class.getName());

    public static String longToString(Long mysqlBigInt){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        /*  java.util.Date是毫秒单位 mysqlBigint是秒单位 */
        java.util.Date judt = new Date(mysqlBigInt * 1000);
        /*  返回格式化时间戳字符串 */
        return simpleDateFormat.format(judt);
    }
    /*  date转换为long */
    public static Long dateTolong(java.util.Date judt){
        /*  date.getTime()所返回的是一个long型的毫秒数,除以1000得到秒  */
        return judt.getTime()/1000;
    }

    @Test
    public void insert(){
        try {
            long startTime1 = System.currentTimeMillis();
            User user = new User();
            for (int i = 1; i <= 1; i++) {
                user.setName("赖美云");
                user.setQq("123432123");
                user.setTrain_major("Java");
                user.setAdmiss_time((long) 20180321);
                user.setGraduate_school("中国戏剧学院");
                user.setOnline_number("2131");
                user.setDaily_link("http://www.jnshu.com/daily/53594?dailyType=others&total=7&page=1&uid=19204&sort=0&orderBy=9");
                user.setOath("你的努力和小心机，从一到三以来逐步让走进大众的视野");
                user.setCoaching_senior("大爹");
                user.setWhere_know("知乎");
                user.setCreate_at(dateTolong(new java.util.Date()));
                user.setUpdate_at(dateTolong(new java.util.Date()));
                UserService.insert(user);
                Integer id = user.getId();
                log.info("成功添加ID=" + id + "的记录");
            }
            long endTime=System.currentTimeMillis();
            log.info("增加一条记录所需的时间："+(endTime-startTime1)+"ms");
//            System.out.println("执行增加5050条记录所需的时间"+(endTime-startTime1)+"ms");
        }catch(Exception e){
            e.printStackTrace();
            log.info("插入数据失败！");
        }
    }

    @Test//测试事务
    public void inserttwo(){
        try {
            User user = new User();
            user.setName("高顺");
            user.setQq("123432123");
            user.setTrain_major("Java");
            user.setAdmiss_time((long) 20180321);
            user.setGraduate_school("中国戏剧学院");
            user.setOnline_number("2131");
            user.setDaily_link("http://www.jnshu.com/daily/53594?dailyType=others&total=7&page=1&uid=19204&sort=0&orderBy=9");
            user.setOath("你的努力和小心机，从一到三以来逐步让走进大众的视野");
            user.setCoaching_senior("大爹");
            user.setWhere_know("知乎");
            user.setCreate_at(dateTolong(new java.util.Date()));
            user.setUpdate_at(dateTolong(new java.util.Date()));
            UserService.insert(user);

            User user1 = new User();
            user1.setName("赖美云");
            user1.setQq("123432123");
            user1.setTrain_major("Java");
            user1.setAdmiss_time((long) 20180321);
            user1.setGraduate_school("中国戏剧学院");
            user1.setOnline_number("2131");
            user1.setDaily_link("http://www.jnshu.com/daily/53594?dailyType=others&total=7&page=1&uid=19204&sort=0&orderBy=9");
            user1.setOath("你的努力和小心机，从一到三以来逐步让走进大众的视野");
            user1.setCoaching_senior("大爹");
            user1.setWhere_know("知乎");
            user1.setCreate_at(dateTolong(new java.util.Date()));
            user1.setUpdate_at(dateTolong(new java.util.Date()));
            UserService.insert(user1);
            System.out.println();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void insertList(){
        long start=System.currentTimeMillis();
        List<User> userList =new ArrayList<>();
        for(int i = 1 ; i <= 1000000 ; i++) {
            User user = new User();
            user.setName("赖美云");
            user.setQq("123432123");
            user.setTrain_major("Java");
            user.setAdmiss_time((long) 20180321);
            user.setGraduate_school("中国戏剧学院");
            user.setOnline_number("2131");
            user.setDaily_link("http://www.jnshu.com/daily/53594?dailyType=others&total=7&page=1&uid=19204&sort=0&orderBy=9");
            user.setOath("你的努力和小心机，从一到三以来逐步让走进大众的视野");
            user.setCoaching_senior("大爹");
            user.setWhere_know("知乎");
            user.setCreate_at(dateTolong(new java.util.Date()));
            user.setUpdate_at(dateTolong(new java.util.Date()));
            userList.add(user);
            if(i % 10 == 0 && i != 1000000){
                UserService.insertBatch(userList);
                userList.clear();
            }
        }
        long end = System.currentTimeMillis();
        log.info("插入1000000条数据所需时间："+(end-start)+"ms");
    }

    @Test
    public void readonebyId(){
        long start = System.currentTimeMillis();
        int id = 1;
        User result = UserService.getUserByID(id);
        System.out.println(result);
        long end=System.currentTimeMillis();
        log.info("消耗时间："+(end-start)+"ms");
    }

    @Test
    public void readonebyName(){
        long start = System.currentTimeMillis();
        String name = "赖美云";
        List<User> result = UserService.getUserByName(name);
        System.out.println(result);
        long end=System.currentTimeMillis();
        log.info("消耗时间："+(end-start)+"ms");
    }

    @Test
    public void readByOnlineNumber(){

        long start = System.currentTimeMillis();
        String online_number = "2131";
        List<User> result = UserService.getUserByOnlineNumber(online_number);
        System.out.println(result);
        long end=System.currentTimeMillis();
        log.info("消耗时间："+(end-start)+"ms");
    }


    @Test
    public void change(){
        long start = System.currentTimeMillis();
        User user=new User();
        user.setId(12);
        user.setName("小六");
        user.setQq("123432123");
        user.setTrain_major("Java");
        user.setAdmiss_time((long)20180321);
        user.setGraduate_school("中国戏剧学院");
        user.setOnline_number("2131");
        user.setDaily_link("http://www.jnshu.com/daily/53594?dailyType=others&total=7&page=1&uid=19204&sort=0&orderBy=9");
        user.setOath("你的努力和小心机，从一到三以来逐步让走进大众的视野");
        user.setCoaching_senior("大爹");
        user.setWhere_know("知乎");
        user.setCreate_at(dateTolong(new java.util.Date()));
        user.setUpdate_at(dateTolong(new java.util.Date()));
        int result = UserService.updateUser(user);
        if (result == 1){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
        long end=System.currentTimeMillis();
        log.info("消耗时间："+(end-start)+"ms");
    }

    @Test
    public void delete(){
        long start = System.currentTimeMillis();
        User user = new User();
        user.setId(13);
        int result = UserService.deleteUser(user);
        if (result == 1){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
        long end=System.currentTimeMillis();
        log.info("消耗时间："+(end-start)+"ms");
    }
}
