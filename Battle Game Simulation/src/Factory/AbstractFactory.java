package Factory;
import ItemAndDecorator.IItem;

public interface AbstractFactory {
	public IItem create(String type) ;
}
