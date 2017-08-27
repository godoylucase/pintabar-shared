package com.pintabar.commons.exceptions.purchaseorder;

import com.pintabar.commons.exceptions.AppException;
import com.pintabar.commons.exceptions.ErrorCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by lucasgodoy on 23/06/17.
 */
@Getter
@Setter
@NoArgsConstructor
public class InvalidPurchaseOrderException extends AppException {

	public InvalidPurchaseOrderException(ErrorCode errorCode, Object... params) {
		super(errorCode, params);
	}
}
