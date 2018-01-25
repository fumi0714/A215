import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MariaDbConnector {
	private Connection con = null;
	private String ip, user, pass;
	private boolean handan;

	// ログイン処理
	boolean Login(String ip, String user, String pass) throws SQLException {

		try {
			// MySQLに接続
			con = DriverManager.getConnection("jdbc:mariadb://" + ip + ":3306/TEST", user, pass);
			this.ip = ip;
			this.user = user;
			this.pass = pass;
			handan = true;
			System.out.println("MariaDBに接続できました。");
		} catch (NullPointerException e) {
			handan = false;
			System.out.println("MariaDBに接続できませんでした。");
		} finally {
			if (con != null) {
				try {
					if (con != null) {
						con.close();
					}
				} catch (SQLException e) {
					System.out.println("MariaDBのクローズに失敗しました。");
				}
			}
		}
		return handan;
	}

	// 従業員登録のINSERT処理
	boolean Insert(String name, String birth, String address, String hire, String hourly) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		boolean handan;

		try {
			// MySQLに接続
			con = DriverManager.getConnection("jdbc:mariadb://" + ip + ":3306/TEST", user, pass);
			stmt = con.createStatement();
			handan = true;
			System.out.println("MariaDBに接続できましたよ。");

			stmt.executeQuery("INSERT INTO EMP(NAME,BIRTHDAY,ADRESS,HIRE,HOURLY)" + "VALUES('" + name + "'," + ""
					+ birth + ",'" + address + "'," + hire + "," + hourly + ")");

		} catch (NullPointerException e) {
			handan = false;
			System.out.println("MariaDBに接続できませんでした。");
		} finally {
			if (con != null) {
				try {
					if (con != null) {
						con.close();
					}
					if (stmt != null) {
						con.close();
					}

				} catch (SQLException e) {
					System.out.println("MariaDBのクローズに失敗しました。");
				}
			}
		}
		return handan;
	}

	// 従業員登録のUPDATE処理

	boolean Update(String id, String field, String price) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		boolean handan;

		try {
			// MySQLに接続
			con = DriverManager.getConnection("jdbc:mariadb://" + ip + ":3306/TEST", user, pass);
			stmt = con.createStatement();
			handan = true;
			System.out.println("MariaDBに接続できました。");

			if (field.equals("NAME") || field.equals("ADRESS")) {
				stmt.executeQuery("UPDATE EMP SET " + field + " = '" + price + "' WHERE EMPID = " + id + " ");
			} else {
				stmt.executeQuery("UPDATE EMP SET " + field + " = " + price + " WHERE EMPID = " + id + " ");
			}

		} catch (NullPointerException e) {
			handan = false;
			System.out.println("MariaDBに接続できませんでした。");
		} finally {
			if (con != null) {
				try {
					if (con != null) {
						con.close();
					}
					if (stmt != null) {
						con.close();
					}

				} catch (SQLException e) {
					System.out.println("MariaDBのクローズに失敗しました。");
				}
			}
		}
		return handan;
	}

	boolean Delete(String id) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		boolean handan;

		try {
			// MySQLに接続
			con = DriverManager.getConnection("jdbc:mariadb://" + ip + ":3306/TEST", user, pass);
			stmt = con.createStatement();
			handan = true;
			System.out.println("MariaDBに接続できました。");

			stmt.executeQuery("DELETE FROM EMP WHERE EMPID = " + id + "");

		} catch (NullPointerException e) {
			handan = false;
			System.out.println("MariaDBに接続できませんでした。");
		} finally {
			if (con != null) {
				try {
					if (con != null) {
						con.close();
					}
					if (stmt != null) {
						con.close();
					}

				} catch (SQLException e) {
					System.out.println("MariaDBのクローズに失敗しました。");
				}
			}
		}
		return handan;
	}

	//従業員参照
	boolean Select(String id[]) throws SQLException {
		Connection con = null;
		Statement stmt = null;

		boolean handan;

		try {
			// MySQLに接続
			con = DriverManager.getConnection("jdbc:mariadb://" + ip + ":3306/TEST", user, pass);
			stmt = con.createStatement();
			handan = true;
			System.out.println("MariaDBに接続できました。");

			ResultSet rs = stmt.executeQuery("SELECT * FROM EMP WHERE EMPID = " + id[0]);

			while (rs.next()) {
				id[0] = "" + rs.getInt("EMPID");
				id[1] = rs.getString("NAME");
				id[2] = "" + rs.getTimestamp("BIRTHDAY");
				id[3] = rs.getString("ADRESS");
				id[4] = "" + rs.getTimestamp("HIRE");
				id[5] = "" + rs.getInt("HOURLY");
				System.out.println(id[0] + " " + id[1] + " " + id[2] + " " + id[3] + " " + id[4] + " " + id[5] + " ");
			}

		} catch (NullPointerException e) {
			handan = false;
			System.out.println("MariaDBに接続できませんでした。");
		} finally {
			if (con != null) {
				try {
					if (con != null) {
						con.close();
					}
					if (stmt != null) {
						con.close();
					}

				} catch (SQLException e) {
					System.out.println("MariaDBのクローズに失敗しました。");
				}
			}
		}
		return handan;
	}

	//シフト管理登録

	boolean SInsert(String id, String start, String end) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		boolean handan;

		try {
			// MySQLに接続
			con = DriverManager.getConnection("jdbc:mariadb://" + ip + ":3306/TEST", user, pass);
			stmt = con.createStatement();
			handan = true;
			System.out.println("MariaDBに接続できました。");

			stmt.executeQuery("INSERT INTO SHIFT(EMPID,STARTTIME,ENDTIME)" +
					"VALUES(" + id + ",'" + start + "','" + end + "')");
			System.out.println("シフトインサート");

		} catch (NullPointerException e) {
			handan = false;
			System.out.println("MariaDBに接続できませんでした。");
		} finally {
			if (con != null) {
				try {
					if (con != null) {
						con.close();
					}
					if (stmt != null) {
						con.close();
					}

				} catch (SQLException e) {
					System.out.println("MariaDBのクローズに失敗しました。");
				}
			}
		}
		return handan;
	}

	boolean SDelete(String sid) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		boolean handan;

		try {
			// MySQLに接続
			con = DriverManager.getConnection("jdbc:mariadb://" + ip + ":3306/TEST", user, pass);
			stmt = con.createStatement();
			handan = true;
			System.out.println("MariaDBに接続できました。");

			stmt.executeQuery("DELETE FROM SHIFT WHERE SHIFTID = "+ sid +"");

		} catch (NullPointerException e) {
			handan = false;
			System.out.println("MariaDBに接続できませんでした。");
		} finally {
			if (con != null) {
				try {
					if (con != null) {
						con.close();
					}
					if (stmt != null) {
						con.close();
					}

				} catch (SQLException e) {
					System.out.println("MariaDBのクローズに失敗しました。");
				}
			}
		}
		return handan;
	}

}