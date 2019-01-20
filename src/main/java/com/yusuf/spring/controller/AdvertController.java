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
public class AdvertController extends MyController {
	// add advert. This is like SimpleFormController
	@RequestMapping(value = "/advert/add.htm", method = RequestMethod.GET)
	public ModelAndView showFormPage() {
		// Create the Hibernate Objects
		// Configuration cfg = new Configuration();
		// SessionFactory sf =
		// cfg.configure().buildSessionFactory();
		Session hibernatesession = getSession();

		// // Now, we need to get a list of Categories from the DB
		// // Can we use hibernatesession.get()?
		// // NO, because get() will return only ONE object
		// // So, we will use HQL to retrieve the list of categories
		Query hqlquery = hibernatesession.createQuery("from Category");
		List<Category> categories = hqlquery.list();
		return new ModelAndView("advert-form", "categories", categories);
	}

	@RequestMapping(value = "/advert/add.htm", method = RequestMethod.POST)
	public ModelAndView showSuccesPage(HttpServletRequest request) {
		// read the fields one by one

		Session hibernatesession = getSession();

		String categoryTitle = request.getParameter("categoryTitle");
		String advertTitle = request.getParameter("title");
		String message = request.getParameter("message");

		Query q = hibernatesession.createQuery("from Category where title = :title");
		q.setString("title", categoryTitle);
		Category category = (Category) q.uniqueResult();
		Advert advert = new Advert(advertTitle, message, category);
		try {
			hibernatesession.beginTransaction();
			hibernatesession.save(advert);
			hibernatesession.getTransaction().commit();
			System.out.println("Advert Created! " + advert.getTitle());
		} catch (HibernateException e) {
			System.out.println("Cannot create advert! " + e);
			hibernatesession.getTransaction().rollback();
		}finally{
			hibernatesession.close();
		}
		// Use Hibernate to save the Advert into the DB
		// Just copy-paste Hibernate objects here
		// This is a DML (SAVE query), so we will need Transaction, and COMMIT
		// Hibernate does not COMMIT transactions automatically
		// Code will execute fine, but nothing would be in the DB (as it does
		// ROLL BACK)
		return new ModelAndView("advert-success","advert",advert);
	}

	// add advert. This is like SimpleFormController
	@RequestMapping(value = "/advert/list.htm", method = RequestMethod.GET)
	public ModelAndView showAdverts() {
		Session hibernatesession = getSession();
		// get the list of adverts using HQL
		Query q = hibernatesession.createQuery("from Advert");
		List<Advert> adverts = q.list();
		hibernatesession.close();
		return new ModelAndView("advert-list", "adverts", adverts);
	}
}
