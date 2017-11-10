# klassenliste
klassenliste
 - first steps with hibernate
 - playing around with JAVAFX
 - form button up
 
The main Window

![Mainwindow](https://raw.githubusercontent.com/jenspapenhagen/klassenliste/master/src/main/resources/images/mainwindow.jpg)

Edit Dialog:

![Edit Dialog](https://raw.githubusercontent.com/jenspapenhagen/klassenliste/master/src/main/resources/images/addMemberWindow.jpg)

The ERD:

![Entity-Realtionship-Diagramme](https://raw.githubusercontent.com/jenspapenhagen/klassenliste/master/src/main/resources/images/erd.png)


# Install

```bash
wget https://raw.githubusercontent.com/jenspapenhagen/klassenliste/master/src/main/resources/resources/db_database.sql
git clone https://github.com/jenspapenhagen/klassenliste.git
```

```sql
create database db_database
db_database < db_database.sql
```

```bash
mvn clean install
```
