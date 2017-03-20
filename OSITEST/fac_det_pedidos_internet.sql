/*===============================================================================
=====================             COMENTARIOS              ======================
=================================================================================

21/04/2016 XCQ Se adapta a las Best Practices (estadísticas tablas) y
               se añade el campo ind_accion_bopo
27/06/2016 AMR Se añade el campo cod_tpv
*/

DATABASE &bd_dim&;

REPLACE VIEW &bd_dwh&.DWH_DET_PEDIDOS_INTERNET_V AS
(
 SELECT *
   FROM &bd_dwh&.DWH_DET_PEDIDOS_INTERNET
  WHERE fec_fin_vigencia=CAST('21000101' AS DATE FORMAT 'YYYYMMDD')
);

REPLACE VIEW &bd_dwh&.DWH_DET_ACC_PED_INTERNET_V AS
(
 SELECT *
   FROM &bd_dwh&.DWH_DET_ACC_PED_INTERNET
  WHERE fec_fin_vigencia=CAST('21000101' AS DATE FORMAT 'YYYYMMDD')
);


REPLACE VIEW DWH_CAMBIO_DIVISA_V  AS
(
 SELECT *
   FROM DWH_CAMBIO_DIVISA
  WHERE fec_fin_vigencia = CAST('21000101' AS DATE FORMAT 'YYYYMMDD')
);

REPLACE VIEW DWH_TIPO_CAMBIO_V  AS
(
 SELECT *
   FROM DWH_TIPO_CAMBIO
  WHERE fec_fin_vigencia = CAST('21000101' AS DATE FORMAT 'YYYYMMDD')
);


REPLACE VIEW DWH_TIENDA_V AS
(
 SELECT *
   FROM DWH_TIENDA
  WHERE fec_fin_vigencia = CAST('21000101' AS DATE FORMAT 'YYYYMMDD')
);

-- Auxiliar para el cambio (Usado por FICH283 y FICH283B - cabecera y detalle- INSERT 1 y 2)

DROP TABLE dpit1FAC_DET_PEDIDOS_INTERNET;
CREATE MULTISET TABLE dpit1FAC_DET_PEDIDOS_INTERNET
AS (
        SELECT 
                a.id_divisa
               ,a.cod_divisa
               ,a.fecha_vigencia
               ,a.val_cambio
          FROM &bd_dwh&.DWH_CAMBIO_DIVISA_V a
    INNER JOIN &bd_dwh&.DWH_TIPO_CAMBIO b ON (a.id_tipo_cambio = b.id_tipo_cambio AND b.cod_tipo_cambio = 'H')
         WHERE  a.fecha_vigencia > CAST('20000101' AS DATE FORMAT 'YYYYMMDD')
) WITH DATA
PRIMARY INDEX (cod_divisa, fecha_vigencia);
.IF ERRORCODE <> 0 THEN .QUIT 4


--20130527 Mismo proceso que en la carga de FAC_PEDIDOS_INTERNET. 
-- Modificaciones para insertar todos los posibles cambios de divisas
-----------------------------------------------------------------------------------------------
--divisas a las que les falta el cambio para determinados días

DROP TABLE dpit4FAC_DET_PEDIDOS_INTERNET;
CREATE MULTISET TABLE dpit4FAC_DET_PEDIDOS_INTERNET
AS (
             SELECT  X.fec_dia
                    ,Y.id_divisa
	             FROM &bd_dwh&.DWH_DIA X 
		     CROSS JOIN (SELECT id_divisa FROM &bd_dwh&.DWH_CAMBIO_DIVISA WHERE fecha_vigencia <> '1900-01-01' GROUP BY 1) Y
		LEFT OUTER JOIN &bd_dwh&.DWH_CAMBIO_DIVISA_V A ON (Y.id_divisa = A.id_divisa AND X.fec_dia = A.fecha_vigencia )
		LEFT OUTER JOIN &bd_dwh&.DWH_TIPO_CAMBIO_V   b ON (a.id_tipo_cambio = b.id_tipo_cambio AND b.cod_tipo_cambio = 'H')
	            WHERE fec_dia > '2000-01-01'
		            AND A.fecha_vigencia IS NULL
		            AND  X.fec_dia <=CURRENT_DATE
) WITH DATA
PRIMARY INDEX (id_divisa,fec_dia);
.IF ERRORCODE <> 0 THEN .QUIT 4

COLLECT STATISTICS COLUMN(id_divisa,fec_dia) ON dpit4FAC_DET_PEDIDOS_INTERNET;
.IF ERRORCODE <> 0 THEN .QUIT 4

--Para estas divisas a las que no tenemos cambio asignado en algunos 
--días se lo buscamos como el inmediatamente anterior
INSERT INTO dpit1FAC_DET_PEDIDOS_INTERNET
     SELECT  X.id_divisa
            ,Y.cod_divisa
            ,X.fec_dia
            ,Y.val_cambio
       FROM 
			     (    SELECT  A.id_divisa
			                 ,A.fec_dia
			                 ,MAX(COALESCE(B.fecha_vigencia, CAST('2100-01-01' AS DATE FORMAT'YYYY-MM-DD'))) AS fecha_vigencia
			            FROM dpit4FAC_DET_PEDIDOS_INTERNET A
			      INNER JOIN &bd_dwh&.DWH_CAMBIO_DIVISA_V  B ON (A.id_divisa = B.id_divisa 
					         AND A.fec_dia >= B.fecha_vigencia
					  ) 
 INNER JOIN &bd_dwh&.DWH_TIPO_CAMBIO_V C ON (B.id_tipo_cambio = C.id_tipo_cambio AND C.cod_tipo_cambio = 'H')
 	GROUP BY 1, 2) X
	INNER JOIN &bd_dwh&.DWH_CAMBIO_DIVISA_V Y	ON (X.id_divisa = Y.id_divisa AND X.fecha_vigencia = Y.fecha_vigencia ) 
	INNER JOIN &bd_dwh&.DWH_TIPO_CAMBIO_V Z 	ON (Y.id_tipo_cambio = Z.id_tipo_cambio AND Z.cod_tipo_cambio = 'H');
.IF ERRORCODE <> 0 THEN .QUIT 4				

