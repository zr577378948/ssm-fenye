package com.zr.mapper;

import com.zr.entity.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository//防止mapper报错
public interface IBookMapper {

    /**
     * 分页显示数据
     * @param start
     * @param end
     * @return
     */
    public List<Book> findBooks(@Param("start") Integer start,@Param("end") Integer end);

    /**
     * 计算总记录数
     * @return
     */
    public Integer allCount();

}
