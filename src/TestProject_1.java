import java.sql.*; 

public class TestProject_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection c = null;
		try{
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5000/", "postgres", "Thinkas1!");
			Statement state = c.createStatement();
			ResultSet rs = state.executeQuery("SELECT * FROM User");
			System.out.println("test rs " + rs);
			ResultSetMetaData rsMd = rs.getMetaData();
			int columnsNumber = rsMd.getColumnCount();
			System.out.println(rs);
			while(rs.next()){
				for(int i=1; i<= columnsNumber; i++){
					System.out.println("test this " + rs.getString(i));
				}
			}
			//
		}catch(Exception e){
			e.printStackTrace();
			System.err.println(e.getClass().getName()+ ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println(c);
		System.out.println("Opened database successfully");
	}

}
