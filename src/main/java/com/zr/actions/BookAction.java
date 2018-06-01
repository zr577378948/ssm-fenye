package com.zr.actions;

import com.zr.entity.Book;
import com.zr.service.IBookService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class BookAction {

    @Resource
    private IBookService iBookService;

    @RequestMapping(value = "/findBooks.action")
    public @ResponseBody
    Map<String, Object> findBooks(Integer pageNumber, Integer pageSize) {
        Map<String, Object> map = iBookService.findBooks(pageNumber, pageSize);
        /*for (Object o : map.values()) {
              System.out.println("value= " + o);
            }*/
        return iBookService.findBooks(pageNumber, pageSize);
    }

    @RequestMapping(value = "/allCount.action")
    public @ResponseBody
    int allCount() {
        return iBookService.allCount();
    }

    @RequestMapping(value = "/upload.action")
    public @ResponseBody
    String update(@RequestParam(value = "fileName", required = false) MultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println("......................");
        String path = request.getServletContext().getRealPath("upload");//文件的上传路径
        System.out.println("path" + path);
        String fileName = file.getOriginalFilename();//获取文件名
        System.out.println("文件名" + fileName);
        String path1[] = path.split("\\\\");//对于特殊字符的分隔|  ^   $  *   .    (    )   \   /等都是正则表达式的一部分，只能通过前面加上\\进行转义。注意\要用三个\\\，也就是split（“\\\\”）
        String path2 = path1[path1.length - 1];//截取图片所在的文件夹名称
        File dir = new File(path, fileName);//将指定文件上传到指定的目录下
        /**
         * 如果文件夹不存在，自动创建该文件夹
         */
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        if (!file.isEmpty()) {
            file.transferTo(dir);
            return path2 + '\\' + fileName;
        } else {
            System.out.println("空文件");
            return "不允许上传空文件";
        }

    }
}
