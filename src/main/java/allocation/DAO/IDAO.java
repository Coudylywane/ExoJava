package allocation.DAO;

import java.util.List;

public interface IDAO<T> {
    boolean add(T t);
    List<T> getAll();
    T getById(int id);
    boolean delete(T t);
}
