package com.regnant.DATASOURCEPOOL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.commons.datasource.poolservice.DataSourceNotFoundException;
import com.day.commons.datasource.poolservice.DataSourcePool;


@Component(service=Userregistrationinterface.class)

public class Userregistrationimpl implements Userregistrationinterface {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	@Reference
	private DataSourcePool dsp;

	private Connection getConnection() {
		// TODO Auto-generated method stub
		log.info("log file is running");
		DataSource ds = null;
		Connection con = null;
		try {
			ds = (DataSource) dsp.getDataSource("Userregistration");
			con = ds.getConnection();

			return con;
		} catch (DataSourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
@Override
	public int insertuser(String name, String password, String email) {

		Connection con = null;
		int rowcount = 0;
		con = getConnection();
		PreparedStatement pstm = null;
		
		try {
		System.out.println("in insert user "+name+" "+password+" "+email+" ");
		String sql = "INSERT INTO aem.userregistration VALUES('"+name+"','"+password+"','"+ email+"');";
		System.out.println(sql);
			pstm = con.prepareStatement(sql);
			pstm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
}
