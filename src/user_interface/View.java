package user_interface;

import javafx.scene.Group;

/*
 * @author Sebastian Whyte
 * @version 03/22/2022
 *
 */

public abstract class View extends Group
{
	
	public abstract void updateState(String key, String value);

}
