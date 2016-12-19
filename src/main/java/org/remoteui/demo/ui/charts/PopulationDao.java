/** 
 * Created on 17.07.2015 
 * 
 * © 2015 Daniel Thommes, All Rights Reserved
 */
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
 * 
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
