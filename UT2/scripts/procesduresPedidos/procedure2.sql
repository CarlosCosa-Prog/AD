CREATE OR REPLACE PROCEDURE public.borracategorias2b(n int)
	LANGUAGE plpgsql
AS $procedure$
	BEGIN
		 DELETE FROM categorias2 WHERE categoriaid = n;
	END;
$procedure$
;

