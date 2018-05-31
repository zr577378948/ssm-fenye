package com.zr.service.impl;

import com.zr.entity.Book;
import com.zr.mapper.IBookMapper;
import com.zr.service.IBookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("iBookService")
@Transactional(propagation = Propagation.REQUIRED)
public class BookServiceImpl implements IBookService {

    @Resource
    private IBookMapper iBookMapper;

    @Transactional(propagation = Propagation.NEVER)

    public Map<String,Object> findBooks(Integer pageNumber, Integer pageSize) {
        List<Book> rows = iBookMapper.findBooks(pageNumber,pageSize);//将查询到的数据保存到list集合中
        Integer total = iBookMapper.allCount();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("rows",rows);
        map.put("total",total);
        return map;
    }

    public int allCount() {
        return iBookMapper.allCount();
    }
}
