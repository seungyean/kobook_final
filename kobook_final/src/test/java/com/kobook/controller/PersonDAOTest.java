package com.kobook.controller;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kobook.person.persistence.PersonDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class PersonDAOTest {

	@Inject
	private PersonDAO dao;
	
	@Test
	public void test() throws Exception{
		
		System.out.println(dao.findPersonId("admin@kobook.com"));
	}

}
