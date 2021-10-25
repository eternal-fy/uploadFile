package com.ld.controller;

import com.ld.pojo.User;
import com.ld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class FileController {

    @RequestMapping("/fileupload1")
    public String con1( MultipartFile uploadFile) throws IOException {
        if(uploadFile.getOriginalFilename()=="")
            return "redirect:mainPage.html";
        System.out.println("heheheheeh");

        File pfile=new File("file");//默认目录在tomcat的bin目录下
        if(!pfile.exists()){
            boolean mkdir = pfile.mkdir();
        }

        File file=new File(pfile,"software");
        if(!file.exists()){
            boolean mkdir = file.mkdir();
        }


        uploadFile.transferTo(new File(file,uploadFile.getOriginalFilename()));
        System.out.println("-------------"+uploadFile.getOriginalFilename());
        return "redirect:mainPage.html";
    }

    @RequestMapping("/fileupload2")
    public String con2( MultipartFile uploadFile) throws IOException {
        if(uploadFile.getOriginalFilename()=="")
            return "redirect:mainPage.html";
//        if(uploadFile.getOriginalFilename()=="")
        File pfile=new File("file");//默认目录在tomcat的bin目录下
        if(!pfile.exists()){
            boolean mkdir = pfile.mkdir();
        }

        File file=new File(pfile,"game");
        if(!file.exists()){
            boolean mkdir = file.mkdir();
        }
        uploadFile.transferTo(new File(file,uploadFile.getOriginalFilename()));
        return "redirect:mainPage.html";
    }

    @RequestMapping("/getSoftware")
    @ResponseBody
    public List<String> get1() {
        File file=new File("file/software");
        if(!file.exists())
            return null;
        File[]files=file.listFiles();
        List<String> names=new ArrayList<String>();
        for(File f:files){
            names.add(f.getName());
        }
        return names;
    }

    @RequestMapping("/getGame")
    @ResponseBody
    public List<String> get2() {
        File file=new File("file/game");
        if(!file.exists())
            return null;
        File[]files=file.listFiles();
        List<String> names=new ArrayList<String>();
        for(File f:files){
            names.add(f.getName());
        }
        return names;
    }
}
