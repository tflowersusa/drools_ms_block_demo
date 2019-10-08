package com.commuterep.drools_ms_block_demo.ms.dto.impl;

import java.util.ArrayList;
import java.util.List;

import com.commuterep.drools_ms_block_demo.ms.dto.CartDto;

public class CartDtoImpl implements CartDto {

	private List<String> couponCodes = new ArrayList<>();

	@Override
	public List<String> getCouponCodes() {
		return couponCodes;
	}
}
