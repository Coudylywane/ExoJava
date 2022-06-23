package allocation.interfaces;

import java.util.List;

public interface IService<T> {
    List<T> getAll();
    boolean add(T t);
    T getById(int id);
    boolean delete(T t);
}
