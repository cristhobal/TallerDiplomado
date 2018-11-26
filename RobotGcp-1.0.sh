#### ******************************************************************************
####  Proyecto 	    :Nimbus
####
####  Archivo       : RobotMail-1.0.sh
####  Description   : Ejecuta envío de correo con evaluaciones GCP
####
####  Creado        : 201708001Zenta Group. 
####  Modificaciones:
####
####  Copyright(c) 2017, LATAM.
#### ******************************************************************************
####set -xv


####set -x
####**********************************************************************#
####    VARIABLES DEL PROCESO                                             #
####**********************************************************************#
#. LoadDictTransferPrice-1.0/config/VariablesGlobales.sh
#DESARROLLO
. /app/PAX/srvrcclcn/LoadDictTransferPrice-1.0/config/VariablesGlobales.sh
#BETA
#. /app/PAX/srvltci/ReportsRobotBag-1.0/config/VariablesGlobales.sh
#PRODUCCION
#. /app/PAX/srvltci/ReportsRobotBag-1.0/config/VariablesGlobales.sh

####*********************************************************************#
####                 VARIABLES   DE  AMBIENTE                            #
####*********************************************************************#
cd $ROBOT_HOME

FRAMEWORK_LIB=$ROBOT_HOME/lib
CLASSPATH=$FRAMEWORK_LIB/wlclient.jar:\
$FRAMEWORK_LIB/slf4j-log4j12-1.7.2.jar:\
$FRAMEWORK_LIB/slf4j-api-1.7.2.jar:\
$FRAMEWORK_LIB/ojdbc6.jar:\
$FRAMEWORK_LIB/mybatis-3.2.6.jar:\
$FRAMEWORK_LIB/mail.jar:\
$FRAMEWORK_LIB/log4j-1.2.17.jar:\
$FRAMEWORK_LIB/LanchileUtils.jar:\
$FRAMEWORK_LIB/jmxtools.jar:\
$FRAMEWORK_LIB/jmxri.jar:\
$FRAMEWORK_LIB/FrameworkBatch.jar:\
$FRAMEWORK_LIB/dom4j-1.6.jar:\
$FRAMEWORK_LIB/commons-net-2.2.jar:\
$FRAMEWORK_LIB/commons-email-1.0.jar:\
\
classes:$ROBOT_HOME/dist/LoadDictTransferPrice-1.0.jar/:\
$ROBOT_HOME/config


############# Inicio del proceso Shell ####################
$JAVA_HOME/bin/java -cp $CLASSPATH com.latam.pax.nimbus.process.wrapper.WrapperLoadDictTP $1 $2
_RETURN=$? 

#### Fin del proceso
if [ $_RETURN -eq 0 ]
then
	echo "Proceso finalizado correctamente"
	exit 0
else
	echo "Proceso finalizado con error"
	exit $_RETURN
fi

