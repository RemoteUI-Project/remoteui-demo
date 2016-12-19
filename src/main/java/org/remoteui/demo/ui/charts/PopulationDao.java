/*******************************************************************************
 * Copyright 2016 Daniel Thommes
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.remoteui.demo.ui.charts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 * Data Acces Object for the charts demos. This is a good example for using JDBC
 * as well. The DAO imports a bundled CSV file into a H2 database on start and
 * loads the data from the database with Spring's JDBCTemplate.
 * 
 * Data taken from https://opendata.service-bw.de
 *
 * @author Daniel Thommes
 */
@Component
public class PopulationDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	/**
	 * @param jdbcTemplate
	 *            the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 
	 */
	@PostConstruct
	public void init() {
		jdbcTemplate.execute("drop table population if exists");
		jdbcTemplate.execute("CREATE TABLE population AS " + "SELECT * FROM "
				+ "CSVREAD('classpath:org/remoteui/demo/ui/charts/population2010.csv');");
	}

	public List<Integer> getPopulationByPlace(String place) {
		return jdbcTemplate.query("select Population from population where Location is ?;",
				new Object[] { place }, new RowMapper<Integer>() {
					public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
						return rs.getInt(1);
					}
				});
	}

	public List<String> getLocations() {
		return jdbcTemplate.query("select distinct location from population order by location",
				new RowMapper<String>() {
					public String mapRow(ResultSet rs, int rowNum) throws SQLException {
						return rs.getString(1);
					}
				});
	}
}
