package com.nj.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtils {
	private static final ComboPooledDataSource DATA_SOURCE = new ComboPooledDataSource();

	// ��ȡ����Դ
	public static DataSource getDataSource() {
		return DATA_SOURCE;
	}

	// ��ȡ����
	public static Connection getConnection() throws SQLException {
		return DATA_SOURCE.getConnection();
	}
}
