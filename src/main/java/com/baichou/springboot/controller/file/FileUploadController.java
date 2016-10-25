package com.baichou.springboot.controller.file;/**
 * Created by root on 16-10-24.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

/**
 * 文件上传控制器
 *
 * @author zyang0419
 * @create 2016-10-24 下午4:23
 **/
@Controller
public class FileUploadController {
    //访问路径为：http://127.0.0.1:9090/file
    //如果file.html在templates下，return的时候不要加/,错误示范retun "/file" ,否则java -jar demo.jar运行时
    //会报错误:
    /**
     * 解决java -jar demo.jar运行时错误
     * exception is org.thymeleaf.exceptions.TemplateInputException: Error resolving template "/file",
     * template might not exist or might not be accessible by any of the configured Template Resolvers]
     * with root cause
     org.thymeleaf.exceptions.TemplateInputException: Error resolving template "/file",
     template might not exist or might not be accessible by any of the configured Template Resolvers

     */
    @RequestMapping("/file")
    public String file() {
        return "file";
    }

    @RequestMapping("/multiFile")
    public String multiFile() {
        return "multiFile";
    }


    /**
     * 文件上传具体实现方法;
     *
     * @param file
     * @return
     */

    @RequestMapping("/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty() && file.getSize() > 0) {
            try {
              /*
               * 这段代码执行完毕之后，图片上传到了工程的跟路径；
               * 大家自己扩散下思维，如果我们想把图片上传到 d:/files大家是否能实现呢？
               * 等等;
               * 这里只是简单一个例子,请自行参考，融入到实际中可能需要大家自己做一些思考，比如：
               * 1、文件路径；
               * 2、文件名；
               * 3、文件格式;
               * 4、文件大小的限制;
               */
                System.out.println("file　originFilename  *************************************"+file.getOriginalFilename());
                /*BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(
                        new File(file.getOriginalFilename())));*/
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(
                        new File(file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }
            return "上传成功";
        } else {
            return "上传失败，因为文件是空的.";

        }
    }


    /**
     * 多文件具体上传时间，主要是使用了MultipartHttpServletRequest和MultipartFile
     *
     * @param request
     * @return
     */

    @RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
    public
    @ResponseBody
    String handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty() && file.getSize() > 0) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    stream = null;
                    return "You failed to upload " + (i+1) + " => " + e.getMessage();
                }
            } else {
                return "You failed to upload " + (i+1) + " because the file was empty.";
            }
        }
        return "upload successful";

    }


}
