# SII-ACOES-HEFESTO_SOFTWARE
En este proyecto, realizaremos la implementación de una aplicación en base a los requisitos propuestos por el cliente.

Se ha creado la carpeta documentación en la cual se almacenarán los requisitos propuestos, así como diagramas y documentación asociada. Además, se ha incluido el pdf con los requisitos definitivos en base al caso propuesto.


En la carpeta HefestoSoftware se han subido los diversos archivos JPA requeridos para la primera entrega.
Para poder generar el código encargado de definir el esquema. Es decir, el archivo ".sql", es necesario crear una base de datos denominada HEFESTOBD e iniciarla. Posteriormente, ejecutar el archivo "HefestoSoftware.java".

¡¡IMPORTANTE!! Es necesario modificar la ruta establecida en el archivo persistence.xml localizado en la ruta:

	"SII-ACOES-HEFESTO_SOFTWARE/HefestoSoftware/src/META-INF/"

	Modificando la línea que aparece a continuación:

 "<property name="javax.persistence.schema-generation.scripts.create-target" value="/Users/ivan/Desktop/create.sql"/>""

 Estableciendo en value la ruta o directorio donde desea almacenar el fichero generado.

 
