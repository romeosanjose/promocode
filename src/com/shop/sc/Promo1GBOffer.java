package com.shop.sc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Promo1GBOffer {
	
	public Map<String,Double> get1GBPromo(List<ShopItem> shopItems){
		ShopItem shopItem;
		int counter = 0;
		int itemCount = 0;
		double price = 0.0;
		String itemCountDesc;
		Map<String,Double> data = new HashMap<String,Double>();
		for(int i=0; i < shopItems.size(); i++ ){
			shopItem = (ShopItem) shopItems.get(i);
			if(shopItem.getProductCode() == "ult_small"){
				if (counter == 3){
					counter = 0;
					price = price - (shopItem.getPrice() * 3);
					price = price + (shopItem.getPrice() * 2);
				}
				price = price + shopItem.getPrice();
				counter++;
				itemCount++;				
			}
			
		}
		String productName = (String) shopItems.get(0).getProductName();
		if (itemCount > 0){
			itemCountDesc = itemCount + " x " + productName;   
			data.put(itemCountDesc, price);
			return data;
		}
		return null;
		
	}
}
