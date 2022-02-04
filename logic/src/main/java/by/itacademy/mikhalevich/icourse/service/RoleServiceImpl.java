package by.itacademy.mikhalevich.icourse.service;

import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.RoleService;
import by.itacademy.mikhalevich.icourse.ThemeService;
import by.itacademy.mikhalevich.icourse.factory.RepositoryFactory;
import by.itacademy.mikhalevich.icourse.model.Theme;
import by.itacademy.mikhalevich.icourse.model.auth.Role;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;

@Slf4j
public class RoleServiceImpl implements RoleService {

    public static final int PARAMETER_INDEX = 4;
    private Repository roleRepository;

    public RoleServiceImpl()  {
        this.roleRepository = RepositoryFactory.getRoleRepository();
    }

    @Override
    public Map<Integer, Role> read() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> update(Role role) {
        roleRepository.save(role);
        return null;
    }

    @Override
    public Optional<Role> create(Role role) {
        return null;
    }

    @Override
    public Optional<Role> delete(Integer id) {
        return null;
    }

    @Override
    public Optional<Role> getById(Integer id) {
        Optional<Role> role = roleRepository.find(id);
        if (role.isPresent()) {
            return role;
        } else {
            log.error("Theme id: "+ id +" not exists");
            return Optional.of(new Role());
        }
    }
}
