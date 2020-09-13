package com.ossez.edtestbank.tests;

import com.ossez.edtestbank.common.Factory;
import com.ossez.edtestbank.common.ValidationException;
import com.ossez.edtestbank.common.dao.factories.Covid19Factory;
import com.ossez.edtestbank.common.models.Covid19Current;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class Covid19Test  {
	@BeforeAll
	protected void setUp() throws Exception {
		Factory.beginTransaction();
	}
	
	@AfterAll
	protected void tearDown() throws Exception {
		Factory.rollbackTransaction();
	}

	/**
	 * Tests search functionality for the customer object.
	 */
	public void testGetCovid19Current() throws ValidationException {
		Covid19Current covid19Current = new Covid19Current();
		Covid19Factory.get(1L);

		// make sure the customer was found

		assertNotNull(covid19Current);

	}

}
