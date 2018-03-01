package com.xh.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xh.model.StudentModel;
import com.xh.service.StudentService;
import com.xh.util.Page;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class StudentTest {

	@Resource
	private StudentService service;

	@Test
	public void findAll() {
		List<StudentModel> list = service.findAll();
		System.out.println(list.size());
	}

	@Test
	public void findPage() {
		Page page = new Page(0, 10);
		List<StudentModel> list = service.findPage(page);
		System.out.println(list.size());
	}

}
