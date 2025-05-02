package dao;

import UI.Notify;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Cleanup;
import model.Cliente;
import model.Dispositivo;
import model.Filter;
import static model.Filter.DATE;
import static model.Filter.DATE_ENTREGADO;
import static model.Filter.TECNICO;
import static model.Filter.iD_CLIENTE;
import model.Gastos;
import model.Nota;
import model.NotaEtiqueta;
import model.NotaFilter;
import model.Tecnico;
import print.DispositivoAndNota;

public class BaseInkacells {

    public static Connection connection = Conexion.conectarMySQL();

    public static int addClienteBD(Cliente cliente) {
        int generatedId = -1;
        try {
            @Cleanup
            PreparedStatement ps = null;
            @Cleanup
            ResultSet rs = null;
            String scriptCliente = "insert into CLIENTE(nombre,domicilio,telefono_movil,telefono_fijo) values(?,?,?,?)";
            System.out.println(cliente.toString());
            ps = connection.prepareStatement(scriptCliente, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDomicilio());
            ps.setString(3, cliente.getMovil());
            ps.setString(4, cliente.getFijo());
            int filasInsertadas = ps.executeUpdate();

            if (filasInsertadas > 0) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
            }
            return generatedId;

        } catch (SQLException ex) {
            Notify.NotifyError("\"La base de Datos no pudo agregar al Cliente\n Exepcion: " + ex.getSQLState());
        }
        return generatedId;
    }

    public static int addTecnicoBD(Tecnico tecnico) {
        int generatedId = -1;
        try {
            @Cleanup
            PreparedStatement ps = null;
            @Cleanup
            ResultSet rs = null;
            String scriptTecnico = "insert into TECNICO(nombre) values(?)";
            System.out.println(tecnico.toString());
            ps = connection.prepareStatement(scriptTecnico, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tecnico.getNombre());

            var filasInsertadas = ps.executeUpdate();

            if (filasInsertadas > 0) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
            }
            return generatedId;

        } catch (SQLException ex) {
            Notify.NotifyError("La base de Datos no pudo agregar al Tecnico\n Exepcion: " + ex.getSQLState());
        }
        return generatedId;
    }

    public static int addDispositivoBD(Dispositivo dispositivo, int idCliente) {
        int generatedId = -1;
        try {

            @Cleanup
            PreparedStatement ps = null;
            @Cleanup
            ResultSet rs = null;
            String scriptDispositivo = "insert into DISPOSITIVO(name_dispositivo,marca,modelo,imei_serial,reparacion,observacion,CLIENTE_idCLIENTE) values(?,?,?,?,?,?,?)";
            ps = connection.prepareStatement(scriptDispositivo, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dispositivo.getDispositivo());
            ps.setString(2, dispositivo.getMarca());
            ps.setString(3, dispositivo.getModelo());
            ps.setString(4, dispositivo.getImei_serial());
            ps.setString(5, dispositivo.getReparacion());
            ps.setString(6, dispositivo.getObservacion());
            ps.setInt(7, idCliente);

            var filasInsertadas = ps.executeUpdate();

            if (filasInsertadas > 0) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
            }
            return generatedId;

        } catch (SQLException ex) {
            Logger.getLogger(BaseInkacells.class.getName()).log(Level.SEVERE, null, ex);
            Notify.NotifyError("La base de Datos no pudo agregar al Dispositivo\n Exepcion: " + ex.getSQLState());
        }
        return generatedId;
    }

    public static boolean addNotaBD(Nota nota, int idDispositivo, int idTecnico) {
        boolean resp = false;
        try {

            @Cleanup
            PreparedStatement ps = null;
            String scriptid_Reparacion = "insert into NOTA(statusR,entregado,precio,abono,fecha_recibido,hora_recibido,fecha_entregado,DISPOSITIVO_id_Dispositivo,TECNICO_id_Tecnico,tecnicoRecibio,ganancia,precio_refaccion) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = connection.prepareStatement(scriptid_Reparacion, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nota.getStatus());
            ps.setBoolean(2, nota.isEntregado());
            ps.setFloat(3, nota.getPrecio());
            ps.setFloat(4, nota.getAbono());
            ps.setString(5, nota.getFecha_recibido());
            ps.setString(6, nota.getHora_recibido());
            ps.setString(7, nota.getFecha_entregado());
            ps.setInt(8, idDispositivo);
            ps.setInt(9, idTecnico);
            ps.setString(10, nota.getTecnicoRecibio());
            ps.setFloat(11, nota.getGanancia());
            ps.setFloat(12, nota.getPrecio_refaccion());

            ps.executeUpdate();
            resp = true;

        } catch (SQLException ex) {
            Logger.getLogger(BaseInkacells.class.getName()).log(Level.SEVERE, null, ex);
            Notify.NotifyError("La base de Datos no pudo Crear la Nota\n Exepcion: " + ex.getSQLState());
        }
        return resp;
    }

    public static int addGastosBD(Gastos gasto) {
        int generatedId = -1;
        try {
            @Cleanup
            PreparedStatement ps = null;
            @Cleanup
            ResultSet rs = null;
            String scriptTecnico = "insert into GASTOS(fechaGastos,precio,razon) values(?,?,?)";
            ps = connection.prepareStatement(scriptTecnico, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, gasto.getFecha());
            ps.setFloat(2, gasto.getPrecio());
            ps.setString(3, gasto.getRazon());

            var filasInsertadas = ps.executeUpdate();

            if (filasInsertadas > 0) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
            }
            return generatedId;

        } catch (SQLException ex) {
            Notify.NotifyError("La base de Datos no pudo agregar los Gastos\n Exepcion: " + ex.getSQLState());
        }
        return generatedId;
    }

    public static List<NotaFilter> getSearchByFilter(String search, Filter filter) {
        List<NotaFilter> list = null;
        try {
            @Cleanup
            PreparedStatement ps = null;
            @Cleanup
            ResultSet rs = null;
            list = new ArrayList<NotaFilter>();

            String query = getQueryFilter(filter);

            String sql = "SELECT * "
                    + "FROM CLIENTE AS c "
                    + "JOIN DISPOSITIVO AS d ON c.idCLIENTE = d.CLIENTE_idCLIENTE "
                    + "JOIN NOTA AS n ON d.id_Dispositivo = n.DISPOSITIVO_id_Dispositivo "
                    + "JOIN TECNICO AS t ON n.TECNICO_id_Tecnico = t.id_Tecnico "
                    + "WHERE " + query;

            ps = connection.prepareStatement(sql);
            switch (filter) {
                case iD_CLIENTE:
                    if (!existsCliente(Integer.valueOf(search))) {
                        return null;
                    }
                    ps.setInt(1, Integer.valueOf(search));
                    break;
                case iD_DISPOSITIVO:
                    if (!existsDispositivo(Integer.valueOf(search))) {
                        return null;
                    }
                    ps.setInt(1, Integer.valueOf(search));
                    break;

                default:
                    ps.setString(1, search);
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new NotaFilter(rs.getInt("c.idCLIENTE"),
                        rs.getInt("n.DISPOSITIVO_id_Dispositivo"),
                        rs.getString("d.name_dispositivo"),
                        rs.getString("d.marca"),
                        rs.getString("d.modelo"),
                        rs.getString("t.nombre"),
                        rs.getString("d.reparacion"),
                        rs.getFloat("n.precio"),
                        rs.getFloat("n.ganancia"),
                        rs.getString("n.fecha_recibido"),
                        rs.getString("n.hora_recibido"),
                        rs.getString("n.fecha_entregado"),
                        rs.getString("n.statusR"),
                        rs.getBoolean("n.entregado")));
            }
            System.out.println(list.isEmpty() ? "Lista vacia" : "Lista con algo");
            return list;

        } catch (SQLException e) {
            System.out.println("aqui");
            Notify.NotifyError("Hubo un Error al Encontrar al Dispositivo\n Exepcion: " + e.getSQLState());
        }
        return list;
    }

    private static String getQueryFilter(Filter filter) {
        String str = "";
        switch (filter) {
            case iD_CLIENTE:
                str = "d.CLIENTE_idCLIENTE = ?";
                break;
            case DATE:
                str = "n.fecha_recibido = ?";
                break;
            case DATE_ENTREGADO:
                str = "n.fecha_entregado = ?";
                break;
            case TECNICO:
                str = "t.nombre = ? ORDER BY c.idCLIENTE DESC";
                break;
            default:
                str = "";

        }
        return str;
    }

    public static List<NotaFilter> getSearchByAll() {
        List<NotaFilter> list = null;
        try {
            @Cleanup
            Statement statement = null;
            @Cleanup
            ResultSet rs = null;
            list = new ArrayList<NotaFilter>();

            String sql = "SELECT * "
                    + "FROM CLIENTE AS c "
                    + "JOIN DISPOSITIVO AS d ON c.idCLIENTE = d.CLIENTE_idCLIENTE "
                    + "JOIN NOTA AS n ON d.id_Dispositivo = n.DISPOSITIVO_id_Dispositivo "
                    + "JOIN TECNICO AS t ON n.TECNICO_id_Tecnico = t.id_Tecnico "
                    + "ORDER BY c.idCLIENTE DESC";

            statement = connection.createStatement();
            rs = statement.executeQuery(sql);

            while (rs.next()) {
                list.add(new NotaFilter(rs.getInt("c.idCLIENTE"),
                        rs.getInt("n.DISPOSITIVO_id_Dispositivo"),
                        rs.getString("d.name_dispositivo"),
                        rs.getString("d.marca"),
                        rs.getString("d.modelo"),
                        rs.getString("t.nombre"),
                        rs.getString("d.reparacion"),
                        rs.getFloat("n.precio"),
                        rs.getFloat("n.ganancia"),
                        rs.getString("n.fecha_recibido"),
                        rs.getString("n.hora_recibido"),
                        rs.getString("n.fecha_entregado"),
                        rs.getString("n.statusR"),
                        rs.getBoolean("n.entregado")));
            }
            return list;

        } catch (SQLException e) {
            Notify.NotifyError("Hubo un Error\n Exepcion: " + e.getLocalizedMessage());
        }
        return list;
    }

    public static List<NotaEtiqueta> getSearchByEtiqueta(int idClientePrint) {
        List<NotaEtiqueta> list = null;
        try {
            @Cleanup
            PreparedStatement ps = null;
            @Cleanup
            ResultSet rs = null;
            list = new ArrayList<NotaEtiqueta>();

            String sql = "SELECT * "
                    + "FROM CLIENTE AS c "
                    + "JOIN DISPOSITIVO AS d ON c.idCLIENTE = d.CLIENTE_idCLIENTE "
                    + "JOIN NOTA AS n ON d.id_Dispositivo = n.DISPOSITIVO_id_Dispositivo "
                    + "JOIN TECNICO AS t ON n.TECNICO_id_Tecnico = t.id_Tecnico "
                    + "WHERE d.CLIENTE_idCLIENTE = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, idClientePrint);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new NotaEtiqueta(rs.getInt("n.DISPOSITIVO_id_Dispositivo"),
                        rs.getString("d.name_dispositivo"),
                        rs.getString("d.marca"),
                        rs.getString("d.modelo"),
                        rs.getString("d.reparacion"),
                        rs.getString("d.observacion"),
                        rs.getString("t.nombre"),
                        rs.getFloat("n.precio"),
                        rs.getFloat("n.abono"),
                        rs.getString("n.fecha_recibido"),
                        rs.getString("n.hora_recibido")));
            }
            return list;

        } catch (SQLException e) {
            Notify.NotifyError("Hubo un Error\n Exepcion: " + e.getLocalizedMessage());
        }
        return list;
    }

    public static boolean existsCliente(int idCliente) {
        try {
            @Cleanup
            PreparedStatement ps = null;
            @Cleanup
            ResultSet rs = null;

            String sql = "SELECT COUNT(*) FROM CLIENTE WHERE idCLIENTE = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getInt(1) > 0 ? "ID ENTRADO" : "ID NO ENTRADO");
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            Notify.NotifyError("Nose Encontro el Folio");
        }
        return false;
    }

    public static Cliente getCliente(int idCliente) {
        Cliente cliente;
        try {
            @Cleanup
            PreparedStatement ps = null;
            @Cleanup
            ResultSet rs = null;
            cliente = null;

            String sql = "SELECT * "
                    + "FROM CLIENTE "
                    + "WHERE idCLIENTE = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();

            if (rs.next()) {
                cliente = new Cliente(rs.getString("nombre"),
                        rs.getString("domicilio"),
                        rs.getString("telefono_movil"),
                        rs.getString("telefono_fijo"));
            }
            return cliente;
        } catch (SQLException e) {
            Notify.NotifyError("Nose Encontro el Folio");
        }
        return null;
    }

    public static List<Gastos> getGastos(String date) {
        List<Gastos> gastos;
        try {
            @Cleanup
            PreparedStatement ps = null;
            @Cleanup
            ResultSet rs = null;
            gastos = new ArrayList<>();

            String sql = "SELECT * "
                    + "FROM GASTOS "
                    + "WHERE fechaGastos = ?";

            ps = connection.prepareStatement(sql);
            ps.setString(1, date);
            rs = ps.executeQuery();

            while (rs.next()) {
                gastos.add(new Gastos(null,
                        rs.getFloat("precio"),
                        rs.getString("razon"),
                        rs.getInt("id")));
            }
            return gastos;
        } catch (SQLException e) {
            Notify.NotifyError("Al Obtener la Lista de Costos");
        }
        return null;
    }

    public static List<DispositivoAndNota> getDispositivosAndNotasByCliente(int idCliente) {
        List<DispositivoAndNota> list;
        try {
            @Cleanup
            PreparedStatement ps = null;
            @Cleanup
            ResultSet rs = null;
            list = new ArrayList<>();

            String sql = "SELECT * "
                    + "FROM CLIENTE AS c "
                    + "JOIN DISPOSITIVO AS d ON c.idCLIENTE = d.CLIENTE_idCLIENTE "
                    + "JOIN NOTA AS n ON d.id_Dispositivo = n.DISPOSITIVO_id_Dispositivo "
                    + "JOIN TECNICO AS t ON n.TECNICO_id_Tecnico = t.id_Tecnico "
                    + "WHERE d.CLIENTE_idCLIENTE = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();

            while (rs.next()) {
                float precio = rs.getFloat("n.precio");
                float abona = rs.getFloat("n.abono");
                float resta = (precio - abona);

                list.add(new DispositivoAndNota(
                        rs.getString("d.name_dispositivo"),
                        rs.getString("d.marca"),
                        rs.getString("d.modelo"),
                        rs.getString("d.reparacion"),
                        rs.getString("d.observacion"),
                        rs.getString("n.tecnicoRecibio"),
                        rs.getString("t.nombre"),
                        precio,
                        resta,
                        abona));
            }
            System.out.println(list.isEmpty() ? "Lista vacia" : "Lista con algo");
            return list;

        } catch (SQLException e) {
            Notify.NotifyError("Nose Encontro el Folio");
        }
        return null;
    }

    public static List<DispositivoAndNota> getDispositivosAndNotasByDispositivo(int idDispositivo) {
        List<DispositivoAndNota> list;
        try {
            @Cleanup
            PreparedStatement ps = null;
            @Cleanup
            ResultSet rs = null;
            list = new ArrayList<>();

            String sql = "SELECT * "
                    + "FROM CLIENTE AS c "
                    + "JOIN DISPOSITIVO AS d ON c.idCLIENTE = d.CLIENTE_idCLIENTE "
                    + "JOIN NOTA AS n ON d.id_Dispositivo = n.DISPOSITIVO_id_Dispositivo "
                    + "JOIN TECNICO AS t ON n.TECNICO_id_Tecnico = t.id_Tecnico "
                    + "WHERE d.id_Dispositivo = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, idDispositivo);
            rs = ps.executeQuery();

            while (rs.next()) {
                float precio = rs.getFloat("n.precio");
                float abona = rs.getFloat("n.abono");
                float resta = (precio - abona);

                list.add(new DispositivoAndNota(
                        rs.getString("d.name_dispositivo"),
                        rs.getString("d.marca"),
                        rs.getString("d.modelo"),
                        rs.getString("d.reparacion"),
                        rs.getString("d.observacion"),
                        rs.getString("n.tecnicoRecibio"),
                        rs.getString("t.nombre"),
                        precio,
                        resta,
                        abona));
            }
            System.out.println(list.isEmpty() ? "Lista vacia" : "Lista con algo");
            return list;

        } catch (SQLException e) {
            Notify.NotifyError("Nose Encontro el Folio");
        }
        return null;
    }

    public static boolean existsDispositivo(int idDispositivo) {
        try {
            @Cleanup
            PreparedStatement ps = null;
            @Cleanup
            ResultSet rs = null;

            String sql = "SELECT COUNT(*) FROM CLIENTE WHERE id_Dispositivo = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, idDispositivo);
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getInt(1) > 0 ? "ID ENTRADO" : "ID NO ENTRADO");
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            Notify.NotifyError("Nose Encontro el Dispositivo");
        }
        return false;
    }

    public static Object[] getAllDispositivo(int idDispostivo) {
        Object[] objects = null;
        try {
            @Cleanup
            PreparedStatement ps = null;
            @Cleanup
            ResultSet rs = null;
            objects = new Object[24];

            String sql = "SELECT * "
                    + "FROM CLIENTE AS c "
                    + "JOIN DISPOSITIVO AS d ON c.idCLIENTE = d.CLIENTE_idCLIENTE "
                    + "JOIN NOTA AS n ON d.id_Dispositivo = n.DISPOSITIVO_id_Dispositivo "
                    + "JOIN TECNICO AS t ON n.TECNICO_id_Tecnico = t.id_Tecnico "
                    + "WHERE n.DISPOSITIVO_id_Dispositivo = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, idDispostivo);

            rs = ps.executeQuery();

            if (rs.next()) {

                objects[0] = rs.getString("c.idCLIENTE");
                objects[1] = rs.getString("c.nombre");
                objects[2] = rs.getString("c.domicilio");
                objects[3] = rs.getString("c.telefono_movil");
                objects[4] = rs.getString("c.telefono_fijo");

                objects[5] = rs.getInt("d.id_Dispositivo");
                objects[6] = rs.getString("d.name_dispositivo");
                objects[7] = rs.getString("d.marca");
                objects[8] = rs.getString("d.modelo");
                objects[9] = rs.getString("d.imei_serial");
                objects[10] = rs.getString("d.observacion");

                objects[11] = rs.getString("d.reparacion");
                objects[12] = rs.getString("n.statusR");
                objects[13] = rs.getString("n.fecha_recibido");
                objects[14] = rs.getString("n.hora_recibido");
                objects[15] = rs.getString("n.tecnicoRecibio");
                objects[16] = rs.getString("t.nombre");
                objects[17] = rs.getBoolean("n.entregado");

                float precio = rs.getFloat("n.precio");
                float abona = rs.getFloat("n.abono");
                float resta = (precio - abona);

                objects[18] = abona;
                objects[19] = resta;
                objects[20] = precio;
                float ganancia = rs.getFloat("n.ganancia");
                objects[21] = ganancia;
                objects[22] = rs.getString("n.fecha_entregado");
                objects[23] = rs.getFloat("n.precio_refaccion");
            }

            return objects;

        } catch (SQLException e) {
            Notify.NotifyError("Hubo un Error al Encontrar al Dispositivo\n Exepcion: " + e.getSQLState());
        }
        return objects;
    }

    public static float getGananciasFilterDateEntrega(String search) {
        float ganancias = 0.0f;
        try {
            @Cleanup
            PreparedStatement ps = null;
            @Cleanup
            ResultSet rs = null;

            String sql = "SELECT * "
                    + "FROM NOTA "
                    + "WHERE fecha_entregado = ?";

            ps = connection.prepareStatement(sql);
            ps.setString(1, search);

            rs = ps.executeQuery();

            while (rs.next()) {
                ganancias += rs.getFloat("ganancia");
            }
            return ganancias;

        } catch (SQLException e) {
            Notify.NotifyError("Hubo un Error al Obtener Las Ganancias\n Exepcion: " + e.getSQLState());
        }
        return ganancias;
    }

    public static float getGastosByDate(String search) {
        float gastos = 0.0f;
        try {
            @Cleanup
            PreparedStatement ps = null;
            @Cleanup
            ResultSet rs = null;

            String sql = "SELECT * "
                    + "FROM GASTOS "
                    + "WHERE fechaGastos = ?";

            ps = connection.prepareStatement(sql);
            ps.setString(1, search);

            rs = ps.executeQuery();

            while (rs.next()) {
                gastos += rs.getFloat("precio");
            }
            return gastos;

        } catch (SQLException e) {
            Notify.NotifyError("Hubo un Error al Obtener Los Gastos\n Exepcion: " + e.getSQLState());
        }
        return gastos;
    }

    public static int getCountDispositivos() {
        try {
            @Cleanup
            PreparedStatement ps = null;
            @Cleanup
            ResultSet rs = null;
            String sql = "SELECT COUNT(*) FROM DISPOSITIVO";

            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            Notify.NotifyError("Excepcion: " + e);
            return -1;
        }
        return -1;
    }

    public static Map<Integer, String> getListTecnicos() {
        Map<Integer, String> map = null;
        try {
            @Cleanup
            Statement statement = null;
            @Cleanup
            ResultSet rs = null;

            map = new HashMap<>();
            statement = connection.createStatement();

            String sql = "SELECT * FROM TECNICO";
            rs = statement.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id_Tecnico");
                String name = rs.getString("nombre");
                map.put(id, name);
            }
            return map;

        } catch (SQLException e) {
            Notify.NotifyError("La base de Datos no pudo Obtener la Lista de los Tecnicos\n Exepcion: " + e.getSQLState());
        }
        return map;
    }

    public static List<String> getListMarca() {
        List<String> list = null;
        try {
            @Cleanup
            Statement statement = null;
            @Cleanup
            ResultSet rs = null;

            list = new ArrayList<>();
            statement = connection.createStatement();

            String sql = "SELECT * FROM MARCA";
            rs = statement.executeQuery(sql);

            while (rs.next()) {
                list.add(rs.getString("nombre"));
            }
            return list;

        } catch (SQLException e) {
            Notify.NotifyError("La base de Datos no pudo Obtener la Lista de Marcas\n Exepcion: " + e.getSQLState());
        }
        return list;
    }

    public static List<String> getListTipoDispositivos() {
        List<String> list = null;
        try {
            @Cleanup
            Statement statement = null;
            @Cleanup
            ResultSet rs = null;

            list = new ArrayList<>();
            statement = connection.createStatement();

            String sql = "SELECT * FROM TIPOS_DISPOSTIVOS";
            rs = statement.executeQuery(sql);

            while (rs.next()) {
                list.add(rs.getString("dispositvo"));
            }
            return list;

        } catch (SQLException e) {
            Notify.NotifyError("La base de Datos no pudo Obtener la Lista de los Dispositivos\n Exepcion: " + e.getSQLState());
        }
        return list;
    }

    public static Boolean setDispositivoByIdDispositivo(String status, Boolean entregado, int idDispositivo, float precio, float abono, float ganancia, String fecha_entregado, int tecnico, float refaccion) {
        try {
            @Cleanup
            PreparedStatement ps = null;

            String sql = "UPDATE NOTA SET statusR = ?,entregado = ?,fecha_entregado = ?,precio = ?,abono = ?,ganancia = ?,TECNICO_id_Tecnico = ?,precio_refaccion = ? WHERE DISPOSITIVO_id_Dispositivo = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, status);
            ps.setBoolean(2, entregado);
            ps.setString(3, fecha_entregado);
            ps.setFloat(4, precio);
            ps.setFloat(5, abono);
            ps.setFloat(6, ganancia);
            ps.setInt(7, tecnico);
            ps.setFloat(8, refaccion);
            ps.setInt(9, idDispositivo);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            if (e.getMessage().contains("Data too long")) {
                Notify.NotifyError("Has Revasado el Limite de Caracteres");
            } else {
                Notify.NotifyError("Ocurrio un Error al Actualizar los Datos\n Excepcion: " + e);
            }
            return false;
        }
    }

    public static Boolean setGananciaByIdDispositivo(int idDispositivo, float ganancia) {
        try {
            @Cleanup
            PreparedStatement ps = null;

            String sql = "UPDATE NOTA SET ganancia = ? WHERE DISPOSITIVO_id_Dispositivo = ?";
            ps = connection.prepareStatement(sql);
            ps.setFloat(1, ganancia);
            ps.setInt(2, idDispositivo);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            if (e.getMessage().contains("Data too long")) {
                Notify.NotifyError("Has Revasado el Limite de Caracteres");
            } else {
                Notify.NotifyError("Ocurrio un Error al Actualizar los Datos\n Excepcion: " + e);
            }
            return false;
        }
    }

    public static Boolean setObservacionAndReparacionByIdDispositivo(int idDispositivo, String observacion, String reparacion, String modelo) {
        try {
            @Cleanup
            PreparedStatement ps = null;

            String sql = "UPDATE DISPOSITIVO SET observacion = ?,reparacion = ?,modelo = ? WHERE id_Dispositivo = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, observacion);
            ps.setString(2, reparacion);
            ps.setString(3, modelo);
            ps.setInt(4, idDispositivo);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            if (e.getMessage().contains("Data too long")) {
                Notify.NotifyError("Has Revasado el Limite de Caracteres");
            } else {
                Notify.NotifyError("Ocurrio un Error al Actualizar los Datos\n Excepcion: " + e);
            }
            return false;
        }
    }

    public static Boolean setKeyImpresora(String key_value) {
        try {
            @Cleanup
            PreparedStatement ps = null;

            String sql = "UPDATE LICENCIA SET value_key = ? WHERE id = 1";
            ps = connection.prepareStatement(sql);
            ps.setString(1, key_value);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            if (e.getMessage().contains("Data too long")) {
                Notify.NotifyError("Has Revasado el Limite de Caracteres");
            } else {
                Notify.NotifyError("Ocurrio un Error al Insertar la Key\n Excepcion: " + e);
            }
            return false;
        }
    }

    public static String getKeyImpresora() {
        String key = "";
        try {
            @Cleanup
            PreparedStatement ps = null;
            @Cleanup
            ResultSet rs = null;

            String sql = "SELECT * FROM LICENCIA WHERE id = 1";

            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                key = rs.getString("value_key");
            }
            return key;

        } catch (SQLException e) {
            Notify.NotifyError("Ocurrio un Error al Insertar la Key\n Excepcion: " + e);
            return key;
        }
    }

    public static int deleteGastoByID(int id) {
        String key = "";
        try {
            @Cleanup
            PreparedStatement ps = null;

            String sql = "DELETE FROM GASTOS WHERE id = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();

            System.out.println(filasAfectadas);
            return filasAfectadas;
        } catch (SQLException e) {
            Notify.NotifyError("Ocurrio un Error Al Eliminar El Gasto\n Excepcion: " + e);
            return 0;
        }
    }
}
