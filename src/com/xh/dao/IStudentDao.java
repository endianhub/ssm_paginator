package com.xh.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.xh.model.StudentModel;

public interface IStudentDao {
	
	public List<StudentModel> findAll();
	
	public List<StudentModel> findPage(PageBounds pageBounds);
}
