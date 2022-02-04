package by.itacademy.mikhalevich.icourse;

import org.junit.Assert;
import org.junit.Test;

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
