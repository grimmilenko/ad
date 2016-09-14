package aufgabenblatt1;

/**
 * Eine Klasse zur Darstellung eines Interfaces
 * 
 * @author Robert R�sler (robert.roesler@haw-hamburg.de), Nico Grimm
 *         (nico.grimm@haw-hamburg.de)
 * 
 *         Algorithmen und Datenstrukturen - Praktikum AD -- SS16
 *
 * @param <T>
 */
public interface I_Liste<T> {
	/**
	 * Diese Methode f�gt ein neues Element an eine g�ltige Stelle der Liste.
	 * 
	 * @param pos
	 *            Position, an die das neue Element eingef�gt werden soll.
	 * @param elem
	 *            Das einzuf�gende Element.
	 */
	public void insert(int pos, T elem) throws Exception;

	/**
	 * Die Methode entfernt ein Element an einer g�ltigen Position.
	 * 
	 * @param pos
	 *            Position, an der ein Element entfernt werden soll.
	 */
	public void delete(int pos) throws IndexOutOfBoundsException;

	/**
	 * Die Methode sucht nach einem bestimmten Element in der Liste.
	 * 
	 * @param elem
	 *            Element, welches gesucht wird.
	 * @return Gibt die Position des gefundenen Element zur�ck.
	 */
	public int find(T elem);

	/**
	 * Die Methode sucht ein Element an einer gew�hlten Position in der Liste.
	 * 
	 * @param pos
	 *            Position, an welcher ein Element gefunden werden soll.
	 * @return Gibt das gefundene Element zur�ck.
	 */
	public T retrieve(int pos) throws IndexOutOfBoundsException;

	/**
	 * Die Methode verkn�pft zwei Listen miteinander.
	 * 
	 * @param otherList
	 *            Die anzuh�ngende Liste.
	 */
	public void concat(I_Liste<T> otherList) throws NullPointerException;

	/**
	 * Die Methode berechnet die Gr��e der Liste.
	 * 
	 * @return Gibt die Anzahl der Elemente in der Liste zur�ck.
	 */
	public int size();
}