COLLECT STATISTICS COLUMN (cod_divisa,fecha_vigencia) ON dpit1FAC_DET_PEDIDOS_INTERNET;
.IF ERRORCODE <> 0 THEN .QUIT 4

--20120807 FRP Calculamos el stock en tienda para cada tienda en el item de la petición en el momento de la petición
--20150810 ICC Comentados porque parece que no se utilizan

-- Usado por FICH283 - cabecera- INSERT 1)

--DROP TABLE dpit2FAC_DET_PEDIDOS_INTERNET;
--CREATE MULTISET TABLE dpit2FAC_DET_PEDIDOS_INTERNET
--AS (
--      SELECT A.id_tienda, B.id_tienda AS id_tienda_compra, IT.id_item, A.id_pedidos_internet, SUM(C.val_acum) val_stock_VOTF
--        FROM FAC_PEDIDOS_INTERNET                 A
--	INNER JOIN &bd_dwh&.DWH_DET_PEDIDOS_INTERNET_V A2 ON (A2.id_pedidos_internet = A.id_pedidos_internet) 
--	INNER JOIN DIM_ITEMS                            IT ON (A2.id_item = IT.id_item) 
--	INNER JOIN &bd_dwh&.DWH_TIENDA_V                B  ON (A.cod_mol_tienda_compra = B.cod_tienda) 
--	INNER JOIN FAC_MOVIMIENTOS_ALMACEN              C  ON (B.id_tienda = C.id_destino AND IT.id_item = C.id_item AND IT.id_temporada = C.id_temporada_movimiento) 
--       WHERE A.cod_mol_tienda_compra <>'00000000' 	
--         AND C.fec_movimiento <= A.fec_pedido
--         AND C.id_temporada_movimiento >= 64
--    GROUP BY 1, 2, 3, 4
--) WITH DATA
--PRIMARY INDEX(id_tienda, id_tienda_compra, id_item, id_pedidos_internet);
--.IF ERRORCODE <> 0 THEN .QUIT 4
--
--COLLECT STATISTICS
--                   COLUMN (id_tienda,id_item,id_pedidos_internet),
--                   COLUMN (id_pedidos_internet)
--                ON dpit2FAC_DET_PEDIDOS_INTERNET;
--
---- Auxiliar tránsito (Usado por FICH283 - cabecera- INSERT 1)
--
--DROP TABLE dpit3FAC_DET_PEDIDOS_INTERNET;
--CREATE MULTISET TABLE dpit3FAC_DET_PEDIDOS_INTERNET AS
--(     SELECT A.id_tienda, B.id_tienda AS id_tienda_compra, IT.id_item, A.id_pedidos_internet, SUM(C.val_transito) AS val_transito
--        FROM FAC_PEDIDOS_INTERNET                 A
--  INNER JOIN &bd_dwh&.DWH_DET_PEDIDOS_INTERNET_V A2 ON (A2.id_pedidos_internet = A.id_pedidos_internet) 
--  INNER JOIN DIM_ITEMS                            IT ON (A2.id_item = IT.id_item) 
--  INNER JOIN &bd_dwh&.DWH_TIENDA_V                B ON (A.cod_mol_tienda_compra = B.cod_tienda) 
--  INNER JOIN FAC_INVENTARIO                       C ON (B.id_tienda = C.id_tienda AND IT.id_item = C.id_item AND IT.id_temporada = C.id_temporada_movimiento) 
--       WHERE A.cod_mol_tienda_compra <>'00000000' 	
--         AND C.fec_inicio_vigencia <= A.fec_pedido
--         AND C.fec_fin_vigencia >= A.fec_pedido
--         AND C.id_temporada_movimiento >= 64
--    GROUP BY 1, 2, 3, 4
--) WITH DATA
--PRIMARY INDEX(id_tienda, id_tienda_compra, id_item, id_pedidos_internet);
--.IF ERRORCODE <> 0 THEN .QUIT 4
--
--COLLECT STATISTICS
--                   COLUMN (id_tienda,id_item,id_pedidos_internet),
--                   COLUMN (id_pedidos_internet)                   
--                ON dpit3FAC_DET_PEDIDOS_INTERNET;
--
-- Auxiliar para la fecha de encajado (Usado por FICH283 - cabecera- INSERT 1)

DROP TABLE dpit5FAC_DET_PEDIDOS_INTERNET;
CREATE MULTISET TABLE dpit5FAC_DET_PEDIDOS_INTERNET AS
(
 SELECT DISTINCT id_pedidos_internet,fec_encajado
   FROM &bd_dwh&.DWH_DET_PEDIDOS_INTERNET_V
  WHERE TRIM(fec_encajado) IS NOT NULL
) WITH DATA
PRIMARY INDEX (id_pedidos_internet);
.IF ERRORCODE <> 0 THEN .QUIT 4

COLLECT STATISTICS COLUMN (id_pedidos_internet) ON dpit5FAC_DET_PEDIDOS_INTERNET;
.IF ERRORCODE <> 0 THEN .QUIT 4 

