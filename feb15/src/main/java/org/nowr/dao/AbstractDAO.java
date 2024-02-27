package org.nowr.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

//부모 형태로 존재 -> @ 안붙혀요
// 2024-02-26
public class AbstractDAO {

	@Autowired
	SqlSession sqlSession;
}
