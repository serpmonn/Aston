package customcollections;

import java.util.*;

/**
 * Собственная реализация динамического массива (ArrayList).
 * Поддерживает основные операции добавления, удаления, сортировки и поиска элементов.
 *
 * @param <T> тип элементов, хранимых в списке. Должен реализовывать интерфейс {@link Comparable} для сортировки.
 */
public class CustomArrayList<T extends Comparable<T>> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * Конструктор создает список с начальной емкостью по умолчанию.
     */
    public CustomArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    /**
     * Добавляет элемент в конец списка.
     *
     * @param element элемент, который нужно добавить.
     */
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }
    /**
     * Вставляет элемент в указанную позицию в списке.
     * Сдвигает существующие элементы вправо.
     *
     * @param index позиция для вставки элемента.
     * @param element элемент, который нужно добавить.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы текущего размера списка.
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }
    /**
     * Получает элемент по индексу.
     *
     * @param index индекс элемента.
     * @return элемент списка на указанной позиции.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка.
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        return (T) elements[index];
    }
    /**
     * Удаляет элемент по индексу и сдвигает оставшиеся элементы влево.
     *
     * @param index индекс удаляемого элемента.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка.
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }
    /**
     * Очищает список, удаляя все элементы.
     */
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }
    /**
     * Возвращает текущее количество элементов в списке.
     *
     * @return количество элементов.
     */
    public int size() {
        return size;
    }
    /**
     * Проверяет, содержит ли список указанный элемент.
     *
     * @param element элемент для поиска.
     * @return true, если элемент найден, иначе false.
     */
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], element)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Обеспечивает увеличение емкости списка при необходимости.
     */
    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }
    /**
     * Выполняет быструю сортировку (QuickSort) списка.
     */
    public void quickSort() {
        quickSort(0, size - 1);
    }
    /**
     * Рекурсивный метод быстрой сортировки.
     *
     * @param low начальный индекс.
     * @param high конечный индекс.
     */
    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }
    /**
     * Разделяет массив на две части относительно опорного элемента.
     *
     * @param low начальный индекс.
     * @param high конечный индекс.
     * @return индекс опорного элемента после разделения.
     */
    private int partition(int low, int high) {
        T pivot = get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (get(j).compareTo(pivot) < 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }
    /**
     * Обменивает местами два элемента списка.
     *
     * @param i индекс первого элемента.
     * @param j индекс второго элемента.
     */
    private void swap(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
}
