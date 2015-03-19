You need to copy the ojdbc jar file in your local maven Repository :
	USER\.m2\repository\com\oracle\ojdbc6\ojdbc6\11.2.0\THE JAR FILE

Then, create a database with a schema called BOOKING.
If you don't want to modify the hibernate.cfg.xml the credentials will be BENDER as the login and azerty as the password
If you want your own credentials for connecting to the database you'll need to modify the file hibernate.cfg.xml in the project.

That's all you can now launch the project.