-- Creación de la tabla
DROP TABLE dmFAC_DET_PEDIDOS_INTERNET;
CREATE MULTISET TABLE dmFAC_DET_PEDIDOS_INTERNET,NO FALLBACK,
     NO BEFORE JOURNAL,
     NO AFTER JOURNAL,
     CHECKSUM = DEFAULT,
     DEFAULT MERGEBLOCKRATIO
     (
      id_tienda INTEGER,
      cod_pedido VARCHAR(8) CHARACTER SET LATIN NOT CASESPECIFIC,
      id_item INTEGER,
      id_pedidos_internet INTEGER,
      fec_dia DATE FORMAT 'YY/MM/DD',
      cod_divisa VARCHAR(2) CHARACTER SET LATIN NOT CASESPECIFIC,
      fec_pedido DATE FORMAT 'YY/MM/DD',
      ind_status_pedido CHAR(2) CHARACTER SET LATIN NOT CASESPECIFIC COMPRESS(' ','N','A','O','R','P','F','E','C'),
      val_total_unidades INTEGER,
      val_precio_unitario_div DECIMAL(15,3),
      val_precio_unitario_eur DECIMAL(15,3),
      ind_actualizado_stock VARCHAR(1) CHARACTER SET LATIN NOT CASESPECIFIC,
      des_observaciones VARCHAR(70) CHARACTER SET LATIN NOT CASESPECIFIC,
      fec_observ DATE FORMAT 'YY/MM/DD',
      val_tasas_div DECIMAL(6,3),
      val_tasas_eur DECIMAL(6,3),
      ind_outlet_usa CHAR(1) CHARACTER SET LATIN NOT CASESPECIFIC COMPRESS(' ','S','N'),
      val_importe_prorrateado DECIMAL(15,3),
      cod_almacen_distribucion CHAR(8) CHARACTER SET LATIN NOT CASESPECIFIC COMPRESS('00000000','        '),
      cod_modelo_origen CHAR(8) CHARACTER SET LATIN NOT CASESPECIFIC COMPRESS('        '),
      val_iva DECIMAL(5,2),
      precio_macys DECIMAL(14,3),
      ind_devolucion_diferida CHAR(1) CHARACTER SET LATIN NOT CASESPECIFIC COMPRESS('S',' '),
      val_unidades INTEGER,
      ind_accion CHAR(1) CHARACTER SET LATIN NOT CASESPECIFIC,
      ind_devolucion_diferida_acc CHAR(1) CHARACTER SET LATIN NOT CASESPECIFIC COMPRESS('S',' '),
      cod_talla_devolucion VARCHAR(2) CHARACTER SET LATIN NOT CASESPECIFIC,
      cod_color_devolucion CHAR(2) CHARACTER SET LATIN NOT CASESPECIFIC COMPRESS('  ','00'),
      cod_talla_cambio VARCHAR(2) CHARACTER SET LATIN NOT CASESPECIFIC,
      cod_color_cambio CHAR(2) CHARACTER SET LATIN NOT CASESPECIFIC COMPRESS('  ','00'),
      val_cantidad INTEGER,
      ind_motivo CHAR(1) CHARACTER SET LATIN NOT CASESPECIFIC COMPRESS(' ','Q','N','3','2','I','P','T','E'),
      fec_accion DATE FORMAT 'YY/MM/DD',
      cod_tiempo_accion VARCHAR(4) CHARACTER SET LATIN NOT CASESPECIFIC,
      val_reembolso_linea_div DECIMAL(15,3),
      val_reembolso_linea_eur DECIMAL(15,3),
      val_reembolso_trans_div DECIMAL(13,3),
      val_reembolso_trans_eur DECIMAL(13,3),
      cod_pedido_nuevo VARCHAR(8) CHARACTER SET LATIN NOT CASESPECIFIC,
      cod_abono VARCHAR(8) CHARACTER SET LATIN NOT CASESPECIFIC,
      ind_devolucion_impresa CHAR(1) CHARACTER SET LATIN NOT CASESPECIFIC COMPRESS(' ','N','S'),
      ind_actualizado_stock_t CHAR(1) CHARACTER SET LATIN NOT CASESPECIFIC COMPRESS(' ','N','S'),
      id_tienda_devolucion INTEGER,
      cod_tienda_devolucion VARCHAR(8) CHARACTER SET LATIN NOT CASESPECIFIC,
      des_tienda_devolucion VARCHAR(40) CHARACTER SET LATIN CASESPECIFIC,
      des_tipo_tienda_devolucion VARCHAR(7) CHARACTER SET UNICODE NOT CASESPECIFIC,
      fec_devolucion DATE FORMAT 'YY/MM/DD',
      num_ticket_dev_mol CHAR(8) CHARACTER SET LATIN NOT CASESPECIFIC,
      val_stock_VOTF INTEGER,
      val_stock_sin_trans_VOTF INTEGER,
      val_unidades_venta INTEGER,
      val_unidades_cambio INTEGER,
      val_unidades_devolucion INTEGER,
      val_unidades_anulacion INTEGER,
      pvp_div DECIMAL(15,3),
      pvp_eur DECIMAL(15,3),
      pvp_venta_div DECIMAL(15,3),
      pvp_venta_eur DECIMAL(15,3),
      ind_cabecera_acciones CHAR(1) COMPRESS('C','A'),
      val_cif_referencia DECIMAL(15,3),
      val_transporte_cif_referencia DECIMAL(15,3),
      val_seguro_referencia DECIMAL(15,3),
      ind_accion_bopo CHAR(1),
      cod_tpv VARCHAR(3) CHARACTER SET LATIN NOT CASESPECIFIC   
      )
PRIMARY INDEX (id_tienda,id_item,id_pedidos_internet,fec_accion);
.IF ERRORCODE <> 0 THEN .QUIT 4;

-- INSERT 1: Datos cabecera (FICH283)

