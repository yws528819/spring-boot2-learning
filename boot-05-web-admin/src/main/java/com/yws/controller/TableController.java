package com.yws.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yws.bean.User;
import com.yws.exception.UserTooManyException;
import com.yws.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    private IUserService userService;

    /**
     *
     * @param a 不带请求参数或者参数类型不对 400;Bad Request 一般都是浏览器的参数没有传递正确
     * @return
     */
    @GetMapping("/basic_table")
    public String basicTable(@RequestParam("a") int a) {
        int i = 10/0;
        return "table/basic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, @RequestParam(value = "pn", defaultValue = "1") Integer pn, RedirectAttributes ra) {
        userService.removeById(id);

        ra.addAttribute("pn", pn);
        return "redirect:/dynamic_table";
    }



    @GetMapping("/dynamic_table")
    public String dynamicTable(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {

/*        List<User> users = Arrays.asList(
                new User("zhangsan", "123"),
                new User("lisi", "345"),
                new User("wangwu", "568"),
                new User("zhaoliu", "17723")
        );
        model.addAttribute("users", users);

        if (users.size() > 3) {
            throw new UserTooManyException();
        }*/

        List<User> userList = userService.list();
//        model.addAttribute("users", userList);

        Page<User> userPage = new Page<>(pn, 2);
        Page<User> page = userService.page(userPage, null);
        model.addAttribute("page", page);


        return "table/dynamic_table";
    }


    @GetMapping("/editable_table")
    public String editableTable() {

        return "table/editable_table";
    }


    @GetMapping("/pricing_table")
    public String pricingTable() {

        return "table/pricing_table";
    }


    @GetMapping("/responsive_table")
    public String responsiveTable() {

        return "table/responsive_table";
    }

}
