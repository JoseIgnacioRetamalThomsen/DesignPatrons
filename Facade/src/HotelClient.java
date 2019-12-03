interface Menus{
	
}

class MenuA implements Menus{
	
}

class MenuB implements Menus{
	
}

interface Hotel{
	public Menus getMenus();
}

class ReastaurantA implements Hotel{

	@Override
	public Menus getMenus() {
		// TODO Auto-generated method stub
		return new MenuA();
	}
	
}

class RestaurantB implements Hotel{

	@Override
	public Menus getMenus() {
		// TODO Auto-generated method stub
		return new MenuB();
	}
	
}

public class HotelClient {

}
