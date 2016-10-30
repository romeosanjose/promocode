package com.shop.sc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Promo2GBOffer {
	public Map<String,Double> get2GBPromo(List<ShopItem> shopItems){
		ShopItem shopItem;
		ShopItem dataPack;
		int itemCount = 0;
		int dataPackCount = 0;
		double price = 0.0;
		String itemCountDesc;
		String dataPacDesc;
		Map<String,Double> data = new HashMap<String,Double>();
		for(int i=0; i < shopItems.size(); i++ ){
			shopItem = (ShopItem) shopItems.get(i);
			if(shopItem.getProductCode() == "ult_medium"){
				dataPack = shopItem.getItem("1gb");
				dataPackCount++;
				itemCount++;				
			}
			
		}
		String productName = (String) shopItems.get(0).getProductName();
		String dataPactName = dataPack.getProductName(); 
		if (itemCount > 0){
			itemCountDesc = itemCount + " x " + productName;	
			dataPacDesc  = dataPackCount + "x" + dataPactName;
			data.put(itemCountDesc, price);
			data.put(dataPacDesc,null);
			return data;
		}
		return null;
		
	}
}
