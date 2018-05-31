package com.zr.service;

import com.zr.entity.Book;

import java.util.List;
import java.util.Map;

public interface IBookService {
    public Map<String,Object> findBooks(Integer pageNumber, Integer pageSize);
    public int allCount();
}
