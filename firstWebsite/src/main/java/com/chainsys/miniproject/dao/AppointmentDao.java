package com.chainsys.miniproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.miniproject.pojo.Appointment;

public class AppointmentDao {
	 public static Connection getConnection() {
		   String drivername = "oracle.jdbc.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "system";
			String password = "Arunps2244#";
			try {
				Class.forName(drivername);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection con = null;
			try {
				con = DriverManager.getConnection(dbUrl, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return con;
	   }
	 
	 private static java.sql.Date convertTosqlDate(java.util.Date date) {
			java.sql.Date sqldate = new java.sql.Date(date.getTime());
			return sqldate;
	 }
	 
	 public static int insertAppointment(Appointment newap) {
			String insertquery = "insert into Appointment(appoint_id,appoint_date,doctor_id,patient_name,fees_collected) values (?,?,?,?,?)";
			Connection con = null;
			int rows =0;
//			int rows ;
			PreparedStatement ps = null;
			try {
				con = getConnection();
				ps = con.prepareStatement(insertquery);
				ps.setInt(1, newap.getAppoint_Id());
				// convert java.util.Date to java.sql.date
				ps.setDate(2, convertTosqlDate(newap.getAppoint_Date()));
				ps.setInt(3, newap.getDoc_Id());
				ps.setString(4, newap.getPatient_Name());
				ps.setString(5,newap.getFees_Collected());
				rows = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return rows;
		}
	 
	 public static int updateAppointment(Appointment newap) {
			String updatequery = "update appointment set appoint_date=?,doctor_id=?,patient_name=?,fees_collected=? where appoint_id=?";
			Connection con = null;
			int rows =0;
//			int rows ;
			PreparedStatement ps = null;
			try {
				con = getConnection();
				ps = con.prepareStatement(updatequery);
				// convert java.util.Date to java.sql.date
				ps.setDate(1, convertTosqlDate(newap.getAppoint_Date()));
				ps.setInt(2, newap.getDoc_Id());
				ps.setString(3, newap.getPatient_Name());
				ps.setString(4,newap.getFees_Collected());
				ps.setInt(5, newap.getAppoint_Id());
				rows = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return rows;
		}
	 
	 public static int updatePatientName(int id,String name) {
			String updatequery = "update appointment set patient_name=? where appoint_id=?";
			Connection con = null;
			int rows =0;
//			int rows ;
			PreparedStatement ps = null;
			try {
				con = getConnection();
				ps = con.prepareStatement(updatequery);
				ps.setString(1, name);
				ps.setInt(2, id);
				ps.executeUpdate();
				rows = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return rows;
		}
	 
	 public static int updateFeesCollected(int id,String fees) {
			String updatequery = "update appointment set fees_collected=? where appoint_id=?";
			Connection con = null;
			int rows =0;
//			int rows ;
			PreparedStatement ps = null;
			try {
				con = getConnection();
				ps = con.prepareStatement(updatequery);
				ps.setString(1,fees);
				ps.setInt(2,id);
				rows = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return rows;
		}
	 
	  public static int deleteAppointment(int id) {
			String deletequery = "delete from appointment where appoint_id=?";
			Connection con = null;
			int rows = 0;
			PreparedStatement ps = null;
		
			try {
				con = getConnection();
				ps = con.prepareStatement(deletequery);
				ps.setInt(1, id);
				rows = ps.executeUpdate();	
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return rows;
	   }
	  
	  public static Appointment getPatientById(int id) {
		    Appointment ap =null;
			String selectquery = "select appoint_id,appoint_date,doctor_id,patient_name,fees_collected from appointment where appoint_id=?";//need change 
			Connection con = null;
			PreparedStatement ps = null;
			 ResultSet rs  = null;
			try {
				con = getConnection();
				ps = con.prepareStatement(selectquery);
				ps.setInt(1, id);
				rs =ps.executeQuery();
				ap = new Appointment();
				 while(rs.next()) {
					 ap.setAppoint_Id(rs.getInt(1));
				ap.setAppoint_Date(rs.getDate(2));
				// convert java.util.Date to java.sql.date
				ap.setDoc_Id(rs.getInt(3));
				ap.setPatient_Name(rs.getString(4));
				ap.setFees_Collected(rs.getString(5));
			}} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return ap;
		}
	  
	  public static List<Appointment> getAllAppoinments(){
			 List<Appointment> listOfAppointments = new ArrayList<Appointment>();
			 Appointment ap =null;
				String selectquery = "select appoint_id,appoint_date,doctor_id,patient_name,fees_collected from appointment";
				Connection con = null;
				PreparedStatement ps = null;
				 ResultSet rs  = null;
				try {
					con = getConnection();
					ps = con.prepareStatement(selectquery);
					rs =ps.executeQuery();
					
					   while(rs.next()) {
						   ap =new Appointment();
						   
						 ap.setAppoint_Id(rs.getInt(1));
						 ap.setAppoint_Id(rs.getInt(1));
							ap.setAppoint_Date(rs.getDate(2));
							// convert java.util.Date to java.sql.date
							ap.setDoc_Id(rs.getInt(3));
							ap.setPatient_Name(rs.getString(4));
							ap.setFees_Collected(rs.getString(5));
				          listOfAppointments.add(ap);
				        }
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						rs.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			 return listOfAppointments;
		 }
	  
	  
	
	 
}