INSERT INTO dmFAC_DET_PEDIDOS_INTERNET
    SELECT
    
    -- Cabecera FICH283
    
            a.id_tienda                                                                                  AS id_tienda
	         ,a.cod_pedido                                                                                 AS cod_pedido
	         ,a.id_item                                                                                    AS id_item
	         ,a.id_pedidos_internet                                                                        AS id_pedidos_internet
	         ,COALESCE(j.fec_encajado, a.fec_encajado)                                                     AS fec_dia
	         ,a.cod_divisa                                                                                 AS cod_divisa
	         ,a.fec_pedido                                                                                 AS fec_pedido --- Antes FEC_CAMBIO
	         ,a.ind_status_pedido                                                                          AS ind_status_pedido
	         ,a.val_total_unidades                                                                         AS val_total_unidades
	         ,a.val_precio_unitario                                                                        AS val_precio_unitario_div
	         ,CAST((a.val_precio_unitario*f.val_cambio) AS DECIMAL(15,3))                                  AS val_precio_unitario_eur
	         ,a.ind_actualizado_stock                                                                      AS ind_actualizado_stock
	         ,a.des_observaciones                                                                          AS des_observaciones
	         ,a.fec_observ                                                                                 AS fec_observ
	         ,a.val_tasas                                                                                  AS val_tasas_div
	         ,CAST((a.val_tasas*f.val_cambio) AS DECIMAL(6,3))                                             AS val_tasas_eur
	         ,a.ind_outlet_usa                                                                             AS ind_outlet_usa
	         ,a.val_importe_prorrateado                                                                    AS val_importe_prorrateado
	         ,a.cod_almacen_distribucion                                                                   AS cod_almacen_distribucion
 	         ,a.cod_modelo_origen                                                                          AS cod_modelo_origen
           ,a.val_iva/100                                                                                AS val_iva
           ,a.precio_Macys																																							 AS precio_macys
           ,a.ind_devolucion_diferida                                                                    AS ind_devolucion_diferida

     -- Campo común VAL_UNIDADES
     
           ,CASE
             WHEN a.ind_status_pedido = 'A'
             THEN 0
             ELSE a.val_total_unidades
            END                                                                                          AS val_unidades_n

     -- Detalle (FICH283B)
	         
	         ,''                                                                                           AS ind_accion
 	         ,' '                                                                                          AS ind_devolucion_diferida_acc
	         ,''                                                                                           AS cod_talla_devolucion
	         ,''                                                                                           AS cod_color_devolucion
	         ,''                                                                                           AS cod_talla_cambio
	         ,''                                                                                           AS cod_color_cambio
	         ,0                                                                                            AS val_cantidad
	         ,''                                                                                           AS ind_motivo
	         ,NULL                                                                                         AS fec_accion -- Antes FEC_CA
	         ,''                                                                                           AS cod_tiempo_accion -- Antes COD_TIEMPO
	         ,0                                                                                            AS val_reembolso_linea_div
	         ,0                                                                                            AS val_reembolso_linea_eur
	         ,0                                                                                            AS val_reembolso_trans_div
	         ,0                                                                                            AS val_reembolso_trans_eur
	         ,''                                                                                           AS cod_pedido_nuevo
	         ,''                                                                                           AS cod_abono
	         ,''                                                                                           AS ind_devolucion_impresa
	         ,''                                                                                           AS ind_actualizado_stock_t
	         ,-1                                                                                           AS id_tienda_devolucion
	         ,''                                                                                           AS cod_tienda_devolucion
	         ,''                                                                                           AS des_tienda_devolucion
	         ,''                                                                                           AS des_tipo_tienda_devolucion
      	   ,NULL                                                                                         AS fec_devolucion
	         ,''                                                                                           AS num_ticket_dev_mol
	         ,0 /*,COALESCE(g.val_stock_VOTF, 0)*/                                                         AS val_stock_VOTF
	         ,0 /*,COALESCE(g.val_stock_VOTF, 0)-COALESCE(h.val_transito,0)*/                              AS val_stock_sin_trans_VOTF
	         
      	   ,a.val_total_unidades                                                                         AS val_unidades_venta_n
           ,0    	                                                                                       AS val_unidades_cambio
           ,0     	                                                                                     AS val_unidades_devolucion
           ,CASE
             WHEN a.ind_status_pedido = 'A'
             THEN a.val_total_unidades
             ELSE 0
            END        	                                                                                 AS val_unidades_anulacion

           ,val_unidades_n       * a.val_precio_unitario                                                 AS pvp_div
           ,val_unidades_n       * CAST((a.val_precio_unitario*f.val_cambio) AS DECIMAL(15,3))           AS pvp_eur
           ,val_unidades_venta_n * a.val_precio_unitario                                                 AS pvp_venta_div
           ,val_unidades_venta_n * CAST((a.val_precio_unitario*f.val_cambio) AS DECIMAL(15,3))           AS pvp_venta_eur

           ,'C'                                                                                          AS ind_cabecera_acciones

           ,a.val_cif_referencia                                                                         AS val_cif_referencia
           ,a.val_transporte_cif_referencia                                                              AS val_transporte_cif_referencia
           ,a.val_seguro_referencia                                                                      AS val_seguro_referencia
           ,a.ind_accion_bopo                                                                            AS ind_accion_bopo
           ,a.cod_tpv                                                                                    AS cod_tpv              
      FROM &bd_dwh&.DWH_DET_PEDIDOS_INTERNET_V a
 LEFT JOIN dpit1FAC_DET_PEDIDOS_INTERNET        f ON (a.cod_divisa = f.cod_divisa AND a.fec_pedido = f.fecha_vigencia)   
 --LEFT JOIN dpit2FAC_DET_PEDIDOS_INTERNET        g ON (a.id_tienda = g.id_tienda AND a.id_pedidos_internet = g.id_pedidos_internet AND a.id_item = g.id_item) 
 --LEFT JOIN dpit3FAC_DET_PEDIDOS_INTERNET        h ON (a.id_tienda = h.id_tienda AND a.id_pedidos_internet = h.id_pedidos_internet AND a.id_item = h.id_item) 
 LEFT JOIN dpit5FAC_DET_PEDIDOS_INTERNET        j ON (a.id_pedidos_internet = j.id_pedidos_internet) 
;
.IF ERRORCODE <> 0 THEN .QUIT 4;


-- INSERT 2: Datos detalle (FICH283B) -- ANULACIONES

