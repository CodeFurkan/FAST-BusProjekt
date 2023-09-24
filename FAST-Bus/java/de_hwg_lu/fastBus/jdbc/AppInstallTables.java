package de_hwg_lu.fastBus.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class AppInstallTables {
	Connection dbConn;


	public static void main(String[] args) throws SQLException {
		AppInstallTables myApp = new AppInstallTables();
		myApp.dbConn = new PostgreSQLAccess().getConnection();
		myApp.doSomething();

	}
	public void doSomething() throws SQLException {
//		this.dropTableBuchung();
//		this.dropTableAccount();
//		this.createTableAccount();
//		this.createTableBuchung();
		this.dropTableBusInfo();
//		this.dropTableRouten();
//		this.createTableRouten();
//		this.insertRouten();
		this.createTableBusInfo();
	}
	
	public void executeUpdateWithoutParms(String sql) throws SQLException{
		System.out.println(sql);
		this.dbConn.prepareStatement(sql).executeUpdate();
	}
	
	public void createTableBuchung() throws SQLException {
		this.executeUpdateWithoutParms(
				"Create table Buchung("
						+ "				 BuchungID 		serial 			not null primary key	,"
						+ "				 KundenID 		integer			not null				,"
						+ "				 BusinfoID 		integer			not null				,"
						+ "				 RoutenID 		char(6)			not null				,"
						+ "				 Adresse		varchar(256)	not null				,"
						+ "				 Stadt 			varchar(256)	not null				,"
						+ "				 PLZ 			varchar(256)	not null				,"
						+ "				 IBAN 			varchar(256)	not null				,"
						+ "				 BIC 			varchar(256)	not null				,"
						+ "				 Vorname 		varchar(256) 	not null				,"
						+ "				 Nachname 		varchar(256) 	not null				,"
						+ "				 NameKonto		varchar(256)	not null				,"
						+ "				 foreign key (KundenID) references bwi520_632085.Account(KundenID),"
						+ "				 foreign key (RoutenID) references bwi520_632085.Routen(RoutenID)"
						+ "				 )"
						);
	}
	
	public void createTableAccount() throws SQLException {
		this.executeUpdateWithoutParms(
				"Create table Account("
				+ "	KundenID 		serial 			not null primary key	,"
				+ "	Vorname 		varchar(256) 	not null				,"
				+ "	Nachname 		varchar(256) 	not null				,"
				+ " Geburtsdatum 	date			not null				,"
				+ "	Email 			varchar(256) 	not null				,"
				+ " Passwort 		char(32) 		not null				,"
				+ " UNIQUE (Email)"
				+ ")"
				);			
	}
	public void dropTableAccount() throws SQLException {
		String sql = "drop table if exists Account";
		System.out.println(sql);
		this.dbConn.prepareStatement(sql).executeUpdate();
		System.out.println("Table Account gedropped");
		
	}
	public void dropTableBuchung() throws SQLException {
		String sql = "drop table if exists Buchung";
		System.out.println(sql);
		this.dbConn.prepareStatement(sql).executeUpdate();
		System.out.println("Table Buchung gedropped");
		
	}
	private void dropTableRouten() throws SQLException {
		String sql = "drop table if exists Routen";
		System.out.println(sql);
		this.dbConn.prepareStatement(sql).executeUpdate();
		System.out.println("Table Routen gedropped");
		
	}
	
	public void dropTableBusInfo() throws SQLException{
	String sql = "drop table if exists BusInfo";
	System.out.println(sql);
	this.dbConn.prepareStatement(sql).executeUpdate();
	System.out.println("Table BusInfo gedropped");
}
	
	public void createTableRouten() throws SQLException {
		this.executeUpdateWithoutParms(
				"Create table Routen("
				+ "	RoutenID char(6) not null primary key,"
				+ "	StartStadt varchar(256) not null,"
				+ "	ZielStadt varchar(256) not null,"
				+ "	Dauer decimal(4,2) not null,"
				+ "	Preis decimal(5,2) not null"
				+ "	)"
				);	
	}
	
	public void createTableBusInfo() throws SQLException {
		this.executeUpdateWithoutParms(
				"Create table BusInfo("
				+ 	" BusinfoID serial not null primary key,"
				+	" StartDatum char(10) not null,"
				+	" ZielDatum char(10) not null,"
				+	" StartZeit char(5) not null,"
				+	" ZielZeit char(5) not null,"
				+	" RoutenID char(6) not null ,"
				+	" PlaetzeFrei integer not null"
				+ 	" )"
				);
	}
	public void insertRouten() throws SQLException {
		this.executeUpdateWithoutParms(
				  "INSERT INTO Routen "
				+ "(RoutenID, Startstadt, Zielstadt, Dauer, Preis)"
				+ "VALUES"
				+ "    ('BERMUN', 'Berlin', 'München', 07.00, 20.00),"
				+ "    ('BERFRA', 'Berlin', 'Frankfurt', 06.30, 28.00),"
				+ "    ('BERHAM', 'Berlin', 'Hamburg', 03.45, 20.00),"
				+ "    ('BERMAN', 'Berlin', 'Mannheim', 07.00, 35.00),"
				+ "    ('BERLEI', 'Berlin', 'Leipzig', 02.40, 10.00),"
				+ "    ('BERSTU', 'Berlin', 'Stuttgart', 07.30, 27.00),"
				+ "    ('BERDUS', 'Berlin', 'Düsseldorf', 06.55, 28.00),"
				+ ""
				+ "    ('MUNBER', 'München', 'Berlin', 07.00, 20.00),"
				+ "    ('MUNFRA', 'München', 'Frankfurt', 04.50, 22.00),"
				+ "    ('MUNHAM', 'München', 'Hamburg', 08.30, 36.00),"
				+ "    ('MUNMAN', 'München', 'Mannheim', 04.25, 19.00),"
				+ "    ('MUNLEI', 'München', 'Leipzig', 04.40, 29.00),"
				+ "    ('MUNSTU', 'München', 'Stuttgart', 03.10, 13.00),"
				+ "    ('MUNDUS', 'München', 'Düsseldorf', 07.10, 32.00),"
				+ ""
				+ "    ('FRABER', 'Frankfurt', 'Berlin', 06.30, 28.00),"
				+ "    ('FRAMUN', 'Frankfurt', 'München', 04.50, 22.00),"
				+ "    ('FRAHAM', 'Frankfurt', 'Hamburg', 06.00, 19.00),"
				+ "    ('FRAMAN', 'Frankfurt', 'Mannheim', 01.20, 11.00),"
				+ "    ('FRALEI', 'Frankfurt', 'Leipzig', 04.50, 25.00),"
				+ "    ('FRASTU', 'Frankfurt', 'Stuttgart', 03.00, 16.00),"
				+ "    ('FRADUS', 'Frankfurt', 'Düsseldorf', 03.30, 19.00),"
				+ ""
				+ "    ('HAMBER', 'Hamburg', 'Berlin', 03.40, 20.00),"
				+ "    ('HAMMUN', 'Hamburg', 'München', 08.30, 36.00),"
				+ "    ('HAMFRA', 'Hamburg', 'Frankfurt', 06.00, 19.00),"
				+ "    ('HAMMAN', 'Hamburg', 'Mannheim', 07.00, 29.00),"
				+ "    ('HAMLEI', 'Hamburg', 'Leipzig', 04.45, 19.00),"
				+ "    ('HAMSTU', 'Hamburg', 'Stuttgart', 07.40, 27.00),"
				+ "    ('HAMDUS', 'Hamburg', 'Düsseldorf', 05.00, 22.00),"
				+ ""
				+ "    ('MANBER', 'Mannheim', 'Berlin', 07.00, 35.00),"
				+ "    ('MANMUN', 'Mannheim', 'München', 04.25, 19.00),"
				+ "    ('MANFRA', 'Mannheim', 'Frankfurt', 01.20, 11.00),"
				+ "    ('MANHAM', 'Mannheim', 'Hamburg', 07.00, 29.00),"
				+ "    ('MANLEI', 'Mannheim', 'Leipzig', 05.25, 25.00),"
				+ "    ('MANSTU', 'Mannheim', 'Stuttgart', 02.15, 13.00),"
				+ "    ('MANDUS', 'Mannheim', 'Düsseldorf', 04.00, 18.00),"
				+ ""
				+ "    ('LEIBER', 'Leipzig', 'Berlin', 02.40, 10.00),"
				+ "    ('LEIMUN', 'Leipzig', 'München', 04.40, 29.00),"
				+ "    ('LEIFRA', 'Leipzig', 'Frankfurt', 04.50, 25.00),"
				+ "    ('LEIHAM', 'Leipzig', 'Hamburg', 04.45, 19.00),"
				+ "    ('LEIMAN', 'Leipzig', 'Mannheim', 05.25, 25.00),"
				+ "    ('LEISTU', 'Leipzig', 'Stuttgart', 05.50, 40.00),"
				+ "    ('LEIDUS', 'Leipzig', 'Düsseldorf', 06.00, 22.00),"
				+ ""
				+ "    ('STUBER', 'Stuttgart', 'Berlin', 07.30, 27.00),"
				+ "    ('STUMUN', 'Stuttgart', 'München', 03.10, 13.00),"
				+ "    ('STUFRA', 'Stuttgart', 'Frankfurt', 03.00, 16.00),"
				+ "    ('STUHAM', 'Stuttgart', 'Hamburg', 07.40, 27.00),"
				+ "    ('STUMAN', 'Stuttgart', 'Mannheim', 02.15, 13.00),"
				+ "    ('STULEI', 'Stuttgart', 'Leipzig', 05.50, 40.00),"
				+ "    ('STUDUS', 'Stuttgart', 'Düsseldorf', 05.15, 24.00),"
				+ ""
				+ "    ('DUSBER', 'Düsseldorf', 'Berlin', 06.55, 28.00),"
				+ "    ('DUSMUN', 'Düsseldorf', 'München', 07.10, 32.00),"
				+ "    ('DUSFRA', 'Düsseldorf', 'Frankfurt', 03.30, 19.00),"
				+ "    ('DUSHAM', 'Düsseldorf', 'Hamburg', 05.00, 22.00),"
				+ "    ('DUSMAN', 'Düsseldorf', 'Mannheim', 04.00, 18.00),"
				+ "    ('DUSLEI', 'Düsseldorf', 'Leipzig', 06.00, 22.00),"
				+ "    ('DUSSTU', 'Düsseldorf', 'Stuttgart', 05.15, 24.00)"
			);
	}
	}
