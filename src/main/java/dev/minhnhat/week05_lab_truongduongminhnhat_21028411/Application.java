package dev.minhnhat.week05_lab_truongduongminhnhat_21028411;

import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.enums.SkillType;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.Skill;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.services.impl.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