INSERT INTO dmFAC_DET_PEDIDOS_INTERNET
    SELECT

    -- Cabecera FICH283
    
            a.id_tienda                                                                                  AS id_tienda
	         ,a.cod_pedido                                                                                 AS cod_pedido
	         ,a.id_item                                                                                    AS id_item
	         ,a.id_pedidos_internet                                                                        AS id_pedidos_internet
	         ,COALESCE(j.fec_encajado, a.fec_encajado)                                                     AS fec_dia
	         ,a.cod_divisa                                                                                 AS cod_divisa
	         ,a.fec_pedido                                                                                 AS fec_pedido --- Antes FEC_CAMBIO
	         ,a.ind_status_pedido                                                                          AS ind_status_pedido
	         ,0                                                                                            AS val_total_unidades
	         ,a.val_precio_unitario                                                                        AS val_precio_unitario_div
	         ,CAST((a.val_precio_unitario*f.val_cambio) AS DECIMAL(15,3))                                  AS val_precio_unitario_eur
	         ,''                                                                                           AS ind_actualizado_stock
	         ,''                                                                                           AS des_observaciones
	         ,NULL                                                                                         AS fec_observ
	         ,0                                                                                            AS val_tasas_div
	         ,0                                                                                            AS val_tasas_eur
	         ,a.ind_outlet_usa                                                                             AS ind_outlet_usa
	         ,0                                                                                            AS val_importe_prorrateado
	         ,'        '                                                                                   AS cod_almacen_distribucion
 	         ,'        '                                                                                   AS cod_modelo_origen
           ,a.val_iva/100                                                                                AS val_iva
           ,0																																														 AS precio_macys
           ,' '												                                                                   AS ind_devolucion_diferida
     -- Campo común VAL_UNIDADES
     
           ,CASE
             WHEN a.ind_status_pedido = 'A' THEN 0
             WHEN c.ind_accion = 'A' THEN -ABS(c.val_cantidad)
             ELSE 0
            END                                                                                          AS val_unidades_n

     -- Detalle (FICH283B)
	         
	         ,c.ind_accion                                                                                 AS ind_accion
 	         ,c.ind_devolucion_diferida                                                                    AS ind_devolucion_diferida_acc
	         ,c.cod_talla_devolucion                                                                       AS cod_talla_devolucion
	         ,c.cod_color_devolucion                                                                       AS cod_color_devolucion
	         ,c.cod_talla_cambio                                                                           AS cod_talla_cambio
	         ,c.cod_color_cambio                                                                           AS cod_color_cambio
	         ,c.val_cantidad                                                                               AS val_cantidad
	         ,c.ind_motivo                                                                                 AS ind_motivo
	         ,c.fec_accion                                                                                 AS fec_accion -- Antes FEC_CA
	         ,c.tiempo_accion                                                                              AS cod_tiempo_accion -- Antes COD_TIEMPO
	         ,c.val_reembolso_linea                                                                        AS val_reembolso_linea_div
	         ,CAST((c.val_reembolso_linea*f.val_cambio) AS DECIMAL(15,3))                                  AS val_reembolso_linea_eur
	         ,c.val_reembolso_trans                                                                        AS val_reembolso_trans_div
	         ,CAST((c.val_reembolso_trans*f.val_cambio) AS DECIMAL(13,3))                                  AS val_reembolso_trans_eur
	         ,c.cod_pedido_nuevo                                                                           AS cod_pedido_nuevo
	         ,c.cod_abono                                                                                  AS cod_abono
	         ,c.ind_devolucion_impresa                                                                     AS ind_devolucion_impresa
	         ,c.ind_actualizado_stock_t                                                                    AS ind_actualizado_stock_t
	         ,c.id_tienda_devolucion                                                                       AS id_tienda_devolucion
	         ,b.cod_tienda_corto                                                                           AS cod_tienda_devolucion
	         ,b.des_tienda                                                                                 AS des_tienda_devolucion
	         ,CASE 
	           WHEN b.cod_tipo_tienda = 'L'            THEN 'Almacén' 
	           WHEN b.cod_tienda IN ('00011821','00010739','00010828','00010685','00010812') THEN 'Almacén'
	           WHEN c.id_tienda_devolucion IS NOT NULL THEN 'Tienda' 
	          END                                                                                          AS des_tipo_tienda_devolucion
      	   ,CASE WHEN c.ind_accion IS NOT NULL AND TRIM(c.ind_accion)<>'' THEN c.fec_devolucion END      AS fec_devolucion
	         ,CASE WHEN c.ind_accion IS NOT NULL AND TRIM(c.ind_accion)<>'' THEN c.num_ticket_dev_mol END  AS num_ticket_dev_mol
	         ,0                                                                                            AS val_stock_VOTF
	         ,0                                                                                            AS val_stock_sin_trans_VOTF
      	    
      	   ,0                                                                                            AS val_unidades_venta_n
           ,CASE WHEN c.ind_accion IN('C')    THEN ABS(c.val_cantidad) ELSE 0 END     	                 AS val_unidades_cambio
           ,CASE WHEN c.ind_accion IN('D')    THEN ABS(c.val_cantidad) ELSE 0 END     	                 AS val_unidades_devolucion
           ,CASE WHEN c.ind_accion IN('A')    THEN ABS(c.val_cantidad) ELSE 0 END     	                 AS val_unidades_anulacion

           ,val_unidades_n       * a.val_precio_unitario                                                 AS pvp_div
           ,val_unidades_n       * CAST((a.val_precio_unitario*f.val_cambio) AS DECIMAL(15,3))           AS pvp_eur
           ,val_unidades_venta_n * a.val_precio_unitario                                                 AS pvp_venta_div
           ,val_unidades_venta_n * CAST((a.val_precio_unitario*f.val_cambio) AS DECIMAL(15,3))           AS pvp_venta_eur

           ,'A'                                                                                          AS ind_cabecera_acciones
--20161006 FRP importes 0 para las aduanas en cambios y devoluciones           

           --,a.val_cif_referencia                                                                         AS val_cif_referencia
           --,a.val_transporte_cif_referencia                                                              AS val_transporte_cif_referencia
           --,a.val_seguro_referencia                                                                      AS val_seguro_referencia

           ,0                                                                         										AS val_cif_referencia
           ,0                                                              																AS val_transporte_cif_referencia
           ,0                                                                      												AS val_seguro_referencia
           ,a.ind_accion_bopo                                                                            AS ind_accion_bopo
           ,a.cod_tpv                                                                                    AS cod_tpv   
      FROM &bd_dwh&.DWH_DET_PEDIDOS_INTERNET_V  a
INNER JOIN &bd_dwh&.DWH_DET_ACC_PED_INTERNET_V  c ON (a.id_tienda = c.id_tienda AND a.cod_pedido = c.cod_pedido AND a.id_item = c.id_item)
 LEFT JOIN &bd_dwh&.DWH_TIENDA_VM               b ON (c.id_tienda_devolucion = b.id_tienda)
 LEFT JOIN dpit1FAC_DET_PEDIDOS_INTERNET        f ON (a.cod_divisa = f.cod_divisa AND a.fec_pedido = f.fecha_vigencia)   
 LEFT JOIN dpit5FAC_DET_PEDIDOS_INTERNET        j ON (a.id_pedidos_internet = j.id_pedidos_internet)
     WHERE c.ind_accion IN('','A')
;
.IF ERRORCODE <> 0 THEN .QUIT 4;

-- INSERT 3: Datos detalle (FICH283B) -- DEVOLUCIONES

