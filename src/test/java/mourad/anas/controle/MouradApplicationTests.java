package mourad.anas.controle;

import mourad.anas.controle.models.ClasseMourad;
import mourad.anas.controle.repositories.ClasseMouradRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
class MouradApplicationTests {
    @Autowired
    ClasseMouradRepository classeRepository;

    @Test
    public void testClasseMouradRepositoryFindAll() {
        ClasseMourad testClasseMourad1 = new ClasseMourad();
        testClasseMourad1.setNiveau("TEST1");
        classeRepository.save(testClasseMourad1);

        ClasseMourad testClasseMourad2 = new ClasseMourad();
        testClasseMourad2.setNiveau("TEST2");
        classeRepository.save(testClasseMourad2);

        List<ClasseMourad> testClassesMourad = classeRepository.findAll();
        assertTrue(testClassesMourad.size() > 0);
    }

    @Test
    public void testClasseMouradRepositorySave() {
        ClasseMourad testClasseMourad = new ClasseMourad();
        testClasseMourad.setNiveau("4IIR");

        ClasseMourad savedTestClasseMourad = classeRepository.save(testClasseMourad);
        assertEquals("4IIR", savedTestClasseMourad.getNiveau());
    }
}
