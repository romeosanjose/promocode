package com.iface.sc;
import java.util.List;
import java.util.Map;

import com.shop.sc.*;

public interface IPricing {
	
	Map<String, Double> offerResult(List<ShopItem> shopItems, boolean isPromo);
	
}

