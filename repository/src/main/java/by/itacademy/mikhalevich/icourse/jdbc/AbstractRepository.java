package by.itacademy.mikhalevich.icourse.jdbc;

import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.exception.DataBaseErrorException;
import by.itacademy.mikhalevich.icourse.model.AbstractEntity;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;

@Slf4j
public abstract class AbstractRepository<T extends AbstractEntity> implements Repository<T> {
    private static final int POSITION_ID = 1;

    protected DataSource dataSource;

    protected abstract String selectAllFields();

    protected abstract String findById();

    protected abstract String insertSql();

    protected abstract String updateSql();

    protected abstract String deleteSql();

    protected abstract Map<Integer, T> resultSetToEntities(ResultSet rs) throws SQLException;

    protected abstract void insertLogic(T entity, PreparedStatement ps) throws SQLException;

    protected abstract void updateLogic(T entity, PreparedStatement ps) throws SQLException;

    @Override
    public Map<Integer, T> findAll() {
        Map<Integer, T> result;
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(selectAllFields());
             ResultSet rs = ps.executeQuery()) {
            result = resultSetToEntities(rs);
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DataBaseErrorException(e);
        }
        return result;
    }

    @Override
    public Optional<T> find(Integer id) {
        Map<Integer, T> result;
        ResultSet rs = null;
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(findById())) {
            ps.setInt(POSITION_ID, id);
            rs = ps.executeQuery();
            result = resultSetToEntities(rs);
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DataBaseErrorException(e);
        } finally {
            closeQuietly(rs);
        }
        //return result.stream().findAny();
        return Optional.ofNullable(result.get(id));
    }

    @Override
    public T save(T entity) {
        return entity.getId() == null ? insert(entity) : update(entity);
    }

    private T insert(T entity) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(insertSql())) {
            insertLogic(entity, ps);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                entity.setId(rs.getInt(POSITION_ID));
                return entity;
            }
            return null;
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DataBaseErrorException(e);
        }
    }

    private T update(T entity) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(updateSql())) {
            updateLogic(entity, ps);
            ps.setInt(5, (Integer) entity.getId());
            if (ps.executeUpdate() > 0) {
                return entity;
            }
            return null;
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DataBaseErrorException(e);
        }
    }

    @Override
    public Optional<T> remove(Integer id) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(deleteSql())) {
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                return Optional.empty();
            }
            return Optional.empty();
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DataBaseErrorException(e);
        }
    }

    private static void closeQuietly(AutoCloseable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e) {
            log.error("Couldn't close {}", closeable);
        }
    }

    protected static <K, V> V putIfAbsentAndReturn(Map<K, V> map, K key, V value) {
        if (key == null) {
            return null;
        }
        map.putIfAbsent(key, value);
        return map.get(key);
    }
}