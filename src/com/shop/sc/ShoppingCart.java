package com.shop.sc;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.iface.sc.IPricing;


public class ShoppingCart {
	
	private IPricing pricingRuleImpl;
	List<ShopItem> shopItems = new LinkedList<ShopItem>();
	String promoCode;
	Map<String,Double> resultItems = new HashMap<String,Double>();
	boolean isPromo = false;
	
	ShoppingCart(IPricing PriceRuleImpl){
		this.pricingRuleImpl = PriceRuleImpl;
	}
	
	void add(ShopItem si){
		shopItems.add(si);
		this.resultItems = this.pricingRuleImpl.offerResult(this.shopItems, this.isPromo);
	}
	
	void add(ShopItem si, String promoCode){
		shopItems.add(si);
		if (promoCode != null){
			this.isPromo = true;
		}
		this.resultItems = this.pricingRuleImpl.offerResult(this.shopItems, this.isPromo);
	}
	
	public void total(){
		for(Map.Entry<String, Double> entry: map.entrySet()) {
		    System.out.println( "total : " + entry.getValue());
		}
	}
	
	public void items(){
		for(Map.Entry<String, Double> entry: map.entrySet()) {
		    System.out.println( "items : " + entry.getKey());
		}
	}
	
	
	
}

public static void main(String args[]){
	ShopItem item1 = new ShopItem();
	ShopItem item2 = new ShopItem();
	//set shop item values here
		
	ShoppingCart cart =  new ShoppingCart(new PricingRule2016Impl());
	cart.add(item1);
	
	
}
