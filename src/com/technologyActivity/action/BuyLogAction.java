package com.technologyActivity.action;

import com.technologyActivity.entities.BuyLog;
import com.technologyActivity.service.BuyLogService;
import com.technologyActivitybaseFun.baseAction;

public class BuyLogAction extends baseAction<BuyLog>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BuyLogService buyLogService;

	public BuyLogService getBuyLogService() {
		return buyLogService;
	}

	public void setBuyLogService(BuyLogService buyLogService) {
		this.buyLogService = buyLogService;
	}
	
}
