# Contoh Aplikasi Menggunakan EJB, JPA, dan RESTFull

### Kebutuhan Aplikasi
* Glassfish 4.x
* NetBeans IDE
* PostgreSQL

### Setting Connection Pool
* Jalankan Glassfish, buka localhost:4848
* Create new JDBC Connection Pools, (Resources-> JDBC->JDBC Connection Pools)
* Isi nama pool bebas
* Resource type - > javax.sql.DataSource
* Database driver vendor -> sesuaikan
* Next, pada additional properties, sesuaikan properties berikut:
    (tanpa tanda petik)
    name="User" value="postgres"
    name="DatabaseName" value="hrd"
    name="LogLevel" value="0"
    name="Password" value="passwordAnda"
    name="Ssl" value="false"
    name="ServerName" value="localhost"
    name="ProtocolVersion" value="0"
    name="TcpKeepAlive" value="false"
    name="SocketTimeout" value="0"
    name="PortNumber" value="5432"
    name="LoginTimeout" value="0"
    name="UnknownLength" value="2147483647"
    name="PrepareThreshold" value="5"

hapus sisanya, finish.

* create new JDBC Resources (Resources-> JDBC-> JDBC Resources)
* jndi name = jdbc/hrd
* isi pool name dengan nama pool yang sudah dibuat sebelumya
* ok

### Tabel

CREATE TABLE orang 
(
id character varying,
nama character varying,
email character varying
CONSTRAINT id_pk PRIMARY KEY (id)
) ;

### Petunjuk menjalankan aplikasi
* clean and build projet
* Run
