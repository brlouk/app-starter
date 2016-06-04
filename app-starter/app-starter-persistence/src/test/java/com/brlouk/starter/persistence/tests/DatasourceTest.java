package com.brlouk.starter.persistence.tests;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DatasourceTest extends AbstractPersistenceTest {

	@Autowired
	private DataSource dataSource;

	@Test
	public void dataSource() {
		Assert.assertNotNull(dataSource);
	}

}
