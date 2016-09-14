package aufgabenblatt1;

/**
 * Eine Klasse zur Darstellung eines Interfaces
 * 
 * @author Robert Rösler (robert.roesler@haw-hamburg.de), Nico Grimm
 *         (nico.grimm@haw-hamburg.de)
 * 
 *         Algorithmen und Datenstrukturen - Praktikum AD -- SS16
 *
 * @param <T>
 */
public interface I_Liste<T> {
	/**
	 * Diese Methode fügt ein neues Element an eine gültige Stelle der Liste.
	 * 
	 * @param pos
	 *            Position, an die das neue Element eingefügt werden soll.
	 * @param elem
	 *            Das einzufügende Element.
	 */
	public void insert(int pos, T elem) throws Exception;

	/**
	 * Die Methode entfernt ein Element an einer gültigen Position.
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
	 * @return Gibt die Position des gefundenen Element zurück.
	 */
	public int find(T elem);

	/**
	 * Die Methode sucht ein Element an einer gewählten Position in der Liste.
	 * 
	 * @param pos
	 *            Position, an welcher ein Element gefunden werden soll.
	 * @return Gibt das gefundene Element zurück.
	 */
	public T retrieve(int pos) throws IndexOutOfBoundsException;

	/**
	 * Die Methode verknüpft zwei Listen miteinander.
	 * 
	 * @param otherList
	 *            Die anzuhängende Liste.
	 */
	public void concat(I_Liste<T> otherList) throws NullPointerException;

	/**
	 * Die Methode berechnet die Größe der Liste.
	 * 
	 * @return Gibt die Anzahl der Elemente in der Liste zurück.
	 */
	public int size();
}
