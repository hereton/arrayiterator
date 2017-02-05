package ku.util;

/**
 * Main class to test ArrayIterator.
 * 
 * @author totsapon menkul.
 *
 */
public class Main {
	public static void main(String[] args) {
		String[] fruit = { "apple", null, null, "banana" };
		ArrayIterator<String> it = new ArrayIterator<>(fruit);
		System.out.println(it.next());
		it.remove();
		System.out.println(fruit[0]);
		System.out.println(it.hasNext());
		System.out.println(it.next());
		

	}
}
