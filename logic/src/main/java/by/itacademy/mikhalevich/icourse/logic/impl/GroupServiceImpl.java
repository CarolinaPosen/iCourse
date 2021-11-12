package by.itacademy.mikhalevich.icourse.logic.impl;

import by.itacademy.mikhalevich.icourse.jdbc.GroupRepositoryPostgres;
import by.itacademy.mikhalevich.icourse.jdbc.Repository;
import by.itacademy.mikhalevich.icourse.logic.GroupService;
import by.itacademy.mikhalevich.icourse.model.Group;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Optional;

public class GroupServiceImpl implements GroupService {
    private Repository groupRepository;

    public GroupServiceImpl(DataSource dataSource) {
        this.groupRepository = GroupRepositoryPostgres.getInstance(dataSource);
    }

    @Override
    public Map<Integer, Group> readGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Map<Integer, Group> updateGroup(Group teacher) {
        return null;
    }

    @Override
    public Map<Integer, Group> createGroup(Group teacher) {
        return null;
    }

    @Override
    public Map<Integer, Group> deleteGroup(Integer id) {
        return null;
    }

    @Override
    public Optional getGroupById(Integer id) {
        return groupRepository.find(id);
    }



}
