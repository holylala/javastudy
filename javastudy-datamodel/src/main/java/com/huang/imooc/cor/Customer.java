package com.huang.imooc.cor;

import com.huang.imooc.cor.handler.PriceHandler;
import com.huang.imooc.cor.handler.PriceHandlerFactory;

import java.util.Random;


/*
 * 客户，请求折扣
 */
public class Customer {
	
	private PriceHandler priceHandler;
	
	public void setPriceHandler(PriceHandler priceHandler) {
		this.priceHandler = priceHandler;
	}

	public void requestDiscount(float discount){
		priceHandler.processDiscount(discount);
	}
	
	
	public static void main(String[] args){
		Customer customer = new Customer();
		customer.setPriceHandler(PriceHandlerFactory.createPriceHandler());
		
		Random rand = new Random();
		
		for(int i=1;i<=100;i++){
			float discount = rand.nextFloat();
			System.out.print(i+":" + discount);
			customer.requestDiscount(discount);
		}
		
		
	}
	

}
