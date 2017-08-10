package com.pintabar.commons.exceptions.purchaseorder;

import com.pintabar.commons.exceptions.AppException;
import com.pintabar.commons.exceptions.ErrorCode;

/**
 * Created by lucasgodoy on 23/06/17.
 */
public class ClosedPurchaseOrderException extends AppException {

	public ClosedPurchaseOrderException(ErrorCode errorCode, Object... params) {
		super(errorCode, params);
	}
}
