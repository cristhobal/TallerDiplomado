/**
 * 
 */
package cl.udechile.diplomado.tallerdeproyectos.service;

import cl.udechile.diplomado.tallerdeproyectos.model.Login;
import cl.udechile.diplomado.tallerdeproyectos.model.User;

/**
 * @author wiriarte
 *
 */
public interface UserService {

	public abstract void register(User user);
	public abstract User validateUser(Login login);
}