INSERT INTO dmFAC_DET_PEDIDOS_INTERNET
    SELECT

    -- Cabecera FICH283
    
            a.id_tienda                                                                                  AS id_tienda
	         ,a.cod_pedido                                                                                 AS cod_pedido
	         ,a.id_item                                                                                    AS id_item
	         ,a.id_pedidos_internet                                                                        AS id_pedidos_internet
	         ,COALESCE(j.fec_encajado, a.fec_encajado)                                                     AS fec_dia
	         ,a.cod_divisa                                                                                 AS cod_divisa
	         ,a.fec_pedido                                                                                 AS fec_pedido --- Antes FEC_CAMBIO
	         ,a.ind_status_pedido                                                                          AS ind_status_pedido
	         ,0                                                                                            AS val_total_unidades
	         ,a.val_precio_unitario                                                                        AS val_precio_unitario_div
	         ,CAST((a.val_precio_unitario*f.val_cambio) AS DECIMAL(15,3))                                  AS val_precio_unitario_eur
	         ,''                                                                                           AS ind_actualizado_stock
	         ,''                                                                                           AS des_observaciones
	         ,NULL                                                                                         AS fec_observ
	         ,0                                                                                            AS val_tasas_div
	         ,0                                                                                            AS val_tasas_eur
	         ,a.ind_outlet_usa                                                                             AS ind_outlet_usa
	         ,0                                                                                            AS val_importe_prorrateado
	         ,'        '                                                                                   AS cod_almacen_distribucion
 	         ,'        '                                                                                   AS cod_modelo_origen
           ,a.val_iva/100                                                                                AS val_iva
           ,a.precio_Macys																																							 AS precio_Macys
           ,' '												                                                                   AS ind_devolucion_diferida
     -- Campo común VAL_UNIDADES
     
           ,CASE
             WHEN a.ind_status_pedido = 'A' THEN 0
             ELSE -ABS(c.val_cantidad)
            END                                                                                          AS val_unidades_n

     -- Detalle (FICH283B)
	         
	         ,c.ind_accion                                                                                 AS ind_accion
	         ,c.ind_devolucion_diferida                                                                    AS ind_devolucion_diferida_acc
	         ,c.cod_talla_devolucion                                                                       AS cod_talla_devolucion
	         ,c.cod_color_devolucion                                                                       AS cod_color_devolucion
	         ,c.cod_talla_cambio                                                                           AS cod_talla_cambio
	         ,c.cod_color_cambio                                                                           AS cod_color_cambio
	         ,c.val_cantidad                                                                               AS val_cantidad
	         ,c.ind_motivo                                                                                 AS ind_motivo
	         ,c.fec_accion                                                                                 AS fec_accion -- Antes FEC_CA
	         ,c.tiempo_accion                                                                              AS cod_tiempo_accion -- Antes COD_TIEMPO
	         ,c.val_reembolso_linea                                                                        AS val_reembolso_linea_div
	         ,CAST((c.val_reembolso_linea*f.val_cambio) AS DECIMAL(15,3))                                  AS val_reembolso_linea_eur
	         ,c.val_reembolso_trans                                                                        AS val_reembolso_trans_div
	         ,CAST((c.val_reembolso_trans*f.val_cambio) AS DECIMAL(13,3))                                  AS val_reembolso_trans_eur
	         ,c.cod_pedido_nuevo                                                                           AS cod_pedido_nuevo
	         ,c.cod_abono                                                                                  AS cod_abono
	         ,c.ind_devolucion_impresa                                                                     AS ind_devolucion_impresa
	         ,c.ind_actualizado_stock_t                                                                    AS ind_actualizado_stock_t
	         ,c.id_tienda_devolucion                                                                       AS id_tienda_devolucion
	         ,b.cod_tienda_corto                                                                           AS cod_tienda_devolucion
	         ,b.des_tienda                                                                                 AS des_tienda_devolucion
	         ,CASE 
	           WHEN b.cod_tipo_tienda = 'L'            THEN 'Almacén' 
	           WHEN b.cod_tienda IN ('00011821','00010739','00010828','00010685','00010812') THEN 'Almacén'
	           WHEN c.id_tienda_devolucion IS NOT NULL THEN 'Tienda' 
	          END                                                                                          AS des_tipo_tienda_devolucion
      	   ,CASE WHEN c.ind_accion IS NOT NULL AND TRIM(c.ind_accion)<>'' THEN c.fec_devolucion END      AS fec_devolucion
	         ,CASE WHEN c.ind_accion IS NOT NULL AND TRIM(c.ind_accion)<>'' THEN c.num_ticket_dev_mol END  AS num_ticket_dev_mol
	         ,0                                                                                            AS val_stock_VOTF
	         ,0                                                                                            AS val_stock_sin_trans_VOTF
      	    
      	   ,0                                                                                            AS val_unidades_venta_n
           ,CASE WHEN c.ind_accion IN('C')    THEN ABS(c.val_cantidad) ELSE 0 END     	                 AS val_unidades_cambio
           ,CASE WHEN c.ind_accion IN('D')    THEN ABS(c.val_cantidad) ELSE 0 END     	                 AS val_unidades_devolucion
           ,CASE WHEN c.ind_accion IN('A')    THEN ABS(c.val_cantidad) ELSE 0 END     	                 AS val_unidades_anulacion

           ,val_unidades_n       * a.val_precio_unitario                                                 AS pvp_div
           ,val_unidades_n       * CAST((a.val_precio_unitario*f.val_cambio) AS DECIMAL(15,3))           AS pvp_eur
           ,val_unidades_venta_n * a.val_precio_unitario                                                 AS pvp_venta_div
           ,val_unidades_venta_n * CAST((a.val_precio_unitario*f.val_cambio) AS DECIMAL(15,3))           AS pvp_venta_eur

           ,'A'                                                                                          AS ind_cabecera_acciones

--20161006 FRP importes 0 para las aduanas en cambios y devoluciones           
           --,a.val_cif_referencia                                                                         AS val_cif_referencia
           --,a.val_transporte_cif_referencia                                                              AS val_transporte_cif_referencia
           --,a.val_seguro_referencia                                                                      AS val_seguro_referencia
           ,0																																															AS val_cif_referencia
           ,0																																															AS val_transporte_cif_referencia	
           ,0																																															AS val_seguro_referencia
           ,a.ind_accion_bopo                                                                            AS ind_accion_bopo
           ,a.cod_tpv                                                                                    AS cod_tpv   
      FROM &bd_dwh&.DWH_DET_PEDIDOS_INTERNET_V  a
