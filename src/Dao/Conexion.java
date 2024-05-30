
package Dao;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author karie
 */
public class Conexion {

    Connection cn;

    public Connection getConnection() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "root"; //el usuario sera root
        String clave = ""; //No pondremos clave por ende queda vacio
        String url = "jdbc:mysql://localhost:3306/proyecto_clinica"; //La direccion de nuestra base de datos
        try {
            Class.forName(driver);
            this.cn = DriverManager.getConnection(url, user, clave);
        } catch (Exception ex) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en la conexion", DesktopNotify.ERROR, 4000);
        }
        return cn;
    }

    public void closeConexion(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                DesktopNotify.setDefaultTheme(NotifyTheme.Red);
                DesktopNotify.showDesktopMessage("Error", "Error en la conexion", DesktopNotify.ERROR, 4000);
            }
        }
    }
}

