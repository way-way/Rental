package com.rental.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rental.entity.Discount;
import com.rental.entity.User;
import com.rental.service.DiscountService;
import com.rental.service.UserService;

public class DiscountAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private DiscountService discountService;
	private Discount discount;
	public String showContent() throws Exception {
			List<Discount> list=discountService.getAll();
			if (list!=null) {
				ActionContext.getContext().put("list", list);
			}
			return "discount";
	}
	public DiscountService getDiscountService() {
		return discountService;
	}
	public void setDiscountService(DiscountService discountService) {
		this.discountService = discountService;
	}
	public Discount getDiscount() {
		return discount;
	}
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	//----------------------

	
	
}
