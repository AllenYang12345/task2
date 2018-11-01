package com.system.controller;

import com.system.model.LoginCommand;
import com.system.model.User;
import com.system.service.UserService;
import com.system.util.Page;
import com.system.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author AllenYang
 * @date 18-9-9 下午11:55
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    private MessageSource messageSource = new ClassPathXmlApplicationContext("app-context.xml");
    @RequestMapping("/")
    public String Loginin(){

        return "login";
    }

    @RequestMapping(value = "/login")
    public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand){
//        Object[] arg = new Object[]{"欢迎你", Calendar.getInstance().getTime()};
        if (loginCommand.getUserName()!=null||loginCommand.getPassword()!=null) {//如果账号密码不为空
            ResourceBundle bundle = ResourceBundle.getBundle("error",new Locale("zh","CN"));
//            String cancel1 = bundle.getString("0");
//            System.out.println(cancel1);
//            System.out.println("输出了：" +
//                    ResultCode.getValueByKey(
//                            "testInfo_zh_CN.properties",
//                            "test"));
            boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(),
                    loginCommand.getPassword());
            if (!isValidUser) {//如果数据库密码不符
                String cancel2 = bundle.getString("10000");
                System.out.println(cancel2);
                return new ModelAndView("login", "error", "用户名或密码错误！");
            } else {
//                String msg = messageSource.getMessage("userinfo",arg,Locale.US);
//                System.out.println(msg);
                String cancel3 = bundle.getString("0");//操作成功
                System.out.println(cancel3);
                return new ModelAndView("redirect:/user/main");
            }
        }else {
            return new ModelAndView("regUser");
        }
    }

    @RequestMapping(value = "/addonelogin")
    public ModelAndView addlogin(HttpServletRequest request, LoginCommand loginCommand){

        if (((!loginCommand.getUserName().equals(""))&&(!loginCommand.getPassword().equals("")))){
            boolean isAvailable = userService.getMatchavailable(loginCommand.getUserName());
            if (!isAvailable){
                loginCommand.setUserName(loginCommand.getUserName());
                loginCommand.setPassword(loginCommand.getPassword());
                userService.addNewlogin(loginCommand);
                return new ModelAndView("login","error","注册成功！");
            }else {
                return new ModelAndView("regUser","error","账号已存在！");
            }
        }else {
            return new ModelAndView("regUser", "error", "我虽然是电脑，别侮辱我的智商，你没输入账号/密码吧？");
        }
    }

    //分页
    @RequestMapping(value = "/main")
    public String queryPages(HttpServletRequest request, Model model) throws Exception {
        String pageNow = request.getParameter("pageNow");
        Page page = null;
        List<User> users = new ArrayList<User>();
        int totalCount =userService.countallNumber();

        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
            users = userService.findPages(page.getStartPos(), page.getPageSize());
        } else {
            page = new Page(totalCount, 1);
            users = this.userService.findPages(page.getStartPos(), page.getPageSize());//
            for (int i=0;i<users.size();i++){
            }
        }
        model.addAttribute("user_list", users);
        model.addAttribute("page", page);
        model.addAttribute("code",1);
        return "/main";
    }

    //修改数据-点击编辑按钮后跳转到的页面
    @RequestMapping(value = "/update")
    public ModelAndView update(User user){
        User u = userService.getUserByID(user.getId());
        ModelAndView modelAndView = new ModelAndView("editUser");
        modelAndView.addObject("u",u);
        return modelAndView;
    }

    //修改按钮后跳转到的页面
    @RequestMapping(value = "/updateUser")
    public ModelAndView updateUser(User user){
        userService.updateUser(user);
        ModelAndView modelAndView = new ModelAndView("redirect:/user/main");
        return modelAndView;
    }

    //删除
    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public String deleteUser(User user){
        userService.deleteUser(user);
        return "redirect:/user/main";
    }
}
