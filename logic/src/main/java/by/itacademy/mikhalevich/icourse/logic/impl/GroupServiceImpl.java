package by.itacademy.mikhalevich.icourse.logic.impl;

import by.itacademy.mikhalevich.icourse.jdbc.GroupRepository;
import by.itacademy.mikhalevich.icourse.jdbc.StudentRepository;
import by.itacademy.mikhalevich.icourse.logic.GroupService;
import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.repository.ListDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.util.HashMap;

public class GroupServiceImpl implements GroupService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceManager.class);

    public GroupServiceImpl() {
    }

    @Override
    public HashMap<Integer, Group> getAllGroups() {
        GroupRepository gr = new GroupRepository();
        return gr.getAllGroups();
    }

}