INNER JOIN &bd_dwh&.DWH_DET_ACC_PED_INTERNET_V  c ON (a.id_tienda = c.id_tienda AND a.cod_pedido = c.cod_pedido AND a.id_item = c.id_item)
 LEFT JOIN &bd_dwh&.DWH_TIENDA_VM               b ON (c.id_tienda_devolucion = b.id_tienda)
 LEFT JOIN dpit1FAC_DET_PEDIDOS_INTERNET        f ON (a.cod_divisa = f.cod_divisa AND a.fec_pedido = f.fecha_vigencia)   
 LEFT JOIN dpit5FAC_DET_PEDIDOS_INTERNET        j ON (a.id_pedidos_internet = j.id_pedidos_internet)
      WHERE c.ind_accion = 'D'
;
.IF ERRORCODE <> 0 THEN .QUIT 4;

DROP TABLE preFAC_DET_PEDIDOS_INTERNET;
CREATE MULTISET TABLE preFAC_DET_PEDIDOS_INTERNET
AS
(
   SELECT id_tienda, cod_pedido, id_item, SUM(val_unidades) AS val_unidades
     FROM dmFAC_DET_PEDIDOS_INTERNET
 GROUP BY 1,2,3

) WITH DATA
UNIQUE PRIMARY INDEX(id_tienda, cod_pedido, id_item);
.IF ERRORCODE <> 0 THEN .QUIT 4;

COLLECT STATISTICS COLUMN (id_tienda, cod_pedido, id_item) ON preFAC_DET_PEDIDOS_INTERNET;
.IF ERRORCODE <> 0 THEN .QUIT 4



-- INSERT 4: Datos detalle (FICH283B) -- CAMBIOS

INSERT INTO dmFAC_DET_PEDIDOS_INTERNET
    SELECT

    -- Cabecera FICH283
    
            a.id_tienda                                                                                  AS id_tienda
	         ,a.cod_pedido                                                                                 AS cod_pedido
	         ,a.id_item                                                                                    AS id_item
	         ,a.id_pedidos_internet                                                                        AS id_pedidos_internet
	         ,COALESCE(j.fec_encajado, a.fec_encajado)                                                     AS fec_dia
	         ,a.cod_divisa                                                                                 AS cod_divisa
	         ,a.fec_pedido                                                                                 AS fec_pedido --- Antes FEC_CAMBIO
	         ,a.ind_status_pedido                                                                          AS ind_status_pedido
	         ,0                                                                                            AS val_total_unidades
	         ,a.val_precio_unitario                                                                        AS val_precio_unitario_div
	         ,CAST((a.val_precio_unitario*f.val_cambio) AS DECIMAL(15,3))                                  AS val_precio_unitario_eur
	         ,''                                                                                           AS ind_actualizado_stock
	         ,''                                                                                           AS des_observaciones
	         ,NULL                                                                                         AS fec_observ
	         ,0                                                                                            AS val_tasas_div
	         ,0                                                                                            AS val_tasas_eur
	         ,a.ind_outlet_usa                                                                             AS ind_outlet_usa
	         ,0                                                                                            AS val_importe_prorrateado
	         ,'        '                                                                                   AS cod_almacen_distribucion
 	         ,'        '                                                                                   AS cod_modelo_origen
           ,a.val_iva/100                                                                                AS val_iva
           ,0																																														 AS precio_macys
           ,' '												                                                                   AS ind_devolucion_diferida

     -- Campo común VAL_UNIDADES
     
           ,CASE
             WHEN a.ind_status_pedido = 'A' THEN 0
             WHEN z.val_unidades <1 THEN 0
             WHEN z.val_unidades >0 THEN -ABS(c.val_cantidad)
             ELSE 0
            END                                                                                          AS val_unidades_n

     -- Detalle (FICH283B)
	         
	         ,c.ind_accion                                                                                 AS ind_accion
	         ,c.ind_devolucion_diferida                                                                    AS ind_devolucion_diferida_acc
	         ,c.cod_talla_devolucion                                                                       AS cod_talla_devolucion
	         ,c.cod_color_devolucion                                                                       AS cod_color_devolucion
	         ,c.cod_talla_cambio                                                                           AS cod_talla_cambio
	         ,c.cod_color_cambio                                                                           AS cod_color_cambio
	         ,c.val_cantidad                                                                               AS val_cantidad
	         ,c.ind_motivo                                                                                 AS ind_motivo
	         ,c.fec_accion                                                                                 AS fec_accion -- Antes FEC_CA
	         ,c.tiempo_accion                                                                              AS cod_tiempo_accion -- Antes COD_TIEMPO
	         ,c.val_reembolso_linea                                                                        AS val_reembolso_linea_div
	         ,CAST((c.val_reembolso_linea*f.val_cambio) AS DECIMAL(15,3))                                  AS val_reembolso_linea_eur
	         ,c.val_reembolso_trans                                                                        AS val_reembolso_trans_div
	         ,CAST((c.val_reembolso_trans*f.val_cambio) AS DECIMAL(13,3))                                  AS val_reembolso_trans_eur
	         ,c.cod_pedido_nuevo                                                                           AS cod_pedido_nuevo
	         ,c.cod_abono                                                                                  AS cod_abono
	         ,c.ind_devolucion_impresa                                                                     AS ind_devolucion_impresa
	         ,c.ind_actualizado_stock_t                                                                    AS ind_actualizado_stock_t
	         ,c.id_tienda_devolucion                                                                       AS id_tienda_devolucion
	         ,b.cod_tienda_corto                                                                           AS cod_tienda_devolucion
	         ,b.des_tienda                                                                                 AS des_tienda_devolucion
	         ,CASE 
	           WHEN b.cod_tipo_tienda = 'L'            THEN 'Almacén' 
	           WHEN b.cod_tienda IN ('00011821','00010739','00010828','00010685','00010812') THEN 'Almacén'
	           WHEN c.id_tienda_devolucion IS NOT NULL THEN 'Tienda' 
	          END                                                                                          AS des_tipo_tienda_devolucion
      	   ,CASE WHEN c.ind_accion IS NOT NULL AND TRIM(c.ind_accion)<>'' THEN c.fec_devolucion END      AS fec_devolucion
	         ,CASE WHEN c.ind_accion IS NOT NULL AND TRIM(c.ind_accion)<>'' THEN c.num_ticket_dev_mol END  AS num_ticket_dev_mol
	         ,0                                                                                            AS val_stock_VOTF
	         ,0                                                                                            AS val_stock_sin_trans_VOTF
      	    
      	   ,0                                                                                            AS val_unidades_venta_n
           ,CASE WHEN c.ind_accion IN('C')    THEN ABS(c.val_cantidad) ELSE 0 END     	                 AS val_unidades_cambio
           ,CASE WHEN c.ind_accion IN('D')    THEN ABS(c.val_cantidad) ELSE 0 END     	                 AS val_unidades_devolucion
           ,CASE WHEN c.ind_accion IN('A')    THEN ABS(c.val_cantidad) ELSE 0 END     	                 AS val_unidades_anulacion

           ,val_unidades_n       * a.val_precio_unitario                                                 AS pvp_div
           ,val_unidades_n       * CAST((a.val_precio_unitario*f.val_cambio) AS DECIMAL(15,3))           AS pvp_eur
           ,val_unidades_venta_n * a.val_precio_unitario                                                 AS pvp_venta_div
           ,val_unidades_venta_n * CAST((a.val_precio_unitario*f.val_cambio) AS DECIMAL(15,3))           AS pvp_venta_eur

           ,'A'                                                                                          AS ind_cabecera_acciones

           --20161006 FRP importes 0 para las aduanas en cambios y devoluciones           
           --,a.val_cif_referencia                                                                         AS val_cif_referencia
           --,a.val_transporte_cif_referencia                                                              AS val_transporte_cif_referencia
           --,a.val_seguro_referencia                                                                      AS val_seguro_referencia
           ,0																																															AS val_cif_referencia
           ,0																																															AS val_transporte_cif_referencia	
           ,0																																															AS val_seguro_referencia
           ,a.ind_accion_bopo                                                                            AS ind_accion_bopo
           ,a.cod_tpv                                                                                    AS cod_tpv   
      FROM &bd_dwh&.DWH_DET_PEDIDOS_INTERNET_V  a
