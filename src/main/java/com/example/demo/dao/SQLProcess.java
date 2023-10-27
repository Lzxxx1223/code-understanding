package com.example.demo.dao;

import com.example.demo.model.DC;
import com.example.demo.model.DCA;
import com.example.demo.model.Mapping;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface SQLProcess {

    void insert(@Param("sql") String sql);

    List<Map<String, Object>> select(@Param("sql") String sql);

    DC selectDCByDCTable(@Param("table") String table);

    List<DCA> selectDCAByDCId(@Param("dcId") Integer dcId);

    List<Mapping> selectMapping();

    Integer findMaxPin();
}
