CREATE OR REPLACE PROCEDURE public.borracategorias2()
	LANGUAGE plpgsql
AS $procedure$
	BEGIN
		 DELETE FROM categorias2 WHERE categoriaid = 700;
	END;
$procedure$
;

