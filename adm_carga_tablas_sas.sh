
# ---------------------------- DEFINICION VARIALES (INICIO) ----------------------------------
PAPELERA=/dev/null

ENTORNO=${perfil}
SCRIPTS=${HOME}
LOGS=../LOGS
DATOS=../../INTERCAMBIOS
DATOS_CONFIG=${DATOS}/CONFIG
DATOS_TMP=${DATOS}/TMP
DATOS_LOG=${DATOS}/LOG
DATOS_FICH=${DATOS}/SCM
HORA_INI=`date +%x-%X`
HORA=`date +%x-%X`
SUFIJO=`date '+%Y%m%d%H%M%S'`
OK=1

if [ $# -eq 0 ]; then
	 FECHA_CARGA=`date --date= +%Y%m%d`
else
   FECHA_CARGA=$1
fi	 

# ---------------------------- DEFINICION VARIALES (FIN) ----------------------------------

# ---------------------------- DEFINICION FUNCIONES  ----------------------------------

HORA=`date +%x-%X`
func_exportar_fecha_carga()
{
   rm ${DATOS_TMP}/fecha_carga_sas.txt -f
   # averiguar la fecha que toca cargar
   RUNTD${ENTORNO} fastexport_fecha_carga_sas.fex 19000101

   if [ -s ${DATOS_TMP}/fecha_carga_sas.txt ] ; then
     FECHA_CARGA=`cat ${DATOS_TMP}/fecha_carga_sas.txt|awk '{print $1}'`
   else
     echo "No existe el fichero ${DATOS_TMP}/fecha_carga_sas.txt - NO SE QUE FECHA CARGAR\n"
     exit 3
   fi
}

func_exportar_procesos_carga()
{
   rm ${DATOS_TMP}/procesos_sas.txt -f
   #obtener la lista de procesos activos de ejecucion diaria
   RUNTD${ENTORNO} fastexport_procesos_sas.fex 19000101

   if [ -s ${DATOS_TMP}/procesos_sas.txt ]; then
     echo "Se ha generado ${DATOS_TMP}/procesos_sas.txt"
   else
     echo "No existe el fichero ${DATOS_TMP}/procesos_sas.txt - NO SE QUE PROCESOS CARGAR"
     exit 4
   fi

}

func_envia_email()	
{
   #PARAMETRO	
	 TEXTO=$1
	 #envia mail final
   for USUARIO in `cat ../../INTERCAMBIOS/CONFIG/email_admin_dwh_sas.txt`
   do
   		 cat ${DATOS_TMP}/"carga_diurna_sas_ ${SUFIJO}.txt" | mailx -s "${TEXTO}" ${USUARIO}   
	 done
	}
	
func_envia_email_final()	
{
   #PARAMETRO	
	 TEXTO=$1
	 #envia mail final
   
   	 
	 for USUARIO in `cat ../../INTERCAMBIOS/CONFIG/email_admin_dwh_sas.txt`
   do
   	  cat "" | mailx -s "${TEXTO}" ${USUARIO}   
	 done
	 
	}
# ---------------------------- DEFINICION FUNCIONES (FIN)  ----------------------------------

# ---------------------------- INICIO------------------------ ----------------------------------
cd ${SCRIPTS}

   func_exportar_fecha_carga
   func_exportar_procesos_carga
     
   for PROCESO in `cat ../../INTERCAMBIOS/TMP/procesos_sas.txt`
   
   do    	
   		RUNTD${ENTORNO} ${PROCESO} ${FECHA_CARGA}   
   		codigo=$?
   		#HORA=`date +%x-%X`
   		HORA=`date '+%x - %R'`
   		#controlo el error
   		if [ ${codigo} -gt 1 ]; then
   			echo "  ERROR EN ${PROCESO} ${HORA}" >> ${DATOS_TMP}/"carga_diurna_sas_ ${SUFIJO}.txt"
   			func_envia_email "  ERROR EN ${PROCESO} ${HORA}"
   			OK=0
   		else   			
   			echo "  >>>>>>>>Ejecutado OK ${PROCESO} ${HORA}" >> ${DATOS_TMP}/"carga_diurna_sas_ ${SUFIJO}.txt"   			
   		fi 
  
  #Paramos la ejecución de todas las ls si falla una
  if [ -f ./stop_SAS.txt ]; then
      echo "Fichero stop_SAS.txt encontrado. Ultimo script ejecutado: ${PROCESO}" > ${DATOS_TMP}/mensaje_error.txt
      ${SCRIPTS}/envia_email.sh ${DATOS_TMP}/mensaje_error.txt "Se ha interrumpido la carga de TABLAS SAS ${FECHA_CARGA}" ${DATOS_CONFIG}/${ENTORNO}/email_warnings.txt
      rm -f ./stop_SAS.txt
      break
  fi   		
   		  	
   done
     
   OK=1   	
   
   #borro el fichero de apoyo,ya que queda escrito en el log 
	 rm -f ${DATOS_TMP}/"carga_diurna_sas_ ${SUFIJO}.txt"
#fi


exit
# ---------------------------- EJECUCION (FIN) ----------------------------------

