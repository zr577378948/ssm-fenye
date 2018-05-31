package com.zr.actions;

import com.zr.entity.Book;
import com.zr.service.IBookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class BookAction {

    @Resource
    private IBookService iBookService;

    @RequestMapping(value = "/findBooks.action")
    public @ResponseBody
    Map<String,Object> findBooks(Integer pageNumber, Integer pageSize){
        Map<String,Object> map =  iBookService.findBooks(pageNumber,pageSize);
        /*for (Object o : map.values()) {
              System.out.println("value= " + o);
            }*/
        return iBookService.findBooks(pageNumber,pageSize);
    }
    @RequestMapping(value = "/allCount.action")
    public @ResponseBody int allCount(){
        return iBookService.allCount();
    }
}
