package org.laboratory.controller;

import org.aspectj.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@Controller
@RequestMapping("/uploadFile")
public class FileController {

    @RequestMapping(value = "/showUploadPage", method = RequestMethod.GET)
    public String showUploadPage(){
        return "/fileupload";
    }

    @RequestMapping(value = "doUpload", method = RequestMethod.POST)
    public String doUpload(@RequestParam("myfiles") MultipartFile[] myfiles,
                           HttpServletRequest request) throws IOException {
        for(MultipartFile files:myfiles){
            //此处MultipartFile[]表明是多文件,如果是单文件MultipartFile就行了
            if(files.isEmpty()){
                System.out.println("文件未上传!");
            } else{
                String fileName = files.getOriginalFilename();

                //得到服务器项目发布运行所在地址
                String deployPath = request.getSession().getServletContext()
                        .getRealPath("imgs")+File.separator;

                //  此处未使用UUID来生成唯一标识,用日期做为标识
                String path = deployPath
                        + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
                        +fileName;

                //查看文件上传路径,方便查找
                System.out.println(path);

                //把文件上传至path的路径
                File localFile = new File(path);
                files.transferTo(localFile);
            }
        }
        return "uploadsucess";
    }

}
