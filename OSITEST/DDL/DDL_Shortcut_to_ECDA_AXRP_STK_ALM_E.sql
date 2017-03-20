CREATE TABLE Shortcut_to_ECDA_AXRP_STK_ALM_E( 
TIPO_PRODUCTO nchar(1),
MODELO nchar(4),
CALIDAD nchar(3),
COLOR nchar(3),
TALLA nchar(2),
COD_ALMACEN_ECOMMERCE nvarchar2(40),
CANTIDAD_TRANSITO number(p,s)(10),
CANTIDAD_DISPONIBLE number(p,s)(10),
FECHA_CARGA date(19),
ORIGEN number(p,s)(6),
CANTIDAD_PENDIENTE number(p,s)(11)
);