INNER JOIN &bd_dwh&.DWH_DET_ACC_PED_INTERNET_V  c ON (a.id_tienda = c.id_tienda AND a.cod_pedido = c.cod_pedido AND a.id_item = c.id_item)
 LEFT JOIN &bd_dwh&.DWH_TIENDA_VM               b ON (c.id_tienda_devolucion = b.id_tienda)
 LEFT JOIN dpit1FAC_DET_PEDIDOS_INTERNET        f ON (a.cod_divisa = f.cod_divisa AND a.fec_pedido = f.fecha_vigencia)   
 LEFT JOIN dpit5FAC_DET_PEDIDOS_INTERNET        j ON (a.id_pedidos_internet = j.id_pedidos_internet)
 LEFT JOIN preFAC_DET_PEDIDOS_INTERNET          z ON (a.id_tienda = z.id_tienda AND a.cod_pedido = z.cod_pedido AND a.id_item = z.id_item)
     WHERE c.ind_accion = 'C'
;
.IF ERRORCODE <> 0 THEN .QUIT 4;




COLLECT STATISTICS COLUMN (id_tienda,id_item,id_pedidos_internet,fec_accion) ON dmFAC_DET_PEDIDOS_INTERNET;
.IF ERRORCODE <> 0 THEN .QUIT 7;

DROP TABLE oldFAC_DET_PEDIDOS_INTERNET;
RENAME TABLE FAC_DET_PEDIDOS_INTERNET AS oldFAC_DET_PEDIDOS_INTERNET;
RENAME TABLE dmFAC_DET_PEDIDOS_INTERNET AS FAC_DET_PEDIDOS_INTERNET;
.IF ERRORCODE<>0 THEN .QUIT 7

DROP TABLE oldFAC_DET_PEDIDOS_INTERNET;

DROP TABLE &bd_dim&.REL_DET_PEDIDOS_INTERNET;
CREATE MULTISET TABLE &bd_dim&.REL_DET_PEDIDOS_INTERNET,NO FALLBACK ,
     NO BEFORE JOURNAL,
     NO AFTER JOURNAL,
     CHECKSUM = DEFAULT,
     DEFAULT MERGEBLOCKRATIO
     (
      id_tienda INTEGER NOT NULL,
      cod_pedido VARCHAR(8) CHARACTER SET LATIN NOT CASESPECIFIC NOT NULL,
      id_item INTEGER NOT NULL,
      id_pedidos_internet INTEGER NOT NULL,
      ind_outlet_internet CHAR(1) CHARACTER SET LATIN NOT CASESPECIFIC NOT NULL
      )
UNIQUE PRIMARY INDEX (id_tienda,id_item,id_pedidos_internet);
.IF ERRORCODE <> 0 THEN .QUIT 4

INSERT INTO &bd_dim&.REL_DET_PEDIDOS_INTERNET
    SELECT
           id_tienda
          ,cod_pedido
          ,id_item
          ,id_pedidos_internet
          ,MAX(ind_outlet_usa) AS ind_outlet_internet
     FROM FAC_DET_PEDIDOS_INTERNET
 GROUP BY 1,2,3,4;
.IF ERRORCODE <> 0 THEN .QUIT 4

COLLECT STATISTICS COLUMN (id_tienda,id_item,id_pedidos_internet) ON &bd_dim&.REL_DET_PEDIDOS_INTERNET;
.IF ERRORCODE <> 0 THEN .QUIT 5

DROP TABLE  dpit1FAC_DET_PEDIDOS_INTERNET;
DROP TABLE  dpit2FAC_DET_PEDIDOS_INTERNET; 
DROP TABLE  dpit3FAC_DET_PEDIDOS_INTERNET; 
DROP TABLE  dpit4FAC_DET_PEDIDOS_INTERNET; 
DROP TABLE  dpit5FAC_DET_PEDIDOS_INTERNET;

DROP TABLE preFAC_DET_PEDIDOS_INTERNET;

.QUIT 0
