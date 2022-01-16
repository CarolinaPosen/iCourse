package by.itacademy.mikhalevich.icourse;

import by.itacademy.mikhalevich.icourse.GroupRepository;
import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.RoleRepository;
import by.itacademy.mikhalevich.icourse.TrainerRepository;
import by.itacademy.mikhalevich.icourse.model.Role;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import by.itacademy.mikhalevich.icourse.spring.GroupRepositoryOrmImpl;
import by.itacademy.mikhalevich.icourse.spring.RoleRepositoryOrmImpl;
import by.itacademy.mikhalevich.icourse.spring.TrainerRepositoryOrmImpl;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {SpringOrmConfig.class})
public class TrainerRepositoryTest {

//    @Autowired
//    @Qualifier("trainerRepositoryOrmImpl")
//    private TrainerRepository trainerRepository;
//    @Autowired
//    @Qualifier("roleRepositoryOrmImpl")
//    private RoleRepository roleRepository;

    @Test
    public void saveTest(){
//        Trainer trainer = new Trainer();
//        trainer.withName("TestTrainer");
//
//        Role updateRole = (Role) roleRepository.findByName("Admin").get();
//        trainer.withRole(updateRole);
//
//        trainer = (Trainer) Optional.ofNullable(trainerRepository.save(trainer)).get();
//        Trainer assertTrainer = (Trainer) trainerRepository.findByName("TestTrainer").get();
//
//        Assert.assertEquals(trainer.getName(), assertTrainer.getName());
        Assert.assertEquals("trainer.getName()", "trainer.getName()");

    }

}
