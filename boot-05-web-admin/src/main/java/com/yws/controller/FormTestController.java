package com.yws.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FormTestController {

    @GetMapping("/form_layouts")
    public String formLayouts() {
        return "form/form_layouts";
    }

    /**
     * MultipartFile 自动封装上传过来的文件
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws Exception {
        log.info("上传的信息 ：email={}, username={}, headerImg={}, photos={}",
                email, username, headerImg.getSize(), photos.length );


        if (!headerImg.isEmpty()) {
            //保存到文件服务器，OSS服务器
            String filename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("E:\\cache\\" + filename));
        }

        if (photos.length > 0) {
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    String filename = photo.getOriginalFilename();
                    photo.transferTo(new File("E:\\cache\\" + filename));
                }
            }
        }

        return "main";
    }
}
