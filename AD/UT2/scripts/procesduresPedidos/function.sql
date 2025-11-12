CREATE OR REPLACE FUNCTION public.cuentaproductos()
RETURNS int
	LANGUAGE plpgsql
as $$
declare
   contador integer;
	BEGIN
		select count(*) into contador from productos;
        return contador;
	END;
$$;
