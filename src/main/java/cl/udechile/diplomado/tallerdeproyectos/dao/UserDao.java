/**
 * 
 */
package cl.udechile.diplomado.tallerdeproyectos.dao;

import cl.udechile.diplomado.tallerdeproyectos.model.Login;
import cl.udechile.diplomado.tallerdeproyectos.model.User;

/**
 * @author wiriarte
 *
 */
public interface UserDao {

	  void register(User user);
	  User validateUser(Login login);
}
