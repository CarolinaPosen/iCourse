package by.itacademy.mikhalevich.icourse.service;

import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.RoleService;
import by.itacademy.mikhalevich.icourse.factory.RepositoryFactory;
import by.itacademy.mikhalevich.icourse.model.auth.Authority;
import by.itacademy.mikhalevich.icourse.model.auth.Role;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;

@Slf4j
public class AuthorityServiceImpl implements AuthorityService {

    public static final int PARAMETER_INDEX = 4;
    private Repository authorityRepository;

    public AuthorityServiceImpl()  {
        this.authorityRepository = RepositoryFactory.getAuthorityRepository();
    }

    @Override
    public Map<Integer, Authority> read() {
        return authorityRepository.findAll();
    }

    @Override
    public Optional<Authority> update(Authority role) {
        authorityRepository.save(role);
        return null;
    }

    @Override
    public Optional<Authority> create(Authority role) {
        return null;
    }

    @Override
    public Optional<Authority> delete(Integer id) {
        return null;
    }

    @Override
    public Optional<Authority> getById(Integer id) {
        Optional<Authority> role = authorityRepository.find(id);
        if (role.isPresent()) {
            return role;
        } else {
            log.error("Theme id: "+ id +" not exists");
            return Optional.of(new Authority());
        }
    }
}
