package com.yusuf.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yusuf.spring.pojo.Advert;
import com.yusuf.spring.pojo.Category;

@Controller
public class CategoryController extends MyController {
	@RequestMapping(value = "/category/add.htm", method = RequestMethod.GET)
	public String showFormPage() {
		// Create the Hibernate Objects
		return "category-form";
	}

	@RequestMapping(value = "/category/add.htm", method = RequestMethod.POST)
	public ModelAndView addCategory(HttpServletRequest request) {
		// Create the Hibernate Objects
		Session hibernatesession = getSession();

		String categoryTitle = request.getParameter("title");
		Category category = new Category(categoryTitle);
		try {
			hibernatesession.beginTransaction();
			hibernatesession.save(category);
			hibernatesession.getTransaction().commit();
			System.out.println("Category created!" + categoryTitle);
		} catch (HibernateException e) {
			System.out.println("Cannot create category! " + e);
			hibernatesession.getTransaction().rollback();
		} finally {
			hibernatesession.close();
		}
		return new ModelAndView("category-success", "category", category);
	}
	@RequestMapping(value = "/category/lazyload.htm", method = RequestMethod.GET)
	public ModelAndView lazyload() {
		// Create the Hibernate Objects
		Session hibernatesession = getSession();
		// get the list of adverts using HQL
		Query q = hibernatesession.createQuery("from Category");
		List<Category> categories = q.list();
		hibernatesession.close();
		return new ModelAndView("lazyload","categories",categories);
	}
}
