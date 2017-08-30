package com.pintabar.commons.exceptions.tableunit;

import com.pintabar.commons.exceptions.AppException;
import com.pintabar.commons.exceptions.ErrorCode;

/**
 * @author Lucas.Godoy on 30/08/17.
 */
public class InvalidTableUnitException extends AppException {

	public InvalidTableUnitException(ErrorCode errorCode, Object... params) {
		super(errorCode, params);
	}

}